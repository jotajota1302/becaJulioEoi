package com.eoi.es.springwebdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clientes")
@Getter
@Setter
public class Cliente {

	@Id
	private String dni;
	
	@Column
	private String nombre;
	
	@Column
	private String direccion;
	
}
