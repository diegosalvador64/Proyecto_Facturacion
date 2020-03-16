package com.vipper.modelo;


import java.sql.Date;
import java.time.LocalDate;

public class Pedidos {
	//Atributos para la inserción
	
	int idpedido; 
	String descripcion; 
	int id; //id de Cliente/proveedor 
	int idformapago;
	double total; 
	Date fecha; 
	int idservicios;
	int idcontrato; 
	double importe_facturado;
	
	//Atributos de descripción para mostrar todos o uno
	String nifClienteProveedor; //NIF Cliente/Proveedor
	String descripcionFormaPago; //Descripción Forma de pago
	String descripcionServicios; //Descripción Servicios
	
	//Constructores
	public Pedidos() {
		super();
	}
	
	//Constructor para la inserción de un registro
	public Pedidos(String descripcion, int id, int idformapago, double total, Date fecha, int idservicios,
			int idcontrato, double importe_facturado) {
		super();
		this.descripcion = descripcion;
		this.id = id;
		this.idformapago = idformapago;
		this.total = total;
		this.fecha = fecha;
		this.idservicios = idservicios;
		this.idcontrato = idcontrato;
		this.importe_facturado = importe_facturado;
	}
	//Constrcutor completo. Muestra también las descripciones
	public Pedidos(int idpedido, String descripcion, int id, int idformapago, double total, Date fecha, int idservicios,
			int idcontrato, double importe_facturado, String nifClienteProveedor, String descripcionFormaPago,
			String descripcionServicios) {
		super();
		this.idpedido = idpedido;
		this.descripcion = descripcion;
		this.id = id;
		this.idformapago = idformapago;
		this.total = total;
		this.fecha = fecha;
		this.idservicios = idservicios;
		this.idcontrato = idcontrato;
		this.importe_facturado = importe_facturado;
		this.nifClienteProveedor = nifClienteProveedor;
		this.descripcionFormaPago = descripcionFormaPago;
		this.descripcionServicios = descripcionServicios;
	}
	//To String. NO contiene las descripciones de las tablas en las que he hecho join
	public String valueof() {
		return "Pedidos [idpedido=" + idpedido + ", descripcion=" + descripcion + ", id=" + id + ", idformapago="
				+ idformapago + ", total=" + total + ", fecha=" + fecha + ", idservicios=" + idservicios
				+ ", idcontrato=" + idcontrato + ", importe_facturado=" + importe_facturado + "]";
	}

	//Getters & setters
	public int getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdformapago() {
		return idformapago;
	}

	public void setIdformapago(int idformapago) {
		this.idformapago = idformapago;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getIdservicios() {
		return idservicios;
	}

	public void setIdservicios(int idservicios) {
		this.idservicios = idservicios;
	}

	public int getIdcontrato() {
		return idcontrato;
	}

	public void setIdcontrato(int idcontrato) {
		this.idcontrato = idcontrato;
	}

	public double getImporte_facturado() {
		return importe_facturado;
	}

	public void setImporte_facturado(double importe_facturado) {
		this.importe_facturado = importe_facturado;
	}

	public String getNifClienteProveedor() {
		return nifClienteProveedor;
	}

	public void setNifClienteProveedor(String nifClienteProveedor) {
		this.nifClienteProveedor = nifClienteProveedor;
	}

	public String getDescripcionFormaPago() {
		return descripcionFormaPago;
	}

	public void setDescripcionFormaPago(String descripcionFormaPago) {
		this.descripcionFormaPago = descripcionFormaPago;
	}

	public String getDescripcionServicios() {
		return descripcionServicios;
	}

	public void setDescripcionServicios(String descripcionServicios) {
		this.descripcionServicios = descripcionServicios;
	}
	
	
	
	
	
	
	
}
