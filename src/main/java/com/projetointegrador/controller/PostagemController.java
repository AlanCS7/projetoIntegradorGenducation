package com.projetointegrador.controller;

import java.util.List;

import javax.validation.Valid;

import com.projetointegrador.model.PostagemModel;
import com.projetointegrador.repository.PostagemRepository;
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

@RestController
@RequestMapping("/postagens")
@CrossOrigin("*")
public class PostagemController {

	@Autowired
	private PostagemRepository repository;

	// GET ALL
	@GetMapping
	public ResponseEntity<List<PostagemModel>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	// GET BY ID
	@GetMapping("/{id}")
	public ResponseEntity<PostagemModel> getById(@PathVariable(value = "id") long id) {
		return repository.findById(id).map(resp -> ResponseEntity.status(200).body(resp))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id não encontrado"));
	}

	// GET BY TITULO
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<PostagemModel>> GetByTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}

	// GET BY POSTAGEM
	@GetMapping("/postagem/{postagem}")
	public ResponseEntity<List<PostagemModel>> GetByTitulo(@PathVariable String postagem) {
		return ResponseEntity.ok(repository.findAllByPostagemContainingIgnoreCase(postagem));
	}

	@PostMapping("/save")
	public ResponseEntity<PostagemModel> post(@Valid @RequestBody PostagemModel postagem) {
		return ResponseEntity.status(201).body(repository.save(postagem));
	}

	@PutMapping("/update")
	public ResponseEntity<PostagemModel> put(@Valid @RequestBody PostagemModel postagem) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		repository.deleteById(id);
	}
}
