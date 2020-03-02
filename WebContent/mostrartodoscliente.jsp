<%@page import="com.vipper.modelo.ClienteProveedor"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="estilos/estilos.css" type="text/css">
<title>Insert title here</title>
</head>
<body>
<p> Nuestros clientes / proveedores son:</p>
<!--  usar un scriplet para recoger los productos que están en el ámbito request -->
<% ArrayList<ClienteProveedor> jsptodos = (ArrayList<ClienteProveedor>) request.getAttribute("rtodos");%>
<table>
	<tr>
		<th>Id </th>
		<th>NIF</th>
		<th>Nombre</th>
		<th>Dirección</th>
		<th>Tipo</th>
		<th>Email</th>
		<th>Teléfono</th>
	</tr>

<%for(ClienteProveedor elemento: jsptodos){%>
<tr>
<td><%=elemento.getId() %></td>
<td><%=elemento.getNif() %></td>
<td><%=elemento.getNombre() %></td>
<td><%=elemento.getDireccion() %></td>
<td><%=elemento.getTipo() %></td>
<td><%=elemento.getEmail() %></td>
<td><%=elemento.getTelefono() %></td>

<!-- En esta columna se va a mostrar una imagen y un enlace que contenga el id del producto -->
<td>

</td>
</tr>

<%} %>


</body>
</html>