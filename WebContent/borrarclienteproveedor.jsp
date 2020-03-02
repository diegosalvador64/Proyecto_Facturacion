<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!--  usando beans 
1. Clase encapsulada
2. Que implemente la interfaz Serializable
3. Que tenga un constructor vacio -->

<% if (request.getParameter("id")!=null) {%>
<jsp:useBean id ="cp1" scope="request" class="com.vipper.modelo.ClienteProveedor"/>
<jsp:setProperty name="cp1" property="*"/>
<jsp:forward page="servletfacturacion?op=5"/>
<%} %>
<form action="borrarclienteproveedor.jsp" method ="post">
idusuario:<input type="text" name="id"/><br><br>
<input type="submit" value="Borrar Cliente/Proveedor"/>
</form>
</body>
</html>