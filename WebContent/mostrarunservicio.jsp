<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mostrar un servicio</title>
<link rel="stylesheet" href="estilos/estilos.css" type="text/css">
</head>
<body>

<jsp:useBean id="s1" class="com.vipper.modelo.Servicio" scope="request"/>
<h1>Datos del servicio</h1>
<h2 class="mostraruno"><%= request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : "" %></h2>
<br>
<ul class="mostraruno">
<li><strong>Id Servicio: </strong><%=s1.getIdservicios() %></li>
<br>
<li><strong>Descripción: </strong><%=s1.getDescripcion() != null ? s1.getDescripcion() : "" %></li>
<br>
<li><strong>Coste      : </strong><%=s1.getCoste() %></li>
<br>
<li><strong>Id Cliente : </strong><%=s1.getId() %></li>
<br>
<li><strong>IVA        : </strong><%=s1.getIva() %></li>
<br>
</ul>
</body>
</html>