<%@page import="java.util.ArrayList"%>
<%@page import="com.vipper.modelo.Pedidos"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mostrar todos los pedidos</title>
<link rel="stylesheet" href="estilos/estilos.css" type="text/css">
</head>
<body>
<h1>Nuestros pedidos son:</h1> 
<!--  usar un scriplet para recoger los pedidos que están en el ámbito request -->

<% ArrayList<Pedidos> jsptodos = (ArrayList<Pedidos>) request.getAttribute("rtodos");%>
<table>
	<tr>
		<th>Id Pedido</th>
		<th>Descripción pedido</th>
	 	<th>NIF Cliente/Proveedor</th> 
		<th>Forma de pago</th> 
		<th>Total</th>
		<th>Fecha</th>
		<th>Servicio</th> 
		<th>Id Contrato</th>
		<th>Importe facturado</th>
	</tr>

<%for(Pedidos elemento: jsptodos){%>
<tr>
<td><%=elemento.getIdpedido() %></td>
<td><%=elemento.getDescripcion() %></td>
<td><%=elemento.getNifClienteProveedor() %></td> 
<td><%=elemento.getDescripcionFormaPago() %></td> 
<td><%=elemento.getTotal() %></td>
<td><%=elemento.getFecha() %></td>
<td><%=elemento.getDescripcionServicios() %></td> 
<td><%=elemento.getIdcontrato() %></td>
<td><%=elemento.getImporte_facturado() %></td>

</tr>

<%} %>

<br>
<a href="pedidos.jsp">Menú Pedidos</a>
<br>
<a href="menuprincipal.jsp">Menú principal</a>
</body>
</html>