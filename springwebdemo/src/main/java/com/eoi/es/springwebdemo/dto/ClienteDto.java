package com.eoi.es.springwebdemo.dto;

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
public class ClienteDto {
	
	private String dni;
	
	private String nombre;
	
	private String direccion;
	
	private double saldo;
	
	
}
	
