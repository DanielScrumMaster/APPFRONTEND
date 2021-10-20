package com.dmaktech.ventas;

import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class VentaService {
	private URL url;
	private final String baseURL;
	private ObjectMapper mapper;
		
	public VentaService()  {		
		baseURL = "http://localhost:5000/ventas/";
		mapper = new ObjectMapper();
	}

	public Venta getVenta(String codigo) {
		
		try {			
			url = new URL(baseURL + codigo);			
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
						
			if(connection.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND)
				return null;
					
			Venta venta = mapper.readValue(connection.getInputStream(), Venta.class);			
						
			connection.disconnect();			
			return venta;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}	
	
	public boolean crearVenta(Venta nuevaVenta) {
		
		try {			
			url = new URL(baseURL);
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();			
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setDoOutput(true);
			
			String jsonVenta = mapper.writeValueAsString(nuevaVenta);			
			connection.getOutputStream().write(jsonVenta.getBytes(StandardCharsets.UTF_8));	
			
			if(connection.getResponseCode() == HttpURLConnection.HTTP_CREATED)
				return true;
			
			connection.disconnect();		
			
		} catch (Exception e) {			
			e.printStackTrace();
		}		
		return false;
	}
	
	public boolean actualizarVenta(Venta venta) {
		
		try {			
			url = new URL(baseURL + venta.getId());
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();			
			connection.setRequestMethod("PUT");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setDoOutput(true);
			
			String jsonVenta = mapper.writeValueAsString(venta);			
			connection.getOutputStream().write(jsonVenta.getBytes(StandardCharsets.UTF_8));	
			
			if(connection.getResponseCode() == HttpURLConnection.HTTP_CREATED)
				return true;
			
			connection.disconnect();		
			
		} catch (Exception e) {			
			e.printStackTrace();
		}		
		return false;
	}
	
	public List<Venta> getVentas(String filtroCodigo) {
		
		try {			
			url = new URL(baseURL + "?filtroCodigo=" + filtroCodigo);
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();			
			connection.setRequestMethod("GET");			
			
			List<Venta> ventas = mapper.readValue(connection.getInputStream(), new TypeReference<List<Venta>>() {});
			connection.disconnect();
			return ventas;			
			
		} catch (Exception e) {			
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
	
	public boolean borrarVenta(String codigo) {
		try {
			url = new URL(baseURL + codigo);
			
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
