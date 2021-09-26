<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tienda | D2 Mak Tech</title>
    <link rel="stylesheet" href="../css/login.css">
</head>
<body>
    <p>.</p>
    <div class="contenedor">
        <div class="inicie_sesion">
            <h2>Bienvenido a la tienda genérica</h2>
        </div>
        <div class="iniciar_sesion">
            <form action ="/LoginServlet" method="POST">
                <label for="usuario">Nombre de usuario:</label>
                <input type="text" placeholder="Ingrese su nombre de usuario" name="usuario">
                <br>
                <br>
                <label for="contraseña">Contraseña:</label>
                <input type="password" placeholder="Ingrese su contraseña" name="password">
                <br>
                <br>
                <br>
                <input type="submit" value="Iniciar sesión">
            </form>
        </div>
    </div>
</body>
</html>