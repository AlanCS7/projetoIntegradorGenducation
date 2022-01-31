package com.projetointegrador.model.dtos;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

public class UsuarioRegistroDTO {
	
	private @Id @Email(message = "O atributo Usuário deve ser um email válido!") @Schema(example = "email@email.com.br") String email;

	private @NotBlank @Size(min = 8, max = 100) String nomeCompleto;

	private @NotBlank @Size(min = 5, max = 30) String senha;

	public UsuarioRegistroDTO() {
	}
		
	public UsuarioRegistroDTO(String email, String nomeCompleto, String senha) {
		this.email = email;
		this.nomeCompleto = nomeCompleto;
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}