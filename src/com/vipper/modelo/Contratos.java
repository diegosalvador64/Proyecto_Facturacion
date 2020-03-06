package com.vipper.modelo;

public class Contratos {
	//Atributos
	int idcontrato;
	int id;
	double comision;
	String encargadofacturacion;
	//ToString
	public String valueOf() {
		return "Contratos [idcontrato=" + idcontrato + ", id=" + id + ", comision=" + comision
				+ ", encargadofacturacion=" + encargadofacturacion + "]\n";
	}
	//Constructores
	public Contratos() {
		
	}
	public Contratos(int idcontrato, int id, double comision, String encargadofacturacion) {
		this.idcontrato = idcontrato;
		this.id = id;
		this.comision = comision;
		this.encargadofacturacion = encargadofacturacion;
	}
	
	public Contratos(int id, double comision, String encargadofacturacion) {
		this.id = id;
		this.comision = comision;
		this.encargadofacturacion = encargadofacturacion;
	}
	//Getters & Setters
	public int getIdcontrato() {
		return idcontrato;
	}
	public void setIdcontrato(int idcontrato) {
		this.idcontrato = idcontrato;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getComision() {
		return comision;
	}
	public void setComision(double comision) {
		this.comision = comision;
	}
	public String getEncargadofacturacion() {
		return encargadofacturacion;
	}
	public void setEncargadofacturacion(String encargadofacturacion) {
		this.encargadofacturacion = encargadofacturacion;
	}
	
	
}
