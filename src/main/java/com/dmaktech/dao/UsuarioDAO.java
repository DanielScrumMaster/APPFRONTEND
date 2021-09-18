package com.dmaktech.dao;

import com.dmaktech.entidades.Usuario;
import com.dmaktech.excepciones.UsuarioNoEncontradoException;

public interface UsuarioDAO {

	/**
	 * Obtiene los datos de un usuario del repositorio
	 * @param cedula del usuario consultado
	 * @return 
	 * @throws UsuarioNoEncontradoException Arroja una excepcion si el usuario no existe en el repositorio
	 */
	public Usuario obtenerUsuario(long cedula) throws UsuarioNoEncontradoException;
	
	/**
	 * Actualiza los datos de un usuario del repositorio.
	 * @param nuevosDatos Datos que se actualizarán en el repositorio
	 * @return Verdadero si se actualizan los datos de usuario.
	 */
	public boolean actualizarDatosUsuario(Usuario nuevosDatos);
	
	/**
	 * Crea un nuevo usuario en el repositorio
	 * @param nuevoUsuario Datos del nuevo usuario que será agregado.	
	 * @return Verdadero si el usuario se creó correctamente.
	 */
	public boolean crearUsuario(Usuario nuevoUsuario);
	
	/**
	 * Elimina un usuario del repositorio, dependiendo de la cedula ingresada
	 * @param cedula del usuario a eliminar
	 * @return verdadero si el usuario se eliminó correctamente
	 */
	public boolean borrarUsuario(long cedula);	
	
}
