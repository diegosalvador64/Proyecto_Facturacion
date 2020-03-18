<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mostrar un pedido</title>
<link rel="stylesheet" href="estilos/estilos.css" type="text/css">
</head>
<body>
<jsp:useBean id="p1" class="com.vipper.modelo.Pedidos" scope="request"/>
<h1>Datos del Pedido</h1>
<h2 class="mostraruno"><%= request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : "" %></h2>
<br>
<ul class="mostraruno">
<li><strong>Id Pedido            :</strong> <%=p1.getIdpedido() %></li>
<br>
<li><strong>Descripción pedido  :</strong> <%=p1.getDescripcion() != null ? p1.getDescripcion() : "" %></li>
<br>
<li><strong>NIF Cliente/Proveedor:</strong> <%=p1.getNifClienteProveedor() != null ? p1.getNifClienteProveedor() : "" %></li>
<br>
<li><strong>Forma de pago        :</strong> <%=p1.getDescripcionFormaPago() != null ? p1.getDescripcionFormaPago() : "" %></li>
<br>
<li><strong>Total                :</strong> <%=p1.getTotal() %></li>
<br>
<li><strong>Fecha                :</strong> <%=p1.getFecha() != null ? p1.getFecha() : "" %></li>
<br>
<li><strong>Servicio             :</strong> <%=p1.getDescripcionServicios() != null ? p1.getDescripcionServicios() : "" %></li>
<br>
<li><strong>Id Contrato          :</strong> <%=p1.getIdcontrato() %></li>
<br>
<li><strong>Importe facturado    :</strong> <%=p1.getImporte_facturado() %></li>
<br>
</ul>
</body>
</html>