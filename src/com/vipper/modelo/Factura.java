package com.vipper.modelo;

import java.sql.Date;

public class Factura {
	//Atributos
	int idfactura; 
	int id; 
	int idpedido; 
	Date fecha; 
	int idservicios;
	double importe;
	int idformapago; 
	int idcontrato; 
	String concepto; 
	double iva;
	
	//To String. NO contiene las descripciones de las tablas en las que he hecho join
	public String valueof() {
		return "Factura [idfactura=" + idfactura + ", id=" + id + ", idpedido=" + idpedido + ", fecha=" + fecha
				+ ", idservicios=" + idservicios + ", importe=" + importe + ", idformapago=" + idformapago
				+ ", idcontrato=" + idcontrato + ", concepto=" + concepto + ", iva=" + iva + "]";
	}
	
	//Constructores
	public Factura() {
		super();
	}

	public Factura(int idfactura, int id, int idpedido, Date fecha, int idservicios, double importe, int idformapago,
			int idcontrato, String concepto, double iva) {
		super();
		this.idfactura = idfactura;
		this.id = id;
		this.idpedido = idpedido;
		this.fecha = fecha;
		this.idservicios = idservicios;
		this.importe = importe;
		this.idformapago = idformapago;
		this.idcontrato = idcontrato;
		this.concepto = concepto;
		this.iva = iva;
	}

	public Factura(int id, int idpedido, int idservicios, double importe, int idformapago, int idcontrato) {
		super();
		this.id = id;
		this.idpedido = idpedido;
		this.idservicios = idservicios;
		this.importe = importe;
		this.idformapago = idformapago;
		this.idcontrato = idcontrato;
	}

	//Getters & Setters
	
	
	public int getIdfactura() {
		return idfactura;
	}

	public void setIdfactura(int idfactura) {
		this.idfactura = idfactura;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
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

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public int getIdformapago() {
		return idformapago;
	}

	public void setIdformapago(int idformapago) {
		this.idformapago = idformapago;
	}

	public int getIdcontrato() {
		return idcontrato;
	}

	public void setIdcontrato(int idcontrato) {
		this.idcontrato = idcontrato;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}
	
	
	
}
