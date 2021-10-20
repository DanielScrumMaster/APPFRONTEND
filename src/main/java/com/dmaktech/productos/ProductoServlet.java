package com.dmaktech.productos;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/productos")
public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProductoService productoService;
	
	@Override
	public void init() throws ServletException {		
		super.init();		
		productoService = new ProductoService();		
	}	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		
		String accion = req.getParameter("accion");
				
		if(accion != null)
			handleAction(accion, req);
		
		Optional<String> optCodigo = Optional.ofNullable(req.getParameter("codigoBuscado"));
		
		req.setAttribute("productos", productoService.getProductos(optCodigo.orElse("")));	
		req.getRequestDispatcher("jsp/productos.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);		
	}	
	
	private void handleAction(String accion, HttpServletRequest request) {
		switch(accion) {
		case "borrar":
			productoService.borrarProducto(request.getParameter("codigo"));
			request.setAttribute("mensajeAlerta", "Producto borrado exitosamente");
			request.setAttribute("iconoAlerta", "success");
			break;
		case "crear":
			Producto nuevoProducto = new Producto(
					Long.parseLong(request.getParameter("codigo")),
					request.getParameter("nombre"),
					Double.parseDouble(request.getParameter("iva")),
					Long.parseLong(request.getParameter("nitProveedor")),
					Double.parseDouble(request.getParameter("precioCompra")),
					Double.parseDouble(request.getParameter("precioVenta"))					
			);			
			productoService.crearProducto(nuevoProducto);
			request.setAttribute("mensajeAlerta", "Producto creado exitosamente");
			request.setAttribute("iconoAlerta", "success");
			break;		
		case "actualizar":
			Producto productoActualizado = new Producto(
					Long.parseLong(request.getParameter("codigo")),
					request.getParameter("nombre"),
					Double.parseDouble(request.getParameter("iva")),
					Long.parseLong(request.getParameter("nitProveedor")),
					Double.parseDouble(request.getParameter("precioCompra")),
					Double.parseDouble(request.getParameter("precioVenta"))					
			);				
			productoService.actualizarProducto(productoActualizado);
			request.setAttribute("mensajeAlerta", "Producto editado exitosamente");
			request.setAttribute("iconoAlerta", "success");
			break;	
		}		
	}
}
