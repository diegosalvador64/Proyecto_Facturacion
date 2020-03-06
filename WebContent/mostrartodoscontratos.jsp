<%@page import="java.util.ArrayList"%>
<%@page import="com.vipper.modelo.Contratos"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mostrar todos contratos</title>
<link rel="stylesheet" href="estilos/estilos.css" type="text/css">
</head>
<body>
<h1>Nuestros servicios son:</h1> 
<!--  usar un scriplet para recoger los servicios que están en el ámbito request -->

<% ArrayList<Contratos> jsptodos = (ArrayList<Contratos>) request.getAttribute("rtodos");%>
<table>
	<tr>
		<th>Id Contrato </th>
		<th>Id Cliente/Proveedor</th>
		<th>Comisión</th>
		<th>Encargado facturación</th>
	</tr>

<%for(Contratos elemento: jsptodos){%>
<tr>
<td><%=elemento.getIdcontrato() %></td>
<td><%=elemento.getId() %></td>
<td><%=elemento.getComision() %></td>
<td><%=elemento.getEncargadofacturacion() %></td>

</tr>

<%} %>
</body>
</html>