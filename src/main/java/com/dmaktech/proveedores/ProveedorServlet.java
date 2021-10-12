package com.dmaktech.proveedores;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/proveedores")
public class ProveedorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private ProveedorService proveedorService;
	
	@Override
	public void init() throws ServletException {		
		super.init();		
		proveedorService = new ProveedorService();		
	}	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		
		String accion = req.getParameter("accion");
				
		if(accion != null)
			handleAction(accion, req);
		
		Optional<String> optCedula = Optional.ofNullable(req.getParameter("nitBuscado"));
		
		req.setAttribute("proveedores", proveedorService.getProveedores(optCedula.orElse("")));	
		req.getRequestDispatcher("jsp/proveedores.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		doGet(request, response);
		
	}	
	
	private void handleAction(String accion, HttpServletRequest request) {
		switch(accion) {
		case "borrar":
			proveedorService.borrarProveedor(request.getParameter("nit"));
			break;
		case "crear":
			Proveedor nuevoProveedor = new Proveedor(
					Long.parseLong(request.getParameter("nit")),
					request.getParameter("ciudad"),
					request.getParameter("direccion"),
					request.getParameter("nombre"),
					request.getParameter("telefono")					
			);			
			proveedorService.crearProveedor(nuevoProveedor);			
			break;		
		case "actualizar":
			Proveedor proveedorActualizado = new Proveedor(
					Long.parseLong(request.getParameter("nit")),
					request.getParameter("ciudad"),
					request.getParameter("direccion"),
					request.getParameter("nombre"),
					request.getParameter("telefono")
			);			
			proveedorService.actualizarProveedor(proveedorActualizado);			
			break;	
		}		
	}
	
}
