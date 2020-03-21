<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insertar cliente</title>
<link rel="stylesheet" href="estilos/estilos.css" type="text/css">
</head>
<body>
<h1>Insertar datos del cliente / proveedor</h1>
<div id="divformulario">
	<h2><%= request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : "" %></h2>
	<form action="servletfacturacion?op=3" autocomplete="off" method="post">

		<label for="nif"><span class="campolabel">Nif </span><span class="rojo">*</span></label><br>
		<input type="text" name="nif" value="" required pattern="[0-9]{8}[A-Z]{1}" placeholder="" autofocus title="Teclee un NIF v�lido">
		<br>
		<label for="nombre"><span class="campolabel">Nombre </span><span class="rojo">*</span></label>
		<br>
		<input type="text" name="nombre" required placeholder="" title="Rellene el campo"><br>
		<label for="direccion"><span class="campolabel">Direcci�n </span><span class="rojo">*</span></label>
		<br>
		<input type="text" name="direccion" required placeholder="" title="Rellene el campo"><br>
		<label for="tipo"><span class="campolabel">Tipo </span><span class="rojo">*</span></label>
		<br>
		<select name="tipo" class="campolabel">
		<option value="C">Cliente</option>
		<option value="P">Proveedor</option>
		</select>
		<br>
		<label for="email"><span class="campolabel">Email </span><span class="rojo">*</span></label>
		<br>
		<input type="text" name="email" required pattern="[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{1,5}" 
		placeholder="" title="Teclee un email v�lido"> <br>
		<label for="telefono"><span class="campolabel">Tel�fono </span><span class="rojo">*</span></label>
		<br>
		<input type="number" name="telefono" class="campolabel" required pattern="[0-9]{9}" placeholder="" title="Teclee un tel�fono v�lido de 9 d�gitos"> <br>
		
		<input name="aceptarterminos" type="checkbox" required id="aceptarterminos" value=""><span id="terminos">
		Acepto los t�rminos y condiciones de privacidad</span>
		<br>
		<input type="submit" value="Enviar">
	</form>
	<br>
	<a href="clienteproveedor.jsp">Men� Cliente-Proveedor</a>
	<br>
	<a href="menuprincipal.jsp">Men� principal</a>
	
	</div>	
</body>
</html>