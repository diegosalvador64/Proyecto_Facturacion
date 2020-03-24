<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insertar forma de pago</title>
<link rel="stylesheet" href="estilos/estilos.css" type="text/css">
</head>
<body>
<h1>Insertar datos de la forma de pago</h1>
<div id="divformulario">
	<h2><%= request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : "" %></h2>
	<form action="servletformaspago?op=3" autocomplete="off" method="post">
		
		<label for="descripcion"><span class="campolabel">Descripción </span> <span class="rojo">*</span></label>
		<br>
		<input type="text" name="descripcion" required placeholder="" title=""> <br>
		<label for="valor"><span class="campolabel">Valor </span><span class="rojo">*</span></label>
		<br>
		<input type="number" name="valor" min="1" step="0.05" required placeholder="0.00" title=""> 
		<br>
		<br>
		<input name="aceptarterminos" type="checkbox" required id="aceptarterminos" value=""><span id="terminos">Acepto los términos y condiciones de privacidad</span> <br>
		<input type="submit" value="Enviar">
		<br>
		<input type="reset" value="Limpiar">
	</form>	
	</div>
	<br>
	<a href="formaspago.jsp">Menú Formas de Pago</a>
	<br>
	<a href="menuprincipal.jsp">Menú principal</a>	
	</body>
</html>