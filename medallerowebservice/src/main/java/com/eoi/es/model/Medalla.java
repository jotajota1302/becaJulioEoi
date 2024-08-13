package com.eoi.es.model;

public class Medalla {
	
	private String tipo;
	
	private Pais pais;
	
	private int cantidad;
	
	

	@Override
	public String toString() {
		return "Medalla [tipo=" + tipo + ", pais=" + pais + ", cantidad=" + cantidad + "]";
	}

	public Medalla(String tipo, Pais pais, int cantidad) {
		super();
		this.tipo = tipo;
		this.pais = pais;
		this.cantidad = cantidad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	

}
