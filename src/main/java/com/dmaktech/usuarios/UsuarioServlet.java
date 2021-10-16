package com.dmaktech.usuarios;

import java.io.IOException;
import java.util.Optional;

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
		
		String accion = req.getParameter("accion");
				
		if(accion != null)
			handleAction(accion, req);
		
		Optional<String> optCedula = Optional.ofNullable(req.getParameter("cedulaBuscada"));
		
		req.setAttribute("usuarios", usuarioService.getUsuarios(optCedula.orElse("")));	
		
		req.getRequestDispatcher("jsp/usuarios.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		doGet(request, response);
		
	}	
	
	private void handleAction(String accion, HttpServletRequest request) {
		switch(accion) {
		case "borrar":
			usuarioService.borrarUsuario(request.getParameter("cedula"));
			request.setAttribute("mensajeAlerta", "Usuario borrado exitosamente");
			request.setAttribute("iconoAlerta", "success");
			break;
		case "crear":
			Usuario nuevoUsuario = new Usuario(
					Long.parseLong(request.getParameter("cedula")),
					request.getParameter("email"),
					request.getParameter("nombres"),
					request.getParameter("password"),
					request.getParameter("usuario")
			);			
			usuarioService.crearUsuario(nuevoUsuario);			
			request.setAttribute("mensajeAlerta", "Usuario creado exitosamente");
			request.setAttribute("iconoAlerta", "success");
			break;		
		case "actualizar":
			Usuario usuarioActualizado = new Usuario(
					Long.parseLong(request.getParameter("cedula")),
					request.getParameter("email"),
					request.getParameter("nombres"),
					request.getParameter("password"),
					request.getParameter("usuario")
			);			
			usuarioService.actualizarUsuario(usuarioActualizado);
			request.setAttribute("mensajeAlerta", "Usuario editado exitosamente");
			request.setAttribute("iconoAlerta", "success");
			break;
		}		
	}	
}
