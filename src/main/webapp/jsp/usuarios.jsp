<%@page import="java.util.List"%>
<%@page import="com.dmaktech.usuarios.Usuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, user-scalable=0,initial-scale=1.0, maximum-scale=1.0,minimun-scale=1.0">
	<link rel="stylesheet" href="./css/usuarios.css">
<title>Usuarios</title>
</head>
<body>
	<header class="lista">
		<%@include file="./menu.jsp"%>
	</header>
	<div class="contenedor">
		<section class="top">
			<div>
				<input class="botonNuevoUsuario" type="submit" name="crear"
					value="Usuarios">
			</div>
			<div>
				<div class="barra">
					<form action="./usuarios" method="GET">
						<label for="cedula">Buscar:</label>
						<input class="cajaBuscar" type="text" placeholder="Ingrese numero de cedula" name="cedulaBuscada">
						<button class="botonBuscar" name="accion" value="buscar">&#128270;</button>		
					</form>					
				</div>
			</div>
		</section>

		<section class="mid">
			<table>
				<thead>
					<tr>
						<th>Cedula</th>
						<th>Nombre Completo</th>
						<th>Correo Electronico</th>
						<th>Usuario</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<% List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios"); %>
					<c:forEach items="${usuarios}" var="usuario">
						<tr>
							<td>${usuario.getCedula()}</td>
							<td>${usuario.getNombres()}</td>
							<td>${usuario.getEmail()}</td>
							<td>${usuario.getUsuario()}</td>
							<td><input class="boton" type="submit" value="Editar"></td>
							<td><a href="usuarios?accion=borrar&cedula=${usuario.getCedula()}">X</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</section>

		<section class="bot">
			<div>
				<section class="bott">
					<div class="titulo">
						<h2>Agregar nuevo usuario</h2>
					</div>
		
					<form action="./usuarios" method="post">
		
						<div class="agregar">
							<div class="caja">
								<label class="texto" for="cedula">Cedula</label><br> 
								<input class="cajaTexto" type="text" name="cedula" required><br><br>
		
								<label class="texto" for="nombres">NombreCompleto</label><br>
								<input class="cajaTexto" type="text" name="nombres" required><br><br>
		
								<label class="texto" for="email">Correo Electronico</label><br>
								<input class="cajaTexto" type="text" name="email" required>
							</div>
		
							<div class="caja">
								<label class="texto" for="usuario"> Usuario</label><br>
								<input class="cajaTexto" type="text" name="usuario" required><br><br>
		
								<label class="texto" for="password">Contraseña</label><br> 
								<input class="cajaTexto" type="password" name="password" required>
								
								<br><br><br> <input class="boton1" type="submit" name="accion" value="crear">
							</div>
						</div>
					</form>
				</section>
			</div>
			<div>
				<section class="bott">
					<div class="titulo">
						<h2>Actualizar Registro</h2>
					</div>
		
					<form action="./usuarios" method="post">
		
						<div class="agregar">
							<div class="caja">
								<label class="texto" for="cedula">Cedula</label><br> 
								<input class="cajaTexto" type="text" name="cedula" required><br><br>
		
								<label class="texto" for="nombres">NombreCompleto</label><br>
								<input class="cajaTexto" type="text" name="nombres" required><br><br>
		
								<label class="texto" for="email">Correo Electronico:</label><br>
								<input class="cajaTexto" type="text" name="email" required>
							</div>
		
							<div class="caja">
								<label class="texto" for="usuario"> Usuario:</label><br>
								<input class="cajaTexto" type="text" name="usuario" required><br><br>
		
								<label class="texto" for="password">Contraseña</label><br> 
								<input class="cajaTexto" type="password" name="password" required>
								
								<br><br><br> <input class="boton1" type="submit" name="accion" value="actualizar">
							</div>
						</div>
					</form>
				</section>
			</div>
		</section>
		
	</div>
</body>
</html>