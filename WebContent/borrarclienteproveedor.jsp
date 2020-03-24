<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Borrar cliente/proveedor</title>
<link rel="stylesheet" href="estilos/estilos.css" type="text/css">
</head>
<body>
<!--  usando beans 
1. Clase encapsulada
2. Que implemente la interfaz Serializable
3. Que tenga un constructor vacio -->
<h1>Borrar un cliente / proveedor</h1>

<% if (request.getParameter("id")!=null) {%>
<jsp:useBean id ="cp1" scope="request" class="com.vipper.modelo.ClienteProveedor"/>
<jsp:setProperty name="cp1" property="*"/>
<jsp:forward page="servletfacturacion?op=5"/>
<%} %>
<form action="borrarclienteproveedor.jsp" method ="post">
<h3>Cliente/Proveedor:</h3>
<br>
<input type="number" name="id" min="1"/><br><br>
<input type="submit" value="Borrar Cliente/Proveedor"/>
</form>
<br>	
	<a href="clienteproveedor.jsp">Men� Cliente-Proveedor</a>
	<br>
	<a href="menuprincipal.jsp">Men� principal</a>
</body>
</html>