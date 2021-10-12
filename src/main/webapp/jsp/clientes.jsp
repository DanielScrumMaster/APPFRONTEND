<%@page import="java.util.List"%>
<%@page import="com.dmaktech.clientes.Cliente"%>
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
<title>Clientes</title>
<script type="text/javascript" src="./js/datosForm.js" defer></script>
</head>
<body>
	<header class="lista">
		<%@include file="./menu.jsp"%>
	</header>
	<div class="contenedor">
		<section class="top">
			<div>
				<input class="botonNuevoUsuario" type="submit" name="crear"
					value="Clientes">
			</div>
			<div>
				<div class="barra">
					<form action="./clientes" method="GET">
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
						<th>Direccion</th>
						<th>Telefono</th>
                        <th>Correo Electronico</th>
						<th></th>
						<th></th>
					</tr>
				</thead>			
				<% List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes"); %>	
				<tbody id="listado">
					<c:forEach items="${clientes}" var="cliente">
						<tr>
							<td>${cliente.getCedula()}</td>
							<td>${cliente.getNombres()}</td>
							<td>${cliente.getDireccion()}</td>
							<td>${cliente.getTelefono()}</td>
							<td>${cliente.getEmail()}</td>
							<td><input class="boton boton-editar" type="submit" value="Editar"></td>
							<td><a href="clientes?accion=borrar&cedula=${cliente.getCedula()}">X</a></td>
						</tr>		
					</c:forEach>
				</tbody>		
			</table>
		</section>

		<section class="bot">
			<div>
				<section class="bott">
					<div class="titulo">
						<h2>Agregar nuevo cliente</h2>
					</div>
		
					<form action="./clientes" method="post">
		
						<div class="agregar">
							<div class="caja">
								<label class="texto" for="cedula">Cedula</label><br> 
								<input class="cajaTexto" type="text" name="cedula" required><br><br>
		
								<label class="texto" for="nombres">Nombre Completo</label><br>
								<input class="cajaTexto" type="text" name="nombres" required><br><br>
		
								<label class="texto" for="email">Direccion</label><br>
								<input class="cajaTexto" type="text" name="direccion" required>
							</div>
		
							<div class="caja">
								<label class="texto" for="usuario">Telefono</label><br>
								<input class="cajaTexto" type="text" name="telefono" required><br><br>
		
								<label class="texto" for="email">Correo Electronico</label><br>
								<input class="cajaTexto" type="text" name="email" required>
								
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
		
					<form action="./clientes" method="post" id="formActualizar">
		
						<div class="agregar">
							<div class="caja">
								<label class="texto" for="cedula">Cedula</label><br> 
								<input class="cajaTexto" type="text" name="cedula" required><br><br>
		
								<label class="texto" for="nombres">NombreCompleto</label><br>
								<input class="cajaTexto" type="text" name="nombres" required><br><br>
		
								<label class="texto" for="email">Direccion</label><br>
								<input class="cajaTexto" type="text" name="direccion" required>
							</div>
		
							<div class="caja">
								<label class="texto" for="usuario"> Telefono</label><br>
								<input class="cajaTexto" type="text" name="telefono" required><br><br>
		
								<label class="texto" for="email">Correo Electronico</label><br>
								<input class="cajaTexto" type="text" name="email" required>
								
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