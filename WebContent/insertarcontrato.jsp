<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insertar contrato</title>
<link rel="stylesheet" href="estilos/estilos.css" type="text/css">
</head>
<body>
<h1>Insertar datos del servicio</h1>
<div id="divformulario">
	<%String mensaje=(String) request.getAttribute("mensaje"); %>
	<%=mensaje %>
	<form action="servletcontrato?op=3" autocomplete="off" method="post">
		
		<label for="id"><span class="campolabel">Identificador Cliente/Proveedor </span> <span class="rojo">*</span></label>
		<br>
		<input type="text" name="id" required placeholder="" title="Introduzca un id cliente/proveedor válido"> <br>
		<label for="comision"><span class="campolabel">Comisión </span><span class="rojo">*</span></label>
		<br>
		<input type="text" name="comision" required placeholder="" title=""> <br>
		<label for="encargadofacturacion"><span class="campolabel">Encargado de facturación </span><span class="rojo">*</span></label>
		<br>
		<input type="text" name="encargadofacturacion" required placeholder="" title=""> <br>		
		<input name="aceptarterminos" type="checkbox" required id="aceptarterminos" value=""><span id="terminos">Acepto los términos y condiciones de privacidad</span> <br>
		<input type="submit" value="Enviar">
	</form>	
	</div>	
</body>
</html>