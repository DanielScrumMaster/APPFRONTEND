package com.dmaktech.proveedores;

import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProveedorService {

	private URL url;
	private final String baseURL;
	private ObjectMapper mapper;
		
	public ProveedorService()  {		
		baseURL = "http://localhost:5000/proveedores/";
		mapper = new ObjectMapper();
	}

	public Proveedor getCliente(String nit) {
		
		try {			
			url = new URL(baseURL + nit);			
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
						
			if(connection.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND)
				return null;
					
			Proveedor proveedor = mapper.readValue(connection.getInputStream(), Proveedor.class);			
						
			connection.disconnect();			
			return proveedor;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}	
	
	public boolean crearProveedor(Proveedor nuevoProveedor) {
		
		try {			
			url = new URL(baseURL);
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();			
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setDoOutput(true);
			
			String jsonProveedor = mapper.writeValueAsString(nuevoProveedor);			
			connection.getOutputStream().write(jsonProveedor.getBytes(StandardCharsets.UTF_8));	
			
			if(connection.getResponseCode() == HttpURLConnection.HTTP_CREATED)
				return true;
			
			connection.disconnect();		
			
		} catch (Exception e) {			
			e.printStackTrace();
		}		
		return false;
	}
	
	public boolean actualizarProveedor(Proveedor proveedor) {
		
		try {			
			url = new URL(baseURL + proveedor.getNit());
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();			
			connection.setRequestMethod("PUT");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setDoOutput(true);
			
			String jsonProveedor = mapper.writeValueAsString(proveedor);			
			connection.getOutputStream().write(jsonProveedor.getBytes(StandardCharsets.UTF_8));	
			
			if(connection.getResponseCode() == HttpURLConnection.HTTP_CREATED)
				return true;
			
			connection.disconnect();		
			
		} catch (Exception e) {			
			e.printStackTrace();
		}		
		return false;
	}
	
	public List<Proveedor> getProveedores(String filtroNit) {
		
		try {			
			url = new URL(baseURL + "?filtroNit=" + filtroNit);
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();			
			connection.setRequestMethod("GET");			
			
			List<Proveedor> proveedores = mapper.readValue(connection.getInputStream(), new TypeReference<List<Proveedor>>() {});
			connection.disconnect();
			return proveedores;			
			
		} catch (Exception e) {			
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
	
	public boolean borrarProveedor(String nit) {
		try {
			url = new URL(baseURL + nit);
			
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
