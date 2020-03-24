<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pedir una forma de pago</title>
<link rel="stylesheet" href="estilos/estilos.css" type="text/css">
</head>
<body>
<!--  usando beans 
1. Clase encapsulada
2. Que implemente la interfaz Serializable
3. Que tenga un constructor vacio -->
<h1>Busque la forma de pago que desea</h1>
<% if (request.getParameter("idformapago")!=null) {%>
<jsp:useBean id ="fp1" scope="request" class="com.vipper.modelo.FormasPago"/>
<jsp:setProperty name="fp1" property="*"/>
<jsp:forward page="servletformaspago?op=1"/>
<%} %>
<form action="pedirunaformapago.jsp" method ="post">
<h3>Formas de pago:</h3><br><input type="number" name="idformapago" min="1"/>
<br>
<br>
<input type="submit" value="Buscar Forma de Pago"/>
</form>
<br>
	<a href="formaspago.jsp">Menú Formas de Pago</a>
	<br>
	<a href="menuprincipal.jsp">Menú principal</a>	
</body>
</html>