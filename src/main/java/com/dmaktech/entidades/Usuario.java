package com.dmaktech.entidades;

public class Usuario {

	private long cedula;	
	private String email;
	private String nombreUsuario;
	private String password;
	private String usuario;
	
	public Usuario(long cedula, String email, String nombreUsuario, String password, String usuario) {		
		this.cedula = cedula;
		this.email = email;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.usuario = usuario;
	}

	public long getCedula() {
		return cedula;
	}

	public String getEmail() {
		return email;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public String getUsuario() {
		return usuario;
	}	
}
