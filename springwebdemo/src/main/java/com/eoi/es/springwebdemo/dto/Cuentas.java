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
public class Cuentas {

	private ClienteDto cliente;
	
	private double saldo;
	
	private Banco banco;
	
}
