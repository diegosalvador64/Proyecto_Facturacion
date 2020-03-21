<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insertar pedido</title>
<link rel="stylesheet" href="estilos/estilos.css" type="text/css">
</head>
<body>
<h1>Insertar datos del pedido</h1>
<div id="divformulario">
	<h2><%= request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : "" %></h2>
	 	
	<form action="servletfacturas?op=2" autocomplete="off" method="post">
		 <label for="id"><span class="campolabel">Identificador Cliente/Servidor </span><span class="rojo">*</span></label>
		<br>
		<input type="number" name="id" required placeholder="" title="Introduzca un id Cliente/Servidor v�lido"> <br><br>
		<label for="idpedido"><span class="campolabel">Identificador Pedido </span><span class="rojo">*</span></label>
		<br>
		<input type="number" name="idpedido" required placeholder="" title="Introduzca un id pedido v�lido"> <br><br>
		<label for="idservicios"><span class="campolabel">Servicios </span><span class="rojo">*</span></label>
		<br>
		<select name="idservicios" class="campolabel">
		<option value="1">Arreglos impresoras</option>
		<option value="2">Dise�o paginas web</option>
		<option value="3">Desarrollo e-commerce</option>
		<option value="4">Tratamiento fotograf�as</option>
		<option value="5">Seo y posicionamiento Google</option>
		<option value="6">Completo</option>
		</select>
		<br>
		<br>
		<label for="importe"><span class="campolabel">Importe </span><span class="rojo">*</span></label>
		<br>
		<input type="number" name="importe" class="campolabel" required placeholder="" title="Teclee un valor num�rico"> <br>	
		<br>
		<label for="idformapago"><span class="campolabel">Formas de Pago </span><span class="rojo">*</span></label>
		<br>
		<select name="idformapago" class="campolabel">
		<option value="1">A plazos</option>
		<option value="2">Contado</option>
		<option value="3">A plazos bancarios</option>
		<option value="4">Como buenamente se pueda</option>
		</select>
		<br><br>		
		<label for="idcontrato"><span class="campolabel">Id Contrato </span><span class="rojo">*</span></label>
		<br>
		<select name="idcontrato" class="campolabel">
		<option value="1">Contrato privado</option>
		<option value="2">Contrato p�blico</option>
		<option value="3">Contrato mixto</option>
		</select>
		<br><br>
		<input name="aceptarterminos" type="checkbox" required id="aceptarterminos" value=""><span id="terminos">Acepto los t�rminos y condiciones de privacidad</span><br> <br>
		<input type="submit" value="Enviar">
	</form>
	<br>
	<a href="facturas.jsp">Men� Facturas</a>
	<br>
	<a href="menuprincipal.jsp">Men� principal</a>	
	</div>	
</body>
</html>