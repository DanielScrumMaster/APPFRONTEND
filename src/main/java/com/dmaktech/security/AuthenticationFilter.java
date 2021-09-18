package com.dmaktech.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {

   	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

   		HttpServletRequest httpRequest = (HttpServletRequest) request;	
   		response.setContentType("text/html/");
   		
   		if(httpRequest.authenticate((HttpServletResponse) response)) {
   			chain.doFilter(request, response);
   		}else {
   			RequestDispatcher dispatcher = httpRequest.getRequestDispatcher("html/login.html");
   			dispatcher.forward(httpRequest, response);
   		}	
	}
}
