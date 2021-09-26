package com.dmaktech.usuarios;

public class Usuario {

	private long cedula;	
	private String email;
	private String nombres;
	private String password;
	private String usuario;
		
	public Usuario() { }

	public Usuario(long cedula, String email, String nombres, String password, String usuario) {		
		this.cedula = cedula;
		this.email = email;
		this.nombres = nombres;
		this.password = password;
		this.usuario = usuario;
	}

	public long getCedula() {
		return cedula;
	}

	public String getEmail() {
		return email;
	}

	public String getNombres() {
		return nombres;
	}

	public String getPassword() {
		return password;
	}

	public String getUsuario() {
		return usuario;
	}	
}
