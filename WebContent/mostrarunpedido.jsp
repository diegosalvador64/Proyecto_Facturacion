<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% if (request.getParameter("idpedido")!=null) {%>
<jsp:useBean id ="p1" scope="request" class="com.vipper.modelo.Pedido"/>
<jsp:setProperty name="p1" property="*"/>
<jsp:forward page="servletpedido?op=2"/>
<%} %>
<form action="mostrarunpedido.jsp" method ="post">
Pedido:<input type="text" name="idpedido"/>
<input type="submit" value="Buscar Pedido"/>
</form>

</body>
</html>