<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="estilos/stylelogin.css" type="text/css">
</head>
<body>
<h1>Men� principal de Facturaci�n</h1>
	
<div class="flex1">
	
		<h2><%= request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : "" %></h2>
	
		<!--  <div class="contenedor-imagenes">
				<div class="imagen"><img src="img/img_avatar.png" alt="avatar"></div>
				<div class="times">&times;</div>
			</div>-->	
			<div>
				<form action="servletfacturacion?op=6" autocomplete="off" method="post">
					
					<label for="nombre">Usuario</label><br>
					<input type="text" name="nombre" value="" required placeholder="Entrar usuario" autofocus title="Rellene el campo"><br>
					<label for="contrasena">Contrase�a:</label><br>
					<input type="password" name="contrasena" required placeholder="Entrar contrase�a"
					title="Rellene el campo">
					<br><br>
					<input type="submit" value="Iniciar sesi�n"><br>
					<input type="checkbox" name="recordarme" class="recordarme" value="" checked><span class="terminos"></span>Recordarme<br><br>
					
					
				</form>
			</div>				
</div>
</body>
</html>