package com.dmaktech.clientes;

public class Cliente {

	private Long cedula;
	private String direccion;
	private String email;
	private String telefono;
	private String nombres;
	
	public Cliente() {}

	public Cliente(Long cedula, String direccion, String email, String telefono, String nombres) {
		super();
		this.cedula = cedula;
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
		this.nombres = nombres;
	}

	public Long getCedula() {
		return cedula;
	}

	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}	
}
