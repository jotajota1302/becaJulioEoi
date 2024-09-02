package com.eoi.es.springwebdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cuenta")
@Getter
@Setter
public class Cuenta {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private Double saldo;
	
	@ManyToOne
	@JoinColumn(name = "dni", referencedColumnName = "dni")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "idBanco", referencedColumnName = "id")
	private Banco banco;

	
	
}
