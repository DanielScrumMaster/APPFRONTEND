package com.dmaktech.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String defaultAdmin = "admininicial";
	private final static String defaultPassword = "admin123456"; 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		RequestDispatcher dispatcher = req.getRequestDispatcher("html/login.html");
		dispatcher.forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
				
		if(usuario.equals(defaultAdmin) && password.equals(defaultPassword)) {
			//request.login(usuario, password);
			//HttpSession session =  request.getSession();
			//session.setMaxInactiveInterval(1000);			
			RequestDispatcher dispatcher = request.getRequestDispatcher("html/usuarios.html");
			dispatcher.forward(request, response);			
		} else {
			out.write("usuario o contraseña errados, intente de nuevo");
			doGet(request, response);
		}
	}
}
