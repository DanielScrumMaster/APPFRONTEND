<%@page import="com.dmaktech.usuarios.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% Usuario usuario = (Usuario) request.getAttribute("usuario"); %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="estilosCSS/usuarios.css">
    <link rel="stylesheet" type="text/css" href="estilosCSS/menu.css">
    <title>Usuario | Tienda</title>

    <div class="grid">
        <div class="logo">
            <img src="imagenes/LOGO.png" alt="Logo">
        </div>
        <div class="lista">
            <menu>
                <ul class="menu">
                    <li><a href="#">Usuarios</a></li>
                    <li><a href="#">Clientes</a></li>
                    <li><a href="#">Proveedores</a></li>
                    <li><a href="#">Productos</a></li>
                    <li><a href="#">Ventas</a></li>
                    <li><a href="#">Reportes</a></li>
                </ul>
            </menu>
        </div>
    </div>
    <p>.</p>
</head>
<body>
    <section class="formulario">
        <div class="container">
            <div class="box1"></div>
            <div class="box2"></div>
            <div class="box3"></div>
            <div class="box4"></div>
            <div class="box5">
                 
                    <div class="minigrid">
                        <div class="boxa">
                            <br>
                            <label class="texto" for="cedula">Cedula</label><br>
                            <br><br><br>
                            <label class="texto" for="lname">Nombre Completo</label><br>
                            <br><br><br>
                            <label class="texto" for="Ce">Correo Electronico:</label><br>
                        </div>
                        <div class="boxa">
                            <input class="caja" type="text" id="cedula" name="cedula"><br>
                            <br><br>
                            <input class="caja" type="text" id="NombreC" name="NombreC"><br>
                            <br><br>
                            <input class="caja" type="text" id="Ce" name="Ce"><br>
                        </div>
                        
                        <div class="boxb">
                            <br>
                            <label class="texto" for="Usuario"> Usuario:</label><br>
                            <br><br><br>
                            <label class="texto" for="Con">Contraseña</label><br>
                            
                        </div>
                        <div class="boxb">
                            <input class="caja" type="text" id="Usuario" name="Usuario"><br>
                            <br><br>
                            <input class="caja" type="password" id="Con" name="Con"><br>
                        </div>
    
                        <div class="boxc">
                            <input class="boton" type="submit" value="Consultar">   
                        </div>
                        <div class="boxc">
                            <input class="boton" type="submit" value="Crear">
                        </div>
                        <div class="boxd">
                            <input class="boton" type="submit" value="Actualizar">   
                        </div>
                        <div class="boxc">
                            <input class="boton" type="submit" value="Borrar">
                        </div>
                    </div>
                
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
            <div class="box5">tabla</div>  
            <div class="box6"></div>
            <div class="box7"></div>
            <div class="box8"></div>
            <div class="box9"></div>
        </div>
    </section>  
</body>
</html>
