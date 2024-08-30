package com.eoi.es.springwebdemo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@ToString
public class Cliente {
	
	@Id
	@Column(length = 9,unique = true)
	private String dni;
	
	@Column
	private String nombre;
	
	@Column
	private String direccion;

	@OneToMany(mappedBy = "cliente")
	private List<Cuenta> cuentas;
	
	
}
