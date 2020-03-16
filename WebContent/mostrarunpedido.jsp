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

<ul>
<li>Id Pedido            : <%=p1.getIdpedido() %></li>
<br>
<li>Descripción pedido  : <%=p1.getDescripcion() %></li>
<br>
<li>NIF Cliente/Proveedor: <%=p1.getNifClienteProveedor() %></li>
<br>
<li>Forma de pago        : <%=p1.getDescripcionFormaPago() %></li>
<br>
<li>Total                : <%=p1.getTotal() %></li>
<br>
<li>Fecha                : <%=p1.getFecha() %></li>
<br>
<li>Servicio             : <%=p1.getDescripcionServicios() %></li>
<br>
<li>Id Contrato          : <%=p1.getIdcontrato() %></li>
<br>
<li>Importe facturado    : <%=p1.getImporte_facturado() %></li>
<br>
</ul>
</body>
</html>