package com.projetointegrador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.projetointegrador.model.enums.EscolaridadeEnum;
import com.projetointegrador.model.enums.TemaEnum;

@Entity
@Table(name = "tb_tema")
public class TemaModel {

	@NotBlank
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTema;

	@Column(columnDefinition = "ENUM('EXATAS', 'HUMANAS', 'BIOLOGICAS', 'TECNOLOGIA', 'LIVRE')")
	@Enumerated(EnumType.STRING)
	private TemaEnum tema_enum;

	@NotBlank
	private String subtema;

	@Enumerated(EnumType.STRING)
	private EscolaridadeEnum escolaridade;

	public Long getIdTema() {
		return idTema;
	}

	public void setIdTema(Long idTema) {
		this.idTema = idTema;
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
