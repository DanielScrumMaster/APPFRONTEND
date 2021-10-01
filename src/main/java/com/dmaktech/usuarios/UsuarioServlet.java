package com.dmaktech.usuarios;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/usuarios")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UsuarioService usuarioService;
	
	@Override
	public void init() throws ServletException {		
		super.init();		
		usuarioService = new UsuarioService();		
	}	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Usuario> usuarios = usuarioService.getUsuarios();
		req.setAttribute("usuarios", usuarios);
		req.getRequestDispatcher("jsp/usuarios.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("consultar") != null) {
			
			Usuario usuario = usuarioService.getUsuario(request.getParameter("cedula"));
			request.setAttribute("usuario", usuario);
			
		} else if(request.getParameter("borrar") != null) {
			
			usuarioService.borrarUsuario(request.getParameter("cedula"));
			
		} else if(request.getParameter("crear") != null) {
			
			Usuario nuevoUsuario = new Usuario(
					Long.parseLong(request.getParameter("cedula")),
					request.getParameter("email"),
					request.getParameter("nombres"),
					request.getParameter("password"),
					request.getParameter("usuario")
			);
			
			usuarioService.crearUsuario(nuevoUsuario);
		} else if(request.getParameter("actualizar") != null) {
			
			
			
		}
		
		doGet(request, response);
		
	}	
}
