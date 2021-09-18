package com.dmaktech.servicios;

import com.dmaktech.dao.UsuarioDAO;
import com.dmaktech.entidades.Usuario;
import com.dmaktech.excepciones.UsuarioNoEncontradoException;

public final class UsuarioServices {

	private final UsuarioDAO usuarioDao;

	public UsuarioServices(UsuarioDAO usuarioDao) {		
		this.usuarioDao = usuarioDao;
	}
	
	public Usuario obtenerUsuario(long cedula) throws UsuarioNoEncontradoException {
		
		return usuarioDao.obtenerUsuario(cedula);		
	}	
	
	public boolean actualizarUsuario() {
		return false;
	}
	
	public boolean crearUsuario() {
		
		return false;
	}
	
	public void borrarUsuario(long cedula) {
		
	}
}
