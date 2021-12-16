package com.projetointegrador.model.dtos;

public class UsuarioCredenciaisDTO {

	private String email;
	private String token;
	private String tokenBasic;

	public UsuarioCredenciaisDTO() {
	}

	public UsuarioCredenciaisDTO(String email, String token, String tokenBasic) {
		this.email = email;
		this.token = token;
		this.tokenBasic = tokenBasic;
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