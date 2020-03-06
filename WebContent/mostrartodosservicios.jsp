<%@page import="java.util.ArrayList"%>
<%@page import="com.vipper.modelo.Servicio"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mostrar todos servicios</title>
<link rel="stylesheet" href="estilos/estilos.css" type="text/css">
</head>
<body>
<h1>Nuestros servicios son:</h1> 
<!--  usar un scriplet para recoger los servicios que están en el ámbito request -->

<% ArrayList<Servicio> jsptodos = (ArrayList<Servicio>) request.getAttribute("rtodos");%>
<table>
	<tr>
		<th>Id Servicio </th>
		<th>Descripción</th>
		<th>Coste</th>
		<th>Id Cliente/Proveedor</th>
		<th>IVA</th>
	</tr>

<%for(Servicio elemento: jsptodos){%>
<tr>
<td><%=elemento.getIdservicios() %></td>
<td><%=elemento.getDescripcion() %></td>
<td><%=elemento.getCoste() %></td>
<td><%=elemento.getId() %></td>
<td><%=elemento.getIva() %></td>

</tr>

<%} %>
</body>
</html>