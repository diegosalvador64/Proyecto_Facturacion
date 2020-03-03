<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Insertar datos del cliente / proveedor</h1>
<div id="divformulario">
	<%String mensaje=(String) request.getAttribute("mensaje"); %>
	<%=mensaje %>
	<form action="servletpedido?op=3" autocomplete="off" method="post">
	

descripcion varchar(45) 
id int 
idformapago int 
total double 
fecha date 
idservicios int 
idcontrato int 
importe_facturado double

		<label for="idpedido">Idpedido<span class="rojo">*</span></label><br>
		<input type="text" name="idpedido" value="" required placeholder="id pedido" autofocus title="Rellene el campo">
		<br>
		<label for="descripcion">Descripcion <span class="rojo">*</span></label>
		<br>
		<input type="text" name="nombre" required placeholder="Tu nombre" title="Rellene el campo"><br>
		<label for="direccion">Dirección <span class="rojo">*</span></label>
		<br>
		<input type="text" name="direccion" required placeholder="Tu dirección" title="Rellene el campo"><br>
		<label for="tipo">Tipo (C=Cliente - P=Proveedor) <span class="rojo">*</span></label>
		<br>
		<input type="text" name="tipo" required placeholder="Tu tipo" title="Solo se permiten C ó P"> <br>
		<label for="email">Email <span class="rojo">*</span></label>
		<br>
		<input type="text" name="email" required placeholder="Tu email" title="Rellene el campo"> <br>
		<label for="telefono">Teléfono<span class="rojo">*</span></label>
		<br>
		<input type="text" name="telefono" required placeholder="Tu teléfono" title="Rellene el campo"> <br>
		
		<input name="aceptarterminos" type="checkbox" required id="aceptarterminos" value=""><span id="terminos">Acepto los términos y </span><a href="#">condiciones de privacidad</a> <br>
		<input type="submit" value="Enviar">
	</form>
	
	
	</div>	

</body>
</html>