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
	<h2><%= request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : "" %></h2>
	<form action="servletfacturacion?op=4" autocomplete="off" method="post">

		<label for="id"><span class="campolabel">Id cliente/proveedor </span> <span class="rojo">*</span></label><br><br>
		<input type="number" name="id" min="1" value="" required placeholder="" autofocus title="Rellene el campo">
		<br>		
		<label for="direccion"><span class="campolabel">Dirección </span><span class="rojo">*</span></label>
		<br><br>
		<input type="text" name="direccion" required placeholder="" title="Rellene el campo"><br><br><br>
		<input type="submit" value="Enviar">
	</form>
		
	</div>	
</form>	
<br>	
	<a href="clienteproveedor.jsp">Menú Cliente-Proveedor</a>
	<br>
	<a href="menuprincipal.jsp">Menú principal</a>
</body>
</html>