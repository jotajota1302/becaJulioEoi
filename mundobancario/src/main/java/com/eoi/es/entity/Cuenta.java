package com.eoi.es.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cuenta")
public class Cuenta {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private Double saldo;
	
	@ManyToOne
	@JoinColumn(name = "dni", referencedColumnName = "dni")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "idBanco", referencedColumnName = "id")
	private Banco banco;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Cuenta [saldo=" + saldo + "]";
	}
	
	
}
