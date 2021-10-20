<%@page import="java.util.List"%>
<%@page import="com.dmaktech.usuarios.Usuario"%>
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
                        <input class="botonAgregar" type="submit" name="crear" value="Cargar">
                    </div>

                    <div class="caja">
                        <input class="botonAgregar" type="submit" name="crear" value="Examinar">
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
                    <span>Buscar:</span> <input class="cajaBuscar" type="text" placeholder="Ingrese cod. de prodcuto" > <input class="botonBuscar" type="submit" value="&#128270;">
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
                        <th>costo</th>
                        <th>Precio</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tr>
                    <td>242</td>
                    <td>Fresa</td>
                    <td>5%</td>
                    <td>Carulla</td>
                    <td>500</td>
                    <td>1500</td>
                    <td><input class="boton" type="submit" value="Editar"></td>
                    <td><input class="redbuton" type="submit" value="X"></td>
                </tr>
            </table>
        </section>

        
    </div>
</body>
</html>
