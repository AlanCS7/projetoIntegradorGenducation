package com.projetointegrador.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetointegrador.model.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, String> {
	Optional<UsuarioModel> findByToken(String token);

	Optional<UsuarioModel> findByEmail(String email);

}
