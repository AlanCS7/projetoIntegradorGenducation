package com.projetointegrador.model.dtos;

public class UsuarioCredenciaisDTO {

	private String email;
	private String nomeCompleto;
	private String tipo;
	private String foto;
	private String token;
	private String tokenBasic;

	public UsuarioCredenciaisDTO() {
	}

	public UsuarioCredenciaisDTO(String email, String nomeCompleto, String tipo, String foto, String token,
			String tokenBasic) {
		this.email = email;
		this.nomeCompleto = nomeCompleto;
		this.tipo = tipo;
		this.foto = foto;
		this.token = token;
		this.tokenBasic = tokenBasic;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTokenBasic() {
		return tokenBasic;
	}

	public void setTokenBasic(String tokenBasic) {
		this.tokenBasic = tokenBasic;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

}