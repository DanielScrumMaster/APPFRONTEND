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
    <meta name="viewport" content="width=device-width, user-scalable=0,initial-scale=1.0, maximum-scale=1.0,minimun-scale=1.0">
    <link rel="stylesheet" href="../css/usuarios.css">
    <title>Usuarios</title>
</head>
<body>
    <header class="lista">
        
            <%@include file="./menu.jsp"%>
        
    </header>
    <div class="contenedor">
        <section class="top">
            <div>
                <input class="botonNuevoUsuario" type="submit" name="crear" value="Nuevo Usuario">
            </div>
            <div>
                <div class="barra">
                    <span>Buscar:</span> <input class="cajaBuscar" type="text" placeholder="Ingrese numero de cedula" > <input class="botonBuscar" type="submit" value="&#128270;">
                </div>
            </div>
            
        </section>

        <section class="mid">
            <table>
                <thead>
                    <tr>
                        <th>Cedula</th>
                        <th>Nombre Completo</th>
                        <th>Correo Electronico</th>
                        <th>Usuario</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <%
					for (Usuario usuario : usuarios) {
				%>
                <tr>
                    <td><%=usuario.getCedula()%></td>
                    <td><%=usuario.getNombres()%></td>
                    <td><%=usuario.getEmail()%></td>
                    <td><%=usuario.getUsuario()%></td>
                    <td><input class="boton" type="submit" value="Editar"></td>
                    <td><input class="redbuton" type="submit" value="X"></td>
                </tr>
                <% } %>
            </table>
        </section>

        <section class="bot">
            <div class="titulo">
                <h2>Agregar nuevo usuario</h2>
            </div>
            
            <form action="../usuarios" method="post">

                <div class="minigrid">
                    <div class="caja">
                        <label class="texto" for="cedula">Cedula</label><br>
                        <input class="cajaTexto" type="text" name="cedula"><br><br>
                        <label class="texto" for="nombres">NombreCompleto</label><br>
                        <input class="cajaTexto" type="text" name="nombres">     
                    </div>

                    <div class="caja">
                        <label class="texto" for="email">Correo Electronico:</label><br>
                        <input class="cajaTexto" type="text" name="email"><br><br>
                        <label class="texto" for="usuario"> Usuario:</label><br>
                        <input class="cajaTexto" type="text" name="usuario">
                    </div>

                    <div class="caja">
                        <label class="texto" for="password">Contraseña</label><br>
                        <input class="cajaTexto" type="password" name="password"><br><br>
                        <br>
                        <input class="botonAgregar" type="submit" name="crear" value="Agregar">
                    </div>
                </div>
            </form>
        </section>
    </div>
</body>
</html>
