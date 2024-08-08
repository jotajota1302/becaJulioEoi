package com.eoi.es;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "direccion")
public class Direccion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int id;
	
	@Column
	private String direccion;
	
	@ManyToMany(mappedBy = "direcciones")
	private List<Usuario> usuarios;
	
	
}
