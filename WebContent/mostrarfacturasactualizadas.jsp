<%@page import="com.vipper.modelo.Factura"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mostrar las facturas actualizadas</title>
<link rel="stylesheet" href="estilos/estilos.css" type="text/css">
</head>
<body>
<h1>Facturas actualizadas:</h1> 
<!--  usar un scriplet para recoger las facturas que están en el ámbito request -->

<% ArrayList<Factura> jsptodos = (ArrayList<Factura>) request.getAttribute("rtodos");%>
<table>
	<tr>
		<th>Id Factura</th>
		<th>Id Cliente/Proveedor</th>
	 	<th>Id Pedido</th> 
		<th>Fecha</th> 
		<th>Id Servicios</th>
		<th>Importe</th>
		<th>Id Forma de Pago</th> 
		<th>Id Contrato</th>
		<th>Concepto</th>
		<th>IVA</th>
	</tr>
	
<%for(Factura elemento: jsptodos){%>
<tr>
<td><%=elemento.getIdfactura() %></td>
<td><%=elemento.getId() %></td>
<td><%=elemento.getIdpedido() %></td> 
<td><%=elemento.getFecha() %></td> 
<td><%=elemento.getIdservicios() %></td>
<td><%=elemento.getImporte() %></td>
<td><%=elemento.getIdformapago() %></td> 
<td><%=elemento.getIdcontrato() %></td>
<td><%=elemento.getConcepto() %></td>
<td><%=elemento.getIva() %></td>

</tr>

<%} %>
<br>
<a href="facturas.jsp">Menú Facturas</a>
<br>
<a href="menuprincipal.jsp">Menú principal</a>
</body>
</html>>