package com.dmaktech.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dmaktech.entidades.Usuario;
import com.dmaktech.excepciones.UsuarioNoEncontradoException;

/**
 * Implementación de la interfaz UsuarioDAO, haciendo uso de MySQL
 */
public class UsuarioDAOMySQL implements UsuarioDAO {

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda", "mintic", "123");
	}
	
	@Override
	public Usuario obtenerUsuario(long cedula) throws UsuarioNoEncontradoException {
		try(Connection conn = getConnection()){
			String consulta = "Select * from usuarios where ced_usuario = ?";
			
			PreparedStatement statement = conn.prepareStatement(consulta);
			statement.setLong(1, cedula);
			
			ResultSet resultadoConsulta = statement.executeQuery();			
			resultadoConsulta.last();
			
			if(resultadoConsulta.getRow() == 0)
				throw new UsuarioNoEncontradoException(cedula);
			
			return mapUsuario(resultadoConsulta);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
	}

	@Override
	public boolean actualizarDatosUsuario(Usuario nuevosDatos) {
		try(Connection conn = getConnection()){
			
			String consulta = "UPDATE usuarios SET email_usuario = ?, nom_usuario = ?, password_usuario = ?, usuario = ? where ced_usuario = ?";
			
			PreparedStatement statement = conn.prepareStatement(consulta);
			statement.setString(1, nuevosDatos.getEmail());
			statement.setString(2, nuevosDatos.getNombreUsuario());
			statement.setString(3, nuevosDatos.getPassword());
			statement.setLong(4, nuevosDatos.getCedula());
			statement.setString(3, nuevosDatos.getUsuario());
			
			return statement.executeUpdate() > 0;			
			
		} catch (SQLException e) {			
			e.printStackTrace();
			return false;
		}		
	}

	@Override
	public boolean crearUsuario(Usuario nuevoUsuario) {
		try(Connection conn = getConnection()) {
			
			String query = "INSERT INTO usuarios (ced_usuario, email_usuario, nom_usuario, password_usuario, usuario) VALUES (?,?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setLong(1, nuevoUsuario.getCedula());
			statement.setString(2, nuevoUsuario.getEmail());
			statement.setString(3, nuevoUsuario.getNombreUsuario());
			statement.setString(4, nuevoUsuario.getPassword());
			statement.setString(5, nuevoUsuario.getUsuario());
			
			return statement.executeUpdate() > 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}			
	}

	@Override
	public boolean borrarUsuario(long cedula) {
		try(Connection conn = getConnection()){
			
			String consulta = "DELETE FROM usuarios where cedula = ?";
			PreparedStatement statement = conn.prepareStatement(consulta);
			statement.setLong(1, cedula);
			
			return statement.executeUpdate() > 0;	
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}		
	}	
	
	/**
	 * Mapea los resultados de una consulta a un objeto de tipo Usuario
	 * @param resultadosConsulta ResultSet que contiene los datos de la ejecución SQL
	 * @return Usuario con los datos de este registro
	 */
	private Usuario mapUsuario(ResultSet resultadosConsulta) {
		try {
			
			long cedula = resultadosConsulta.getLong("ced_usuario");
			String nombres = resultadosConsulta.getString("nom_usuario");
			String email = resultadosConsulta.getString("email_usuario");
			String password = resultadosConsulta.getString("password_usuario");
			String usuario = resultadosConsulta.getString("usuario");
			
			return new Usuario(cedula,email, nombres, password, usuario);					
					
		} catch (SQLException e) {			
			e.printStackTrace();
			return null;
		}		
	}
}
