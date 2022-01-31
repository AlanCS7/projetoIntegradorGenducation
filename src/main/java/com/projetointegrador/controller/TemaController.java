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
import com.projetointegrador.repository.TemaRepository;

@RestController
@RequestMapping("/Genducation/tema")
@CrossOrigin("*")

public class TemaController {

	@Autowired
	private TemaRepository repository;

	
	@GetMapping
	public ResponseEntity<List<TemaModel>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<TemaModel> getById(@PathVariable(value = "id") long id) {
		return repository.findById(id).map(resp -> ResponseEntity.status(200).body(resp))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id não encontrado"));
	}

	@GetMapping("/nome/{tema}")
	public ResponseEntity<List<TemaModel>> getTema(@PathVariable(value = "tema") String tema) {
		return ResponseEntity.ok(repository.findAllByTemaEnum(tema));
	}

	@GetMapping("/escolaridade/{escolaridade}")
	public ResponseEntity<List<TemaModel>> getEscolaridade(
			@PathVariable(value = "escolaridade") String escolaridade) {
		return ResponseEntity.ok(repository.findAllByEscolaridade(escolaridade));
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
