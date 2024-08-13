package com.eoi.es.model;

public class InformacionPais {
	
	private int oro;
	
	private int plata;
	
	private int bronce;

	public int getOro() {
		return oro;
	}

	public void setOro(int oro) {
		this.oro = oro;
	}

	public int getPlata() {
		return plata;
	}

	public void setPlata(int plata) {
		this.plata = plata;
	}

	public int getBronce() {
		return bronce;
	}

	public void setBronce(int bronce) {
		this.bronce = bronce;
	}

	public InformacionPais(int oro, int plata, int bronce) {
		super();
		this.oro = oro;
		this.plata = plata;
		this.bronce = bronce;
	}

	@Override
	public String toString() {
		return "oro=" + oro + ", plata=" + plata + ", bronce=" + bronce;
	}
	
	
	

}
