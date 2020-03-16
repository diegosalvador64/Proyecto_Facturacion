<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pedir un contrato</title>
<link rel="stylesheet" href="estilos/estilos.css" type="text/css">
</head>
<body>
<!--  usando beans 
1. Clase encapsulada
2. Que implemente la interfaz Serializable
3. Que tenga un constructor vacio Hola Hola holita-->
<h1>Busque el Contrato que desea</h1>
<% if (request.getParameter("idcontrato")!=null) {%>
<jsp:useBean id ="c1" scope="request" class="com.vipper.modelo.Contratos"/>
<jsp:setProperty name="c1" property="*"/>
<jsp:forward page="servletcontrato?op=1"/>
<%} %>
<form action="pediruncontrato.jsp" method ="post">
<h3>Contrato:</h3><br><input type="number" name="idcontrato"/>
<br>
<br>
<input type="submit" value="Buscar Contrato"/>
</form>
</body>
</html>