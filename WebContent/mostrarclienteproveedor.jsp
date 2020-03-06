<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mostrar cliente/proveedor</title>
 <link rel="stylesheet" href="estilos/estilos.css" type="text/css"> 
</head>
<body>
<jsp:useBean id="cp1" class="com.vipper.modelo.ClienteProveedor" scope="request"/>
<h1>Datos del Cliente/proveedor</h1>
<ul>
<li>Id       : <%=cp1.getId() %></li>
<br>
<li>NIF      : <%=cp1.getNif() %></li>
<br>
<li>Nombre   : <%=cp1.getNombre() %></li>
<br>
<li>Direcci�n: <%=cp1.getDireccion() %></li>
<br>
<li>Tipo     : <%=cp1.getTipo() %></li>
<br>
<li>Email    : <%=cp1.getEmail() %></li>
<br>
<li>Tel�fono : <%=cp1.getTelefono() %></li>
</ul>
</body>
</html>