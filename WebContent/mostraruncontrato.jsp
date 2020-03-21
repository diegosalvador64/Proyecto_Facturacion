<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mostrar un contrato</title>
<link rel="stylesheet" href="estilos/estilos.css" type="text/css">
</head>
<body>
<jsp:useBean id="c1" class="com.vipper.modelo.Contratos" scope="request"/>
<h1>Datos del contrato</h1>
<h2 class="mostraruno"><%= request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : "" %></h2>
<br>
<ul class="mostraruno">
<li><strong>Id Contrato          :</strong> <%=c1.getIdcontrato() %></li>
<br>
<li><strong>Id Cliente/Proveedor :</strong> <%=c1.getId() %></li>
<br>
<li><strong>Comisión             :</strong> <%=c1.getComision() %></li>
<br>
<li><strong>Encargado facturación:</strong> <%=c1.getEncargadofacturacion() != null ? c1.getEncargadofacturacion() : "" %></li>
<br>
</ul>
<br>
	<a href="contratos.jsp">Menú Contratos</a>
	<br>
	<a href="menuprincipal.jsp">Menú principal</a>
</body>
</html>