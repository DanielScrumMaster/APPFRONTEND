package com.dmaktech.clientes;

import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ClienteService {

	private URL url;
	private final String baseURL;
	private ObjectMapper mapper;
		
	public ClienteService()  {		
		baseURL = "http://localhost:5000/clientes/";
		mapper = new ObjectMapper();
	}

	public Cliente getCliente(String cedula) {
		
		try {			
			url = new URL(baseURL + cedula);			
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
						
			if(connection.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND)
				return null;
					
			Cliente cliente = mapper.readValue(connection.getInputStream(), Cliente.class);			
						
			connection.disconnect();			
			return cliente;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}	
	
	public boolean crearCliente(Cliente nuevoCliente) {
		
		try {			
			url = new URL(baseURL);
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();			
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setDoOutput(true);
			
			String jsonCliente = mapper.writeValueAsString(nuevoCliente);			
			connection.getOutputStream().write(jsonCliente.getBytes(StandardCharsets.UTF_8));	
			
			if(connection.getResponseCode() == HttpURLConnection.HTTP_CREATED)
				return true;
			
			connection.disconnect();		
			
		} catch (Exception e) {			
			e.printStackTrace();
		}		
		return false;
	}
	
	public List<Cliente> getClientes(String filtroCedulas) {
		
		try {			
			url = new URL(baseURL + "?filtroCedulas=" + filtroCedulas);
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();			
			connection.setRequestMethod("GET");			
			
			List<Cliente> clientes = mapper.readValue(connection.getInputStream(), new TypeReference<List<Cliente>>() {});
			connection.disconnect();
			return clientes;			
			
		} catch (Exception e) {			
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
	
	public boolean borrarCliente(String cedula) {
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
