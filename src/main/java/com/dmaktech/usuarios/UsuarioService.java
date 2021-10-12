package com.dmaktech.usuarios;

import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UsuarioService {

	private URL url;
	private final String baseURL;
	private ObjectMapper mapper;
		
	public UsuarioService()  {		
		baseURL = "http://localhost:5000/usuarios/";
		mapper = new ObjectMapper();
	}

	public Usuario getUsuario(String cedula) {
		
		try {			
			url = new URL(baseURL + cedula);			
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
						
			if(connection.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND)
				return null;
					
			Usuario usuario = mapper.readValue(connection.getInputStream(), Usuario.class);			
						
			connection.disconnect();			
			return usuario;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}	
	
	public boolean crearUsuario(Usuario nuevoUsuario) {
		
		try {			
			url = new URL(baseURL);
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();			
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setDoOutput(true);
			
			String jsonUsuario = mapper.writeValueAsString(nuevoUsuario);			
			connection.getOutputStream().write(jsonUsuario.getBytes(StandardCharsets.UTF_8));	
			
			if(connection.getResponseCode() == HttpURLConnection.HTTP_CREATED)
				return true;
			
			connection.disconnect();		
			
		} catch (Exception e) {			
			e.printStackTrace();
		}		
		return false;
	}
	
	public boolean actualizarUsuario(Usuario usuario) {
		
		try {			
			url = new URL(baseURL + usuario.getCedula());
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();			
			connection.setRequestMethod("PUT");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setDoOutput(true);
			
			String jsonUsuario = mapper.writeValueAsString(usuario);			
			connection.getOutputStream().write(jsonUsuario.getBytes(StandardCharsets.UTF_8));	
			
			if(connection.getResponseCode() == HttpURLConnection.HTTP_CREATED)
				return true;
			
			connection.disconnect();		
			
		} catch (Exception e) {			
			e.printStackTrace();
		}		
		return false;
	}
	
	public List<Usuario> getUsuarios(String filtroCedulas) {
		
		try {			
			url = new URL(baseURL + "?filtroCedulas=" + filtroCedulas);
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();			
			connection.setRequestMethod("GET");			
			
			List<Usuario> usuarios = mapper.readValue(connection.getInputStream(), new TypeReference<List<Usuario>>() {});
			connection.disconnect();
			return usuarios;			
			
		} catch (Exception e) {			
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
	
	public boolean borrarUsuario(String cedula) {
		try {
			url = new URL(baseURL + cedula);
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("DELETE");	
			
			if(connection.getResponseCode() == HttpURLConnection.HTTP_OK)
				return true;
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		return false;
	}
}
