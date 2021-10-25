<%@page import="java.util.List"%>
<%@page import="com.dmaktech.usuarios.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Ventas</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, user-scalable=0,initial-scale=1.0, maximum-scale=1.0,minimun-scale=1.0">
<link rel="stylesheet" href="./css/usuarios.css">
<link rel="stylesheet" href="./css/ventas.css">
<script src="./js/ventas.js" defer></script>	
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
                            <input class="cajaTexto" type="text" placeholder="Cédula"><br><br>
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
							<th></th>
                        </tr>
                    </thead>
<<<<<<< HEAD
                    <tbody id="listaProductos">            
	                    <tr>
							<td> <input class="cajaTexto" type="text"> </td>
							<td> <input class="boton btn-consultar"type="submit" value="Consultar"> </td>
							<td> </td>
							<td> <input class="cajaTexto" type="number" value="0" min=1 disabled> </td>
							<td> </td>
	                    </tr>
						<tr>
							<td> <input class="cajaTexto" type="text"> </td>
							<td> <input class="boton btn-consultar"type="submit" value="Consultar"> </td>
							<td> </td>
							<td> <input class="cajaTexto" type="number" value="0" min=1 disabled> </td>
							<td> </td>
	                    </tr>
						<tr>
							<td> <input class="cajaTexto" type="text"> </td>
							<td> <input class="boton btn-consultar"type="submit" value="Consultar"> </td>
							<td> </td>
							<td> <input class="cajaTexto" type="number" value="0" min=1 disabled> </td>
							<td> </td>
	                    </tr>
						<tr>
							<td> <input class="cajaTexto" type="text"> </td>
							<td> <input class="boton btn-consultar"type="submit" value="Consultar"> </td>
							<td> </td>
							<td> <input class="cajaTexto" type="number" value="0" min=1 disabled> </td>
							<td> </td>
	                    </tr>
						<tr>
							<td> <input class="cajaTexto" type="text"> </td>
							<td> <input class="boton btn-consultar"type="submit" value="Consultar"> </td>
							<td> </td>
							<td> <input class="cajaTexto" type="number" value="0" min=1 disabled> </td>
							<td> </td>
	                    </tr>
						<tr>
							<td> <input class="cajaTexto" type="text"> </td>
							<td> <input class="boton btn-consultar"type="submit" value="Consultar"> </td>
							<td> </td>
							<td> <input class="cajaTexto" type="number" value="0" min=1 disabled> </td>
							<td> </td>
	                    </tr>
                    </tbody>
=======
                    <tr>
						<td> <input class="cajaTexto" type="text"> </td>
						<td> <input class="boton"type="submit" value="Consultar" > </td>
						<td> <label class="tablaVentas">Fresas</label> </td>
						<td> <input class="cajaTexto" type="text"> </td>
						<td> <label class="tablaVentas">$1600</label> </td>
						<td> <input class="redbuton" type="submit" value="X"></td>
                    </tr>
					<tr>
						<td> <input class="cajaTexto" type="text"> </td>
						<td> <input class="boton"type="submit" value="Consultar" > </td>
						<td> <label class="tablaVentas">Fresas</label> </td>
						<td> <input class="cajaTexto" type="text"> </td>
						<td> <label class="tablaVentas">$1600</label> </td>
						<td> <input class="redbuton" type="submit" value="X"></td>
                    </tr>
					<tr>
						<td> <input class="cajaTexto" type="text"> </td>
						<td> <input class="boton"type="submit" value="Consultar" > </td>
						<td> <label class="tablaVentas">Fresas</label> </td>
						<td> <input class="cajaTexto" type="text"> </td>
						<td> <label class="tablaVentas">$1600</label> </td>
						<td> <input class="redbuton" type="submit" value="X"></td>
                    </tr>
					<tr>
						<td> <input class="cajaTexto" type="text"> </td>
						<td> <input class="boton"type="submit" value="Consultar" > </td>
						<td> <label class="tablaVentas">Fresas</label> </td>
						<td> <input class="cajaTexto" type="text"> </td>
						<td> <label class="tablaVentas">$1600</label> </td>
						<td> <input class="redbuton" type="submit" value="X"></td>
                    </tr>
					<tr>
						<td> <input class="cajaTexto" type="text"> </td>
						<td> <input class="boton"type="submit" value="Consultar" > </td>
						<td> <label class="tablaVentas">Fresas</label> </td>
						<td> <input class="cajaTexto" type="text"> </td>
						<td> <label class="tablaVentas">$1600</label> </td>
						<td> <input class="redbuton" type="submit" value="X"></td>
                    </tr>
					<tr>
						<td> <input class="cajaTexto" type="text"> </td>
						<td> <input class="boton"type="submit" value="Consultar" > </td>
						<td> <label class="tablaVentas">Fresas</label> </td>
						<td> <input class="cajaTexto" type="text"> </td>
						<td> <label class="tablaVentas">$1600</label> </td>
						<td> <input class="redbuton" type="submit" value="X"></td>
                    </tr>
					
>>>>>>> 9d9ef1c5704f32b6f7ed7c9a35f74fd9568940c2
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
							<input class="cajaTexto" type="text" name="subtotal" id="subtotal" value="0"><br><br>
							<input class="cajaTexto" type="text" name="iva" id="totalIva"><br><br>
							<input class="cajaTexto" type="text" name="total" id="total"><br><br>
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
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</body>
</html>
