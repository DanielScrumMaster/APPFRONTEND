<%@page import="com.dmaktech.usuarios.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% Usuario usuario = (Usuario) request.getAttribute("usuario"); %>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="../css/usuarios.css">
<title>Usuarios</title>
</head>
<body>
	<%@include file="./menu.jsp"%>
	<p>.</p>
	<div class="container">
		<div class="box1"></div>
		<div class="box2"></div>
		<div class="box3"></div>
		<div class="box4"></div>
		<div class="box5">
			<form action="../UsuarioController" method="post">
				<div class="minigrid">


					<div class="boxa">
						<label class="texto" for="cedula">Cedula</label><br> <input
							class="caja" type="text" name="cedula"><br> <label
							class="texto" for="lname">Nombre Completo</label><br> <input
							class="caja" type="text" name="nombres"><br> <label
							class="texto" for="email">Correo Electronico:</label><br> <input
							class="caja" type="text" name="email"><br>
					</div>
					<div class="boxb">
						<label class="texto" for="Usuario"> Usuario:</label><br> <input
							class="caja" type="text" name="usuario"><br> <label
							class="texto" for="password">Contraseña</label><br> <input
							class="caja" type="password" name="password"><br>
					</div>
					<div class="boxc">
						<input class="boton" type="submit" name="consultar"
							value="Consultar"> <input class="boton" type="submit"
							name="crear" value="Crear">
					</div>
					<div class="boxd">
						<input class="boton" type="submit" value="Actualizar"> <input
							class="boton" type="submit" value="Borrar">
					</div>
				</div>
			</form>
		</div>
		<div class="box6"></div>
		<div class="box7"></div>
		<div class="box8"></div>
		<div class="box9"></div>
	</div>
	<div>
		<% if(usuario != null) { %>
		
		<h2><%= usuario.getNombres() %></h2>
		
		<% } %>
	</div>
</body>
</html>