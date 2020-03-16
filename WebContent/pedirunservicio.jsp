<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pedir un servicio</title>
<link rel="stylesheet" href="estilos/estilos.css" type="text/css">
</head>
<body>
<!--  usando beans 
1. Clase encapsulada
2. Que implemente la interfaz Serializable
3. Que tenga un constructor vacio Hola Hola holita-->
<h1>Busque el servicio que desea</h1>
<% if (request.getParameter("idservicios")!=null) {%>
<jsp:useBean id ="s1" scope="request" class="com.vipper.modelo.Servicio"/>
<jsp:setProperty name="s1" property="*"/>
<jsp:forward page="servletservicio?op=1"/>
<%} %>
<form action="pedirunservicio.jsp" method ="post">
<h3>Servicio:</h3><br><input type="number" name="idservicios"/>
<br>
<br>
<input type="submit" value="Buscar Servicio"/>
</form>
</body>
</html>