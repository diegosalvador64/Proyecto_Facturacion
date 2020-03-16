<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="estilos/estilos.css" type="text/css">
<title>Mostrar un cliente</title>
</head>
<body>
<!--  usando beans 
1. Clase encapsulada
2. Que implemente la interfaz Serializable
3. Que tenga un constructor vacio Hola Hola holita-->
<h1>Busque el cliente/proveedor que desea</h1>

<% if (request.getParameter("id")!=null) {%>
<jsp:useBean id ="cp1" scope="request" class="com.vipper.modelo.ClienteProveedor"/>
<jsp:setProperty name="cp1" property="*"/>
<jsp:forward page="servletfacturacion?op=1"/>
<%} %>
<form action="mostrarunocliente.jsp" method ="post">
<h3>Cliente/Proveedor:</h3><input type="number" name="id"/>
<br>
<br>
<input type="submit" value="Buscar Cliente/Proveedor"/>
</form>
</body>
</html>