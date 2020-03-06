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
<ul>
<li>Id Servicio: <%=s1.getIdservicios() %></li>
<br>
<li>Descripción: <%=s1.getDescripcion() %></li>
<br>
<li>Coste      : <%=s1.getCoste() %></li>
<br>
<li>Id Cliente : <%=s1.getId() %></li>
<br>
<li>IVA        : <%=s1.getIva() %></li>
<br>
</ul>
</body>
</html>