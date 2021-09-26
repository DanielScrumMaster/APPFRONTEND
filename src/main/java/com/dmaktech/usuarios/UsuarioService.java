package com.dmaktech.usuarios;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
	
	public List<Usuario> getUsuarios() {
		
		try {			
			url = new URL(baseURL);
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();			
			connection.setRequestMethod("GET");
			
			return mapper.readValue(connection.getInputStream(), new TypeReference<List<Usuario>>() {});			
			
		} catch (Exception e) {
			// 
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void borrarUsuario(String cedula) {
		try {
			url = new URL(baseURL + cedula);
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("DELETE");			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
