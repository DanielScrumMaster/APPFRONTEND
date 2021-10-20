package com.dmaktech.productos;

import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

import com.dmaktech.proveedores.Proveedor;
import com.dmaktech.proveedores.ProveedorService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductoService {
	private URL url;
	private final String baseURL;
	private ObjectMapper mapper;
	private final ProveedorService proveedorService;
		
	public ProductoService()  {		
		baseURL = "http://localhost:5000/productos/";
		mapper = new ObjectMapper();
		proveedorService = new ProveedorService();
	}

	public Producto getProducto(String codigo) {
		List<Proveedor> proveedores = proveedorService.getProveedores("");
		
		try {			
			url = new URL(baseURL + codigo);			
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
						
			if(connection.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND)
				return null;
					
			Producto producto = mapper.readValue(connection.getInputStream(), Producto.class);			
			
			producto.setProveedor(
					proveedores.stream()
					.filter(p -> p.getNit() == producto.getNitProveedor())
					.findFirst()
					.get());
			
			connection.disconnect();			
			return producto;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}	
	
	public boolean crearProducto(Producto nuevoProducto) {
		
		try {			
			url = new URL(baseURL);
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();			
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setDoOutput(true);
			
			String jsonProducto = mapper.writeValueAsString(nuevoProducto);			
			connection.getOutputStream().write(jsonProducto.getBytes(StandardCharsets.UTF_8));	
			
			if(connection.getResponseCode() == HttpURLConnection.HTTP_CREATED)
				return true;
			
			connection.disconnect();		
			
		} catch (Exception e) {			
			e.printStackTrace();
		}		
		return false;
	}
	
	public boolean actualizarProducto(Producto producto) {
		
		try {			
			url = new URL(baseURL + producto.getCodigo());
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();			
			connection.setRequestMethod("PUT");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setDoOutput(true);
			
			String jsonProducto = mapper.writeValueAsString(producto);			
			connection.getOutputStream().write(jsonProducto.getBytes(StandardCharsets.UTF_8));	
			
			if(connection.getResponseCode() == HttpURLConnection.HTTP_CREATED)
				return true;
			
			connection.disconnect();		
			
		} catch (Exception e) {			
			e.printStackTrace();
		}		
		return false;
	}
	
	public List<Producto> getProductos(String filtroCodigo) {
		List<Proveedor> proveedores = proveedorService.getProveedores("");
		try {			
			url = new URL(baseURL + "?filtroCodigo=" + filtroCodigo);
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();			
			connection.setRequestMethod("GET");			
			
			List<Producto> productos = mapper.readValue(connection.getInputStream(), new TypeReference<List<Producto>>() {});
			
			for(Producto producto: productos) {
				producto.setProveedor(
						proveedores.stream()
						.filter(p -> p.getNit() == producto.getNitProveedor())
						.findFirst()
						.get());
			}
			
			connection.disconnect();
			return productos;			
			
		} catch (Exception e) {			
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
	
	public boolean borrarProducto(String codigo) {
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
