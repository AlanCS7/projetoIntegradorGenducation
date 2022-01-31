package com.projetointegrador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetointegrador.model.TemaModel;

@Repository
public interface TemaRepository extends JpaRepository<TemaModel, Long> {

	public List<TemaModel> findAllByTemaContainingIgnoreCase(String tema);

	public List<TemaModel> findAllByEscolaridadeContainingIgnoreCase(String escolaridade);

	public List<TemaModel> findAllBySubtemaContainingIgnoreCase(String subtema);
	
}
