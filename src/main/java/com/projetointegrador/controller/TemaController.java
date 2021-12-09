package com.projetointegrador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@GetMapping
	public ResponseEntity<List<TemaModel>> GetAll() {
		return ResponseEntity.ok(repository.findAll());

	}

	@GetMapping("/{temaEnum}")
	public ResponseEntity<List<TemaModel>> getTema(@PathVariable(value = "temaEnum") TemaEnum temaEnum) {
		return ResponseEntity.ok(repository.findAllByTemaEnum(temaEnum));
	}
	

	@GetMapping("/escolaridade/{escolaridadeEnum}")
	public ResponseEntity<List<TemaModel>> getEscolaridade(@PathVariable(value = "escolaridadeEnum") EscolaridadeEnum escolaridadeEnum) {
		return ResponseEntity.ok(repository.findAllByEscolaridade(escolaridadeEnum));
	}
}
