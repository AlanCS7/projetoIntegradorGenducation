package com.projetointegrador.model.dtos;

public class UsuarioCredenciaisDTO {

	private String idUsuario;
	private String email;
	private String token;
	private String tokenBasic;

	public UsuarioCredenciaisDTO() {
	}

	public UsuarioCredenciaisDTO(String idUsuario, String email, String token, String tokenBasic) {
		this.idUsuario = idUsuario;
		this.email = email;
		this.token = token;
		this.tokenBasic = tokenBasic;
	}
	
	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
}