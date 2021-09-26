package com.dmaktech.usuarios;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UsuarioController")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UsuarioService usuarioService;
	
	@Override
	public void init() throws ServletException {		
		super.init();		
		usuarioService = new UsuarioService();		
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("consultar") != null) {
			Usuario usuario = usuarioService.getUsuario(request.getParameter("cedula"));
			request.setAttribute("usuario", usuario);
			
			request.getRequestDispatcher("jsp/usuarios.jsp").forward(request, response);
			
		} else if(request.getParameter("borrar") != null) {
			usuarioService.borrarUsuario(request.getParameter("cedula"));			
		} 		
	}	
}
