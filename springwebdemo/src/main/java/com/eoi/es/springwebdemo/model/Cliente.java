package com.eoi.es.springwebdemo.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {
	
	private String dni;
	
	private String nombre;
	
	private String direccion;
	
	private List<Banco> bancos;
	
}
	
