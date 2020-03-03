<%@page import="org.eclipse.jdt.internal.compiler.ast.ForeachStatement"%>
<%@page import="com.vipper.modelo.Pedido"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p> Los pedidos son:</p>
<!--  usar un scriplet para recoger los productos que están en el ámbito request -->
<% ArrayList<Pedido> jsptodos = (ArrayList<Pedido>) request.getAttribute("rtodos");%>
<table>
	<tr>
		<th>Id_pedido </th>
		<th>Descripción </th>
		<th>Id </th>
		<th>Id_formapago</th>
		<th>Total</th>
		<th>Fecha</th>
		<th>Id_servicios</th>
		<th>Id_contrato</th>
		<th>importe_facturado</th>
	</tr>
	
<%for (Pedido elemento: jsptodos){ %>

<tr>
<td><%=elemento.getIdpedido() %></td>
<td><%=elemento.getDescripcion() %></td>
<td><%=elemento.getId() %></td>
<td><%=elemento.getIdformapago() %></td>
<td><%=elemento.getTotal() %></td>
<td><%=elemento.getFecha() %></td>
<td><%=elemento.getIdservicios() %></td>
<td><%=elemento.getIdcontrato() %></td>
<td><%=elemento.getImporte_facturado() %></td>

</tr><
<%} %>

</table>

</body>
</html>