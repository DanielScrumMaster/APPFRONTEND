<%@page import="com.dmaktech.productos.Producto"%>
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
<title>Productos</title>
</head>
<body>
	<header class="lista">
        
            <%@include file="./menu.jsp"%>
        
    </header>
    <div class="contenedor">
        <section class="Productos">
            <div class="titulo">
                <h2>Agregar Productos</h2>
            </div>
            
            <form action="../usuarios" method="post">

                <div class="minigrid">
                    <div class="caja">
                        <label class="texto" for="cedula">Nombre del Archivo</label><br>    
                    </div>

                    <div class="caja">
                        <input class="cajaTexto" type="text" name="email"><br><br>
                        <input class="boton1" type="submit" name="crear" value="Cargar">
                    </div>

                    <div class="caja">
                        <input class="boton1" type="file" name="" value="Elegir Archivo" acept=".csv">
                    </div>
                </div>
            </form>
        </section>
        <section class="top">
            <div>
                <input class="botonNuevoUsuario" type="submit" name="crear" value="Ver Productos">
            </div>
            <div>
                <div class="barra">
                	<form action="./productos" method="GET">
						<label for="codigoBuscado">Buscar:</label>
						<input class="cajaBuscar" type="text" placeholder="Ingrese cod. de producto" name="codigoBuscado">
						<button class="botonBuscar" name="accion" value="buscar">&#128270;</button>		
					</form>
                </div>
            </div>
            
        </section>

        <section class="mid">
            <table>
                <thead>
                    <tr>
                        <th>Codigo</th>
                        <th>Nombre</th>
                        <th>IVA</th>
                        <th>Proveedor</th>
                        <th>Costo</th>
                        <th>Precio</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                	<% List<Producto> productos = (List<Producto>) request.getAttribute("productos"); %>
					<c:forEach items="${productos}" var="producto">
						<tr>
							<td>${producto.getCodigo()}</td>
							<td>${producto.getNombre()}</td>
							<td>${producto.getIva()}%</td>
							<td>${producto.getProveedor().getNombre()}</td>
							<td>${producto.getPrecioCompra()}</td>
							<td>${producto.getPrecioVenta()}</td>
							<td><input class="boton boton-editar" type="submit" value="Editar"></td>
							<td><a href="productos?accion=borrar&codigo=${producto.getCodigo()}">X</a></td>
						</tr>
					</c:forEach>              
                </tbody>
            </table>
        </section>        
    </div>
</body>
</html>
