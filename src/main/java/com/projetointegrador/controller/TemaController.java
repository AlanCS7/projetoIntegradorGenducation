package com.projetointegrador.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.projetointegrador.model.TemaModel;
import com.projetointegrador.repository.TemaRepository;

@RestController
@RequestMapping("/Genducation/tema")
@CrossOrigin("*")

public class TemaController {

	@Autowired
	private TemaRepository repository;

	@GetMapping
	public ResponseEntity<List<TemaModel>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@PostMapping("/save")
	public ResponseEntity<TemaModel> post(@Valid @RequestBody TemaModel tema){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));			
	}

}
