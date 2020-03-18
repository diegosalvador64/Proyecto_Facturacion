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
<h2 class="mostraruno"><%= request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : "" %></h2>
<br>
<ul class="mostraruno">
<li><b>Id Forma de Pago:</b> <%=fp1.getIdformapago() %></li>
<br>
<li><b>Descripción     :</b> <%=fp1.getDescripcion() != null ? fp1.getDescripcion() : "" %></li>
<br>
<li><b>Valor           :</b> <%=fp1.getValor() %></li>
<br>
</ul>
</body>
</html>