package com.vipper.modelo;

public class Servicio {
	//Atributos
	int idservicios; 
	String descripcion; 
	double coste; 
	int id; 
	double iva;
		
	//Constructores
	public Servicio() {
		
	}

	public Servicio(int idservicios, String descripcion, double coste, int id, double iva) {
		super();
		this.idservicios = idservicios;
		this.descripcion = descripcion;
		this.coste = coste;
		this.id = id;
		this.iva = iva;
	}
	
	
	public Servicio(String descripcion, double coste, int id, double iva) {
		super();
		this.descripcion = descripcion;
		this.coste = coste;
		this.id = id;
		this.iva = iva;
	}

	//ToString

	public String valueOf() {
		return "Servicio [idservicios=" + idservicios + ", descripcion=" + descripcion + ", coste=" + coste + ", id="
				+ id + ", iva=" + iva + "]\n";
	}
	//Getters & Setters

	public int getIdservicios() {
		return idservicios;
	}

	public void setIdservicios(int idservicios) {
		this.idservicios = idservicios;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getCoste() {
		return coste;
	}

	public void setCoste(double coste) {
		this.coste = coste;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}
	
}
