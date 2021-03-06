package com.projetointegrador.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.projetointegrador.model.enums.EscolaridadeEnum;
import com.projetointegrador.model.enums.TemaEnum;

@Entity
@Table(name = "tb_tema")
public class TemaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTema;

	@Column(columnDefinition = "ENUM('EXATAS', 'HUMANAS', 'BIOLOGICAS', 'TECNOLOGIA', 'LIVRE')")
	@Enumerated(EnumType.STRING)
	private TemaEnum temaEnum;

	@NotBlank
	private String subtema;

	@Column(columnDefinition = "ENUM('ALFABETIZACAO', 'ENSINO_FUNDAMENTAL', 'ENSINO_MEDIO', 'ENSINO_SUPERIOR', 'LIVRE')")
	@Enumerated(EnumType.STRING)
	private EscolaridadeEnum escolaridade;

	@OneToMany(mappedBy = "tema", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("tema")
	private List<PostagemModel> postagens;

	public Long getIdTema() {
		return idTema;
	}

	public void setIdTema(Long idTema) {
		this.idTema = idTema;
	}

	public TemaEnum getTemaEnum() {
		return temaEnum;
	}

	public void setTemaEnum(TemaEnum temaEnum) {
		this.temaEnum = temaEnum;
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

	public List<PostagemModel> getPostagens() {
		return postagens;
	}

	public void setPostagens(List<PostagemModel> postagens) {
		this.postagens = postagens;
	}

}
