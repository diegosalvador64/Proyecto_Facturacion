<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificar cliente/proveedor</title>
<link rel="stylesheet" href="estilos/estilos.css" type="text/css">
</head>
<body>
<h1>Modificar la dirección del cliente / proveedor</h1>
<br>
<div id="divformulario">
	<%String mensaje=(String) request.getAttribute("mensaje"); %>
	<%=mensaje %>
	<form action="servletfacturacion?op=4" autocomplete="off" method="post">

		<label for="id"><span class="campolabel">Id cliente/proveedor </span> <span class="rojo">*</span></label><br><br>
		<input type="text" name="id" value="" required placeholder="Tu nif" autofocus title="Rellene el campo">
		<br>		
		<label for="direccion"><span class="campolabel">Dirección </span><span class="rojo">*</span></label>
		<br><br>
		<input type="text" name="direccion" required placeholder="Tu dirección" title="Rellene el campo"><br><br><br>
		<input type="submit" value="Enviar">
	</form>
		
	</div>	
</form>	
</body>
</html>