<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insertar servicio</title>
<link rel="stylesheet" href="estilos/estilos.css" type="text/css">
</head>
<body>
<h1>Insertar datos del servicio</h1>
<div id="divformulario">
	<h2><%= request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : "" %></h2>
	<form action="servletservicio?op=3" autocomplete="off" method="post">
		
		<label for="descripcion"><span class="campolabel">Descripción </span><span class="rojo">*</span></label>
		<br>
		<input type="text" name="descripcion" required placeholder="" title="Rellene el campo"><br>
		<label for="direccion"><span class="campolabel">Coste </span><span class="rojo">*</span></label>
		<br>
		<input type="number" name="coste" required placeholder="" title="Rellene el campo"><br>
		<label for="id"><span class="campolabel">Identificador Cliente/Proveedor </span><span class="rojo">*</span></label>
		<br>
		<input type="number" name="id" required placeholder="" title="Introduzca un id cliente/proveedor válido"> <br>
		<label for="iva"><span class="campolabel">IVA </span><span class="rojo">*</span></label>
		<br>
		<select name="iva" class="campolabel">
		<option value="4">4% - Superreducido</option>
		<option value="10">10% - Reducido</option>
		<option value="15">15% - Normal</option>
		<option value="21">21% - Cultural</option>
		</select>
		<br>
		<br>
		<input name="aceptarterminos" type="checkbox" required id="aceptarterminos" value=""><span id="terminos">Acepto los términos y condiciones de privacidad</span> <br>
		<input type="submit" value="Enviar">
	</form>
	<br>
	<a href="servicios.jsp">Menú Servicios</a>
	<br>
	<a href="menuprincipal.jsp">Menú principal</a>
	
	</div>	
</body>
</html>