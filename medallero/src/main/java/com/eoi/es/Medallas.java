package com.eoi.es;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medallas")
public class Medallas {
		
	@Id
	private String pais;
	
	@Column
	private int oro;
	
	@Column
	private int plata;
	
	@Column
	private int bronce;

	
	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

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

	@Override
	public String toString() {
		return "[pais=" + pais + ", oro=" + oro + ", plata=" + plata + ", bronce=" + bronce + "]";
	}

	public Medallas(String pais, int oro, int plata, int bronce) {
		super();
		this.pais = pais;
		this.oro = oro;
		this.plata = plata;
		this.bronce = bronce;
	}

	public Medallas() {
		super();
	}
	

}
