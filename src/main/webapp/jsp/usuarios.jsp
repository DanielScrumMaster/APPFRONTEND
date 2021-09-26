<%@page import="java.util.List"%>
<%@page import="com.dmaktech.usuarios.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="../css/usuarios.css">
<link rel="stylesheet" type="text/css" href="../css/menu.css">
<title>Usuarios | Tienda</title>
</head>
<body>
	<header>
		<div class="grid">
			<div class="logo">
				<img src="../imagenes/logo.png" alt="Logo de la tienda">
			</div>
			<div class="lista">
				<%@include file="./menu.jsp"%>
			</div>
		</div>
		<p>.</p>
	</header>

	<section class="formulario">
		<div class="container">
			<div class="box1"></div>
			<div class="box2"></div>
			<div class="box3"></div>
			<div class="box4"></div>
			<div class="box5">
				<form action="../usuarios" method="post">

					<div class="minigrid">
						<div class="boxa">
							<br> <label class="texto" for="cedula">Cedula</label><br>
							<br> <br> <br> <label class="texto" for="nombres">Nombre
								Completo</label><br> <br> <br> <br> <label
								class="texto" for="email">Correo Electronico:</label><br>
						</div>
						<div class="boxa">
							<input class="caja" type="text" name="cedula"><br> <br>
							<br> <input class="caja" type="text" name="nombres"><br>
							<br> <br> <input class="caja" type="text" name="email"><br>
						</div>

						<div class="boxb">
							<br> <label class="texto" for="usuario"> Usuario:</label><br>
							<br> <br> <br> <label class="texto" for="password">Contraseña</label><br>

						</div>
						<div class="boxb">
							<input class="caja" type="text" name="usuario"><br>
							<br> <br> <input class="caja" type="password"
								name="password"><br>
						</div>

						<div class="boxc">
							<input class="boton" type="submit" name="consultar"
								value="Consultar">
						</div>
						<div class="boxc">
							<input class="boton" type="submit" name="crear" value="Crear">
						</div>
						<div class="boxd">
							<input class="boton" type="submit" value="Actualizar">
						</div>
						<div class="boxc">
							<input class="boton" type="submit" name="borrar" value="Borrar">
						</div>
					</div>
				</form>
			</div>
			<div class="box6"></div>
			<div class="box7"></div>
			<div class="box8"></div>
			<div class="box9"></div>
		</div>
	</section>
	<p>.</p>
	<section class="tabla">
		<div class="contenedor">
			<div class="box1"></div>
			<div class="box2"></div>
			<div class="box3"></div>
			<div class="box4"></div>
			<div class="box5">
				<table>
					<tr>
						<th>Nombres</th>
						<th>Cedula</th>
						<th>Email</th>
						<th>Usuario</th>
					</tr>
					<%
					for (Usuario usuario : usuarios) {
					%>
					<tr>
						<td><%=usuario.getNombres()%></td>
						<td><%=usuario.getCedula()%></td>
						<td><%=usuario.getEmail()%></td>
						<td><%=usuario.getUsuario()%></td>
					</tr>

					<% } %>
				</table>

			</div>
			<div class="box6"></div>
			<div class="box7"></div>
			<div class="box8"></div>
			<div class="box9"></div>
		</div>
	</section>
</body>
</html>
