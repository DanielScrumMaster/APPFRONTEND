package com.dmaktech.ventas;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ventas")
public class VentaServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	private VentaService ventaService;
	
	@Override
	public void init() throws ServletException {		
		super.init();		
		ventaService = new VentaService();		
	}	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		
		String accion = req.getParameter("accion");
				
		if(accion != null)
			handleAction(accion, req);
		
		Optional<String> optCodigo = Optional.ofNullable(req.getParameter("codigoBuscado"));
		
		req.setAttribute("ventas", ventaService.getVentas(optCodigo.orElse("")));	
		req.getRequestDispatcher("jsp/ventas.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);		
	}	
	
	private void handleAction(String accion, HttpServletRequest request) {
		switch(accion) {
		case "borrar":
			request.setAttribute("mensajeAlerta", "Venta borrada exitosamente");
			ventaService.borrarVenta(request.getParameter("codigo"));
			request.setAttribute("iconoAlerta", "success");
			break;
		case "crear":
			Venta nuevaVenta = new Venta(
					Long.parseLong(request.getParameter("codigo")),
					Long.parseLong(request.getParameter("cedulaCliente")),
					Long.parseLong(request.getParameter("cedulaUsuario")),					
					Double.parseDouble(request.getParameter("valorInicial")),
					Double.parseDouble(request.getParameter("iva")),
					Double.parseDouble(request.getParameter("valorTotal")),
					null					
			);			
			ventaService.crearVenta(nuevaVenta);
			request.setAttribute("mensajeAlerta", "Venta creada exitosamente");
			request.setAttribute("iconoAlerta", "success");
			break;		
		case "actualizar":
			Venta venta = new Venta(
					Long.parseLong(request.getParameter("codigo")),
					Long.parseLong(request.getParameter("cedulaCliente")),
					Long.parseLong(request.getParameter("cedulaUsuario")),					
					Double.parseDouble(request.getParameter("valorInicial")),
					Double.parseDouble(request.getParameter("iva")),
					Double.parseDouble(request.getParameter("valorTotal")),
					null					
			);						
			ventaService.actualizarVenta(venta);
			request.setAttribute("mensajeAlerta", "Venta editada exitosamente");
			request.setAttribute("iconoAlerta", "success");
			break;	
		}		
	}
}
