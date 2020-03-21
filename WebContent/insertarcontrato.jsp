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
<h1>Insertar datos del contrato</h1>
<div id="divformulario">
	<h2><%= request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : "" %></h2>
	<form action="servletcontrato?op=3" autocomplete="off" method="post">
		
		<label for="id"><span class="campolabel">Identificador Cliente/Proveedor </span> <span class="rojo">*</span></label>
		<br>
		<input type="number" name="id" required placeholder="" title="Introduzca un id cliente/proveedor válido"> <br>
		<label for="comision"><span class="campolabel">Comisión </span><span class="rojo">*</span></label>
		<br>
		<input type="number" name="comision" required placeholder="" title=""> <br>
		<label for="encargadofacturacion"><span class="campolabel">Encargado de facturación </span><span class="rojo">*</span></label>
		<br>
		<select name="encargadofacturacion" class="campolabel">
		<option value="E">Encargado de facturación</option>
		<option value="C">El propio Cliente</option>
		</select> 
		<br>	
		<br>	
		<input name="aceptarterminos" type="checkbox" required id="aceptarterminos" value=""><span id="terminos">Acepto los términos y condiciones de privacidad</span> <br>
		<input type="submit" value="Enviar">
	</form>	
	<br>
	<a href="contratos.jsp">Menú Contratos</a>
	<br>
	<a href="menuprincipal.jsp">Menú principal</a>
	</div>	
</body>
</html>