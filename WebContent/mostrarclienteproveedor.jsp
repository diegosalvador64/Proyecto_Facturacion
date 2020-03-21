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
<h2 class="mostraruno"><%= request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : "" %></h2>
<br>
<ul class="mostraruno">
<li><b>Id       :</b> <%=cp1.getId() %></li>
<br>
<li><b>NIF      :</b> <%=cp1.getNif() != null ? cp1.getNif() : "" %></li>
<br>
<li><b>Nombre   :</b> <%=cp1.getNombre() != null ? cp1.getNombre() : "" %></li>
<br>
<li><b>Dirección:</b> <%=cp1.getDireccion() != null ? cp1.getDireccion() : "" %></li>
<br>
<li><b>Tipo     :</b> <%=cp1.getTipo() != null ? cp1.getTipo() : "" %></li>
<br>
<li><b>Email    :</b> <%=cp1.getEmail() != null ? cp1.getEmail() : "" %></li>
<br>
<li><b>Teléfono :</b> <%=cp1.getTelefono() != null ? cp1.getTelefono() : "" %></li>
</ul>
<br>
<a href="clienteproveedor.jsp">Menú Cliente-Proveedor</a>
<br>
<a href="menuprincipal.jsp">Menú principal</a>
</body>
</html>