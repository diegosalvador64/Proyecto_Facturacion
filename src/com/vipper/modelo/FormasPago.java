package com.vipper.modelo;

public class FormasPago {
	//Atributos
	
	int idformapago;
	String descripcion;
	double valor;
	
	
	//ToString: valueof() es el método de toString con campos null
	
	//Constructores
	public FormasPago() {
		super();
	}

	public FormasPago(int idformapago, String descripcion, double valor) {
		super();
		this.idformapago = idformapago;
		this.descripcion = descripcion;
		this.valor = valor;
	}
	
	public FormasPago(String descripcion, double valor) {
		super();
		this.descripcion = descripcion;
		this.valor = valor;
	}
	//Método toString
	public String valueof() {
		return "FormasPago [idformapago=" + idformapago + ", descripcion=" + descripcion + ", valor=" + valor + "]";
	}

	//Getters & Setters
	public int getIdformapago() {
		return idformapago;
	}
	public void setIdformapago(int idformapago) {
		this.idformapago = idformapago;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

	

	
	
	
}
