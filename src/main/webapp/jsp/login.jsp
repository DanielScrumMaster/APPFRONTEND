<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login | Tienda</title>
    <link rel="stylesheet" href="../css/login.css">
</head>
<body>
    <p>.</p>
    <div class="contenedor" >

        <div class="logo">
            <!-- <img src="imagenes/LOGO.png" alt="Logo"> -->
        </div>
        <div class="titulo">
            <h1>Bienvenido</h1>
        </div>
        <div></div>
        <div></div>
        <div class="bloque">
            <div class="minigrid">
                <div>
                    <br><br><br>
                    <label class="texto" for="usuario"> <b>Usuario</b> :</label>
                    <br><br><br><br>
                    <label class="texto" for="contraseña"> <b>Contraseña:</b> </label>
                </div>

                <div>
                    <br><br>
                    <input class="cajaTexto" type="text" placeholder="   usuario">
                    <br><br><br>
                    <input class="cajaTexto" type="password" placeholder="   contraseña">
                </div> 
            </div>
        </div>
        <div></div>
        <div></div>
        <div class="boton">
            <br><br><br>
            <input type="submit" value="Iniciar sesión">
        </div>
        <div></div>
    </div>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="../js/alerts1.js"></script>
</body>
</html>
