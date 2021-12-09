package com.projetointegrador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetointegrador.model.TemaModel;
import com.projetointegrador.model.enums.EscolaridadeEnum;
import com.projetointegrador.model.enums.TemaEnum;

@Repository
public interface TemaRepository extends JpaRepository<TemaModel, Long> {

	public List<TemaModel> findAllByTemaEnum(TemaEnum temaEnum);

	public List<TemaModel> findAllByEscolaridade(EscolaridadeEnum escolaridadeEnum);

	public List<TemaModel> findAllBySubtemaContainingIgnoreCase(String subtema);
	
}
