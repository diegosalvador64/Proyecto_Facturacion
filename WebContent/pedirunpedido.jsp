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
3. Que tenga un constructor vacio -->
<h1>Busque el Pedido que desea</h1>
<% if (request.getParameter("idpedido")!=null) {%>
<jsp:useBean id ="p1" scope="request" class="com.vipper.modelo.Pedidos"/>
<jsp:setProperty name="p1" property="*"/>
<jsp:forward page="servletpedido?op=1"/>
<%} %>
<form action="pedirunpedido.jsp" method ="post">
<h3>Pedido:</h3><br><input type="number" name="idpedido"/><!-- este idpedido es el que se recoge en el servlet -->
<br>
<br>
<input type="submit" value="Buscar Pedido"/>
</form>
</body>
</html>