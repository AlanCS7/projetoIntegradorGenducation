package com.projetointegrador.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetointegrador.model.UsuarioModel;
import com.projetointegrador.model.dtos.UsuarioCredenciaisDTO;
import com.projetointegrador.model.dtos.UsuarioLoginDTO;
import com.projetointegrador.model.dtos.UsuarioRegistroDTO;
import com.projetointegrador.repository.UsuarioRepository;
import com.projetointegrador.service.UserServices;

@RestController
@RequestMapping("/Genducation/usuarios")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class UsuarioController {
	
	private @Autowired UsuarioRepository repository;
	private @Autowired UserServices services;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<UsuarioModel> save(@Valid @RequestBody UsuarioRegistroDTO newUser){
		return services.registerUser(newUser);
	}
	
	@PutMapping("/logar")
	public ResponseEntity<UsuarioCredenciaisDTO> credentials(@Valid @RequestBody UsuarioLoginDTO user){
		return services.getCredentials(user);
	}
	
	@GetMapping
	public ResponseEntity<?> getProfile(@RequestHeader("Authorization") String auth){
		return ResponseEntity.status(200).body(repository.findByToken(auth.replace("Basic ", "")));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioModel> findByEmail(@PathVariable(value = "id") String id) {
		return ResponseEntity.ok().body(repository.findByEmail(id).get());
	}

}
