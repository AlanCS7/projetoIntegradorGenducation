package com.projetointegrador.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.projetointegrador.model.TemaModel;
import com.projetointegrador.model.enums.EscolaridadeEnum;
import com.projetointegrador.model.enums.TemaEnum;
import com.projetointegrador.repository.TemaRepository;

@RestController
@RequestMapping("/Genducation/tema")
@CrossOrigin("*")

public class TemaController {

	@Autowired
	private TemaRepository repository;

	// GET ALL
	@GetMapping
	public ResponseEntity<List<TemaModel>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	// GET BY ID
	@GetMapping("/{id}")
	public ResponseEntity<TemaModel> getById(@PathVariable(value = "id") long id) {
		return repository.findById(id).map(resp -> ResponseEntity.status(200).body(resp))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id não encontrado"));
	}

	@GetMapping("/nome/{temaEnum}")
	public ResponseEntity<List<TemaModel>> getTema(@PathVariable(value = "temaEnum") TemaEnum temaEnum) {
		return ResponseEntity.ok(repository.findAllByTemaEnum(temaEnum));
	}

	@GetMapping("/escolaridade/{escolaridadeEnum}")
	public ResponseEntity<List<TemaModel>> getEscolaridade(
			@PathVariable(value = "escolaridadeEnum") EscolaridadeEnum escolaridadeEnum) {
		return ResponseEntity.ok(repository.findAllByEscolaridade(escolaridadeEnum));
	}
	
	@GetMapping("/subtema/{subtema}")
	public ResponseEntity<List<TemaModel>> getSubtema(
			@PathVariable(value = "subtema") String subtema) {
		return ResponseEntity.ok(repository.findAllBySubtemaContainingIgnoreCase(subtema));
	}

	@PostMapping("/save")
	public ResponseEntity<TemaModel> post(@Valid @RequestBody TemaModel tema) {
		return ResponseEntity.status(201).body(repository.save(tema));
	}

	@PutMapping("/update")
	public ResponseEntity<TemaModel> put(@Valid @RequestBody TemaModel tema) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(tema));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		repository.deleteById(id);
	}

}
