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
    <link rel="stylesheet" href="./css/ventas.css">
<title>ventas</title>
</head>
<body>
	<header class="lista">
		<%@include file="./menu.jsp"%>
	</header>
	<div class="contenedor">
        <section class="topVentas">
            <section class="bott">
                <div class="titulo">
                    <h2>Consultar clientes</h2>
                </div>
    
                <form action="./usuarios" method="post">
    
                    <div class="agregar">
                        <div class="caja">
                            <br><br>
                            <input class="cajaTexto" type="text" placeholder="Cédula" ><br><br>
                            <label class="texto">Cliente</label><br><br>
                            <label class="texto">Codigo</label>
                        </div>
    
                        <div class="caja">
                            <br><br>
                            <div> <input class="boton1" type="submit" value="Consultar" > </div><br>
                            <div> <input class="cajaTexto" type="text"> </div><br>
                            <div> <input class="cajaTexto" type="text"> </div>
                        </div>
                    </div>
                </form>
            </section>
            
            <section class="mid">
                <table>
                    <thead>
                        <tr>
                            <th>Codigo <br> Productos</th>
                            <th></th>
                            <th>Nombre Producto</th>
                            <th>Cant.</th>
                            <th>Valor <br> Total</th>
                        </tr>
                    </thead>
                    <tr>
						<td> <input class="cajaTexto" type="text"> </td>
						<td> <input class="boton"type="submit" value="Consultar" > </td>
						<td> <input class="cajaTexto" type="text"> </td>
						<td> <input class="cajaTexto" type="text"> </td>
						<td> <input class="cajaTexto" type="text"> </td>
                    </tr>
					<tr>
						<td> <input class="cajaTexto" type="text"> </td>
						<td> <input class="boton"type="submit" value="Consultar" > </td>
						<td> <input class="cajaTexto" type="text"> </td>
						<td> <input class="cajaTexto" type="text"> </td>
						<td> <input class="cajaTexto" type="text"> </td>
                    </tr>
					<tr>
						<td> <input class="cajaTexto" type="text"> </td>
						<td> <input class="boton"type="submit" value="Consultar" > </td>
						<td> <input class="cajaTexto" type="text"> </td>
						<td> <input class="cajaTexto" type="text"> </td>
						<td> <input class="cajaTexto" type="text"> </td>
                    </tr>
					<tr>
						<td> <input class="cajaTexto" type="text"> </td>
						<td> <input class="boton"type="submit" value="Consultar" > </td>
						<td> <input class="cajaTexto" type="text"> </td>
						<td> <input class="cajaTexto" type="text"> </td>
						<td> <input class="cajaTexto" type="text"> </td>
                    </tr>
					<tr>
						<td> <input class="cajaTexto" type="text"> </td>
						<td> <input class="boton"type="submit" value="Consultar" > </td>
						<td> <input class="cajaTexto" type="text"> </td>
						<td> <input class="cajaTexto" type="text"> </td>
						<td> <input class="cajaTexto" type="text"> </td>
                    </tr>
					<tr>
						<td> <input class="cajaTexto" type="text"> </td>
						<td> <input class="boton"type="submit" value="Consultar" > </td>
						<td> <input class="cajaTexto" type="text"> </td>
						<td> <input class="cajaTexto" type="text"> </td>
						<td> <input class="cajaTexto" type="text"> </td>
                    </tr>
                </table>
            </section>
			<section>

			</section>
			<section class="total">
				<div class="titulo">
					<h2>Total</h2>
				</div>
	
				<form action="./usuarios" method="post">
	
					<div class="cajaTotal">
						<div class="caja">
							<br>
							<input class="boton" type="submit" value="descargar">
							<br><br>
							<input class="boton" type="submit" value="Confirmar">
						</div>
						<div class="caja" >
							<label class="texto" >Total Venta</label><br><br><br>
							<label class="texto" >Total IVA</label><br><br><br>
							<label class="texto" >Total con IVA</label>
						</div>
						<div>
							<input class="cajaTexto" type="text"><br><br>
							<input class="cajaTexto" type="text"><br><br>
							<input class="cajaTexto" type="text"><br><br>
						</div>
					</div>
				</form>
			</section>
            
        </section>
		<section>
			<div>
				
			</div>
		</section>
		
	</div>
</body>
</html>
