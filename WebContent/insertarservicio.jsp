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
	<%String mensaje=(String) request.getAttribute("mensaje"); %>
	<%=mensaje %>
	<form action="servletservicio?op=3" autocomplete="off" method="post">
		
		<label for="descripcion"><span class="campolabel">Descripción </span><span class="rojo">*</span></label>
		<br>
		<input type="text" name="descripcion" required placeholder="" title="Rellene el campo"><br>
		<label for="direccion"><span class="campolabel">Coste </span><span class="rojo">*</span></label>
		<br>
		<input type="text" name="coste" required placeholder="" title="Rellene el campo"><br>
		<label for="id"><span class="campolabel">Identificador Cliente/Proveedor </span><span class="rojo">*</span></label>
		<br>
		<input type="text" name="id" required placeholder="" title="Introduzca un id cliente/proveedor válido"> <br>
		<label for="iva"><span class="campolabel">IVA </span><span class="rojo">*</span></label>
		<br>
		<input type="text" name="iva" required placeholder="" title="Los IVAS correctos son 4, 10, 15, 21%"> <br>
				
		<input name="aceptarterminos" type="checkbox" required id="aceptarterminos" value=""><span id="terminos">Acepto los términos y condiciones de privacidad</span> <br>
		<input type="submit" value="Enviar">
	</form>
	
	
	</div>	
</body>
</html>