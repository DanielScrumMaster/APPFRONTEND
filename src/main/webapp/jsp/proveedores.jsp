<%@page import="com.dmaktech.proveedores.Proveedor"%>
<%@page import="java.util.List"%>
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
<title>Proveedores</title>
<script type="text/javascript" src="./js/datosForm.js" defer></script>
</head>
<body>
	<header class="lista">
		<%@include file="./menu.jsp"%>
	</header>
	<div class="contenedor">
		<section class="top">
			<div>
				<input class="botonNuevoUsuario" type="submit" name="crear"	value="Proveedores">
			</div>
			<div>
				<div class="barra">
					<form action="./proveedores" method="GET">
						<label for="nit">Buscar:</label>
						<input class="cajaBuscar" type="text" placeholder="Ingrese el nit del proveedor" name="nitBuscado">
						<button class="botonBuscar" name="accion" value="buscar">&#128270;</button>		
					</form>					
				</div>
			</div>
		</section>

		<section class="mid">
			<table>
				<thead>
					<tr>
						<th>NIT</th>
						<th>Nombre Completo</th>
						<th>Dirección</th>
						<th>Telefono</th>
						<th>Ciudad</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody id="listado">
					<% List<Proveedor> proveedores = (List<Proveedor>) request.getAttribute("proveedores"); %>
					<c:forEach items="${proveedores}" var="proveedor">
						<tr>
							<td>${proveedor.getNit()}</td>
							<td>${proveedor.getNombre()}</td>
							<td>${proveedor.getDireccion()}</td>
							<td>${proveedor.getTelefono()}</td>
							<td>${proveedor.getCiudad()}</td>
							<td><input class="boton boton-editar" type="submit" value="Editar"></td>
							<td><a href="proveedores?accion=borrar&nit=${proveedor.getNit()}">X</a></td>
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
		
					<form action="./proveedores" method="post">
		
						<div class="agregar">
							<div class="caja">
								<label class="texto" for="nit">NIT</label><br> 
								<input class="cajaTexto" type="text" name="nit" required><br><br>
		
								<label class="texto" for="nombre">NombreCompleto</label><br>
								<input class="cajaTexto" type="text" name="nombre" required><br><br>
		
								<label class="texto" for="direccion">Direccion</label><br>
								<input class="cajaTexto" type="text" name="direccion" required>
							</div>
		
							<div class="caja">
								<label class="texto" for="telefono">Telefono</label><br>
								<input class="cajaTexto" type="text" name="telefono" required><br><br>
		
								<label class="texto" for="ciudad">Ciudad</label><br>
								<input class="cajaTexto" type="text" name="ciudad" required>
								
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
		
					<form action="./proveedores" method="post" id="formActualizar">
		
						<div class="agregar">
							<div class="caja">
								<label class="texto" for="nit">NIT</label><br> 
								<input class="cajaTexto" type="text" name="nit" required><br><br>
		
								<label class="texto" for="nombre">NombreCompleto</label><br>
								<input class="cajaTexto" type="text" name="nombre" required><br><br>
		
								<label class="texto" for="direccion">Direccion</label><br>
								<input class="cajaTexto" type="text" name="direccion" required>
							</div>
		
							<div class="caja">
								<label class="texto" for="telefono"> Telefono</label><br>
								<input class="cajaTexto" type="text" name="telefono" required><br><br>
		
								<label class="texto" for="ciudad">Ciudad</label><br>
								<input class="cajaTexto" type="text" name="ciudad" required>
								
								<br><br><br> <input class="boton1" type="submit" name="accion" value="actualizar">
							</div>
						</div>
					</form>
				</section>
			</div>
		</section>		
	</div>
	<% String mensaje = (String) request.getAttribute("mensajeAlerta"); %>
	<% String icono = (String) request.getAttribute("iconoAlerta"); %>
	<input type="hidden" value="<%= mensaje %>" id="mensajeAlerta"/>
	<input type="hidden" value=<%= icono %> id="iconoAlerta"/>
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="./js/alerts.js"></script>
</body>
</html>