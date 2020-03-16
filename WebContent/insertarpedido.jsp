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
	<form action="servletpedido?op=3" autocomplete="off" method="post">
		 
		<label for="descripcion"><span class="campolabel">Descripción del pedido </span> <span class="rojo">*</span></label>
		<br>
		<input type="text" name="descripcion" required placeholder="" title=""> <br><br>
		<label for="id"><span class="campolabel">Identificador Cliente/Servidor </span><span class="rojo">*</span></label>
		<br>
		<input type="number" name="id" required placeholder="" title="Introduzca un id Cliente/Servidor válido"> <br><br>
		<label for="idformapago"><span class="campolabel">Formas de Pago </span><span class="rojo">*</span></label>
		<br>
		<select name="idformapago" class="campolabel">
		<option value="1">A plazos</option>
		<option value="2">Contado</option>
		<option value="3">A plazos bancarios</option>
		<option value="4">Como buenamente se pueda</option>
		</select>
		<br><br>		
		<label for="total"><span class="campolabel">Total </span><span class="rojo">*</span></label>
		<br>
		<input type="number" name="total" class="campolabel" required placeholder="" title="Teclee un valor numérico"> <br><br>	
		<label for="fecha"><span class="campolabel">Fecha </span><span class="rojo">*</span></label>
		<br>
		<input type="date" name="fecha" class="campolabel" required placeholder="" title="Introduzca una fecha válida"> <br><br>
		<label for="idservicios"><span class="campolabel">Servicios </span><span class="rojo">*</span></label>
		<br>
		<select name="idservicios" class="campolabel">
		<option value="1">Arreglos impresoras</option>
		<option value="2">Diseño paginas web</option>
		<option value="3">Desarrollo e-commerce</option>
		<option value="4">Tratamiento fotografías</option>
		<option value="5">Seo y posicionamiento Google</option>
		<option value="6">Completo</option>
		</select>
		<br><br>
		<label for="idcontrato"><span class="campolabel">Id Contrato </span><span class="rojo">*</span></label>
		<br>
		<select name="idcontrato" class="campolabel">
		<option value="1">Contrato privado</option>
		<option value="2">Contrato público</option>
		<option value="3">Contrato mixto</option>
		</select>
		<br><br>
		<label for="importe_facturado"><span class="campolabel">Importe facturado </span><span class="rojo">*</span></label>
		<br>
		<input type="number" name="importe_facturado" class="campolabel" required placeholder="" title=""Teclee un importe facturado numérico""> <br><br>
		<input name="aceptarterminos" type="checkbox" required id="aceptarterminos" value=""><span id="terminos">Acepto los términos y condiciones de privacidad</span><br> <br>
		<input type="submit" value="Enviar">
	</form>	
	</div>	
</body>
</html>