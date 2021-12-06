package com.projetointegrador.model;

import com.projetointegrador.model.enums.EscolaridadeEnum;
import com.projetointegrador.model.enums.TemaEnum;

public class TemaModel {

	private Long id_tema;
	private TemaEnum tema_enum;
	private String subtema;
	private EscolaridadeEnum escolaridade;

	public Long getId_tema() {
		return id_tema;
	}

	public void setId_tema(Long id_tema) {
		this.id_tema = id_tema;
	}

	public TemaEnum getTema_enum() {
		return tema_enum;
	}

	public void setTema_enum(TemaEnum tema_enum) {
		this.tema_enum = tema_enum;
	}

	public String getSubtema() {
		return subtema;
	}

	public void setSubtema(String subtema) {
		this.subtema = subtema;
	}

	public EscolaridadeEnum getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(EscolaridadeEnum escolaridade) {
		this.escolaridade = escolaridade;

	}

}
