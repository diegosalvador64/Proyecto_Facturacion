package com.vipper.modelo;

import java.sql.Date;
import java.time.LocalDate;

public class Pedido {
	//Atributos
	private int idpedido;
	private String descripcion;
    private int id;
	private int idformapago;
	private double total;
	private Date fecha;
	private int idservicios;
	private int idcontrato;
	private double importe_facturado;
	
	
	
	//ToString
	
	public String valueOf() {
		return "Pedido [idpedido=" + idpedido + ", descripcion=" + descripcion + ", id=" + id + ", idformapago="
				+ idformapago + ", total=" + total + ", fecha=" + fecha + ", idservicios=" + idservicios
				+ ", idcontrato=" + idcontrato + ", importe_facturado=" + importe_facturado + "]";
	}

	//Constructores
	
	public Pedido(int idpedido, String descripcion, int id, int idformapago, double total, Date fecha, int idservicios,
			int idcontrato, double importe_facturado) {
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
	}
	public Pedido() {
		super();
	}
	
	//Getters y Setters

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
	
}
	