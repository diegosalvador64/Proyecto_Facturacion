<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mostrar una forma de pago</title>
<link rel="stylesheet" href="estilos/estilos.css" type="text/css">
</head>
<body>
<jsp:useBean id="fp1" class="com.vipper.modelo.FormasPago" scope="request"/>
<h1>Datos de la forma de pago</h1>
<ul>
<li>Id Forma de Pago: <%=fp1.getIdformapago() %></li>
<br>
<li>Descripción     : <%=fp1.getDescripcion() %></li>
<br>
<li>Valor           : <%=fp1.getValor() %></li>
<br>
</ul>
</body>
</html>