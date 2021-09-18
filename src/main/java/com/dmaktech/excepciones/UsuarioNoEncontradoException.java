package com.dmaktech.excepciones;

public class UsuarioNoEncontradoException extends Exception{

	private long cedula;
	
	public UsuarioNoEncontradoException(long cedula) {
		this.cedula = cedula;
	}
	
	public long getCedula() {
		return cedula;
	}	
}
