package com.eoi.es.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	private String dni;
	
	@Column
	private String nombre;
	
	@Column
	private String direccion;

	
	
	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



}
