<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="cp1" class="com.vipper.modelo.ClienteProveedor" scope="request"/>
<h1>Datos del producto</h1>
<ul>
<li>Id: <%=cp1.getId() %></li>
<br>
<li>NIF: <%=cp1.getNif() %></li>
<br>
<li>Nombre: <%=cp1.getNombre() %></li>
<br>
<li>Dirección: <%=cp1.getDireccion() %></li>
<br>
<li>Tipo: <%=cp1.getTipo() %></li>
<br>
<li>Email: <%=cp1.getEmail() %></li>
<br>
<li>Teléfono: <%=cp1.getTelefono() %></li>
</ul>
</body>
</html>