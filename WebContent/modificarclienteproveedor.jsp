<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Modificar la dirección del cliente / proveedor</h1>
<h1>Modificar </h1>
<div id="divformulario">
	<%String mensaje=(String) request.getAttribute("mensaje"); %>
	<%=mensaje %>
	<form action="servletfacturacion?op=4" autocomplete="off" method="post">

		<label for="id">Id usuario <span class="rojo">*</span></label><br>
		<input type="text" name="id" value="" required placeholder="Tu nif" autofocus title="Rellene el campo">
		<br>		
		<label for="direccion">Dirección <span class="rojo">*</span></label>
		<br>
		<input type="text" name="direccion" required placeholder="Tu dirección" title="Rellene el campo"><br><br>
		<input type="submit" value="Enviar">
	</form>
		
	</div>	
</form>	
</body>
</html>