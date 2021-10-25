<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="./css/reportes.css">
<meta charset="UTF-8">
<title>Reportes</title>
</head>
<body>
	<header class="lista">
		<%@include file="./menu.jsp"%>
	</header>
	<div class="contenedor">
        <form>
            <input class="boton" type="submit" value="Listado de Usuarios"><br><br><br>
            <input class="boton" type="submit" value="Listado de Clientes"><br><br><br>
            <input class="boton" type="submit" value="Ventas por Cliente"> 
        </form>
    </div>
    <div class="contenedor">
        <form>
            <table>
				<thead>
					<tr>
						<th>Cedula</th>
						<th>Nombre</th>
						<th>Correo</th>
						<th>Usuario</th>
						<th>Pasword</th>
					</tr>
				</thead>
				<tr>
                    <td>1032</td>
                    <td>daniel</td>
                    <td>danielbueno848@gamil.com</td>
                    <td>danielb10</td>
                    <td>12345678</td>
				</tr>
                <tr>
                    <td>1032</td>
                    <td>daniel</td>
                    <td>danielbueno848@gamil.com</td>
                    <td>danielb10</td>
                    <td>12345678</td>
				</tr>
			</table> 
        </form>
    </div>
</body>
</html>