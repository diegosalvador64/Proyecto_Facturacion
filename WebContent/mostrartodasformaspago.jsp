<%@page import="com.vipper.modelo.FormasPago"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mostrar todas formas de pago</title>
<link rel="stylesheet" href="estilos/estilos.css" type="text/css">
</head>
<body>
<h1>Nuestras formas de pago son:</h1> 
<!--  usar un scriplet para recoger los servicios que están en el ámbito request -->

<% ArrayList<FormasPago> jsptodos = (ArrayList<FormasPago>) request.getAttribute("rtodos");%>
<table>
	<tr>
		<th>Id Formas de pago </th>
		<th>Descripción</th>
		<th>Valor</th>
	</tr>

<%for(FormasPago elemento: jsptodos){%>
<tr>
<td><%=elemento.getIdformapago() %></td>
<td><%=elemento.getDescripcion() %></td>
<td><%=elemento.getValor() %></td>

</tr>

<%} %>

<br>
<a href="formaspago.jsp">Menú Formas de Pago</a>
<br>
<a href="menuprincipal.jsp">Menú principal</a>
</body>
</html>