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
		<section class="bott">
            <div class="titulo">
                <h2>Agregar Productos</h2>
            </div>
            <form action="./usuarios" method="post">

                <div class="contenedorProductos">
                    <div >
                        <label class="texto" id="nombreArchivo">Nombre  del Archivo:</label>
                    </div>

                    <div class="cargarArchivo">
                        <br><br>
                        <input class="cajaTexto" type="text" >
                        <br><br><br>
                        <input class="boton3" type="submit" value="Cargar">
                    </div>

                    <div>
                        <input class="boton2" type="submit" value="Examinar">
                    </div>
                </div>
            </form>
        </section>
	</div>
</body>
</html>