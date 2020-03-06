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
	<%String mensaje=(String) request.getAttribute("mensaje"); %>
	<%=mensaje %>
	<form action="servletfacturacion?op=3" autocomplete="off" method="post">

		<label for="nif"><span class="campolabel">Nif </span><span class="rojo">*</span></label><br>
		<input type="text" name="nif" value="" required placeholder="Tu nif" autofocus title="Rellene el campo">
		<br>
		<label for="nombre"><span class="campolabel">Nombre </span><span class="rojo">*</span></label>
		<br>
		<input type="text" name="nombre" required placeholder="Tu nombre" title="Rellene el campo"><br>
		<label for="direccion"><span class="campolabel">Dirección </span><span class="rojo">*</span></label>
		<br>
		<input type="text" name="direccion" required placeholder="Tu dirección" title="Rellene el campo"><br>
		<label for="tipo"><span class="campolabel">Tipo (C=Cliente - P=Proveedor) </span><span class="rojo">*</span></label>
		<br>
		<input type="text" name="tipo" required placeholder="Tu tipo" title="Solo se permiten C ó P"> <br>
		<label for="email"><span class="campolabel">Email </span><span class="rojo">*</span></label>
		<br>
		<input type="text" name="email" required placeholder="Tu email" title="Rellene el campo"> <br>
		<label for="telefono"><span class="campolabel">Teléfono </span><span class="rojo">*</span></label>
		<br>
		<input type="text" name="telefono" required placeholder="Tu teléfono" title="Rellene el campo"> <br>
		
		<input name="aceptarterminos" type="checkbox" required id="aceptarterminos" value=""><span id="terminos">
		Acepto los términos y condiciones de privacidad</span>
		<br>
		<input type="submit" value="Enviar">
	</form>
	
	
	</div>	
</body>
</html>