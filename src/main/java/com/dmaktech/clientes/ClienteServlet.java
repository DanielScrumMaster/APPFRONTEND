package com.dmaktech.clientes;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/clientes")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
private ClienteService clienteService;
	
	@Override
	public void init() throws ServletException {		
		super.init();		
		clienteService = new ClienteService();		
	}	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		
		String accion = req.getParameter("accion");
				
		if(accion != null)
			handleAction(accion, req);
		
		Optional<String> optCedula = Optional.ofNullable(req.getParameter("cedulaBuscada"));
		
		req.setAttribute("clientes", clienteService.getClientes(optCedula.orElse("")));	
		req.getRequestDispatcher("jsp/clientes.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		doGet(request, response);
		
	}	
	
	private void handleAction(String accion, HttpServletRequest request) {
		switch(accion) {
		case "borrar":
			clienteService.borrarCliente(request.getParameter("cedula"));
			break;
		case "crear":
			Cliente nuevoCliente = new Cliente(
					Long.parseLong(request.getParameter("cedula")),
					request.getParameter("direccion"),
					request.getParameter("email"),
					request.getParameter("telefono"),
					request.getParameter("nombres")
			);			
			clienteService.crearCliente(nuevoCliente);			
			break;		
		}		
	}	

}
