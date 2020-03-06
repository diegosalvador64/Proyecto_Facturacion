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
<ul>
<li>Id Contrato          : <%=c1.getIdcontrato() %></li>
<br>
<li>Id Cliente/Proveedor : <%=c1.getId() %></li>
<br>
<li>Comisión             : <%=c1.getComision() %></li>
<br>
<li>Encargado facturación: <%=c1.getEncargadofacturacion() %></li>
<br>
</ul>
</body>
</html>