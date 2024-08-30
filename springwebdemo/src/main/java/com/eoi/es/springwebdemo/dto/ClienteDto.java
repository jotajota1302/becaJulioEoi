package com.eoi.es.springwebdemo.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	
	@JsonProperty(value = "nif")
	@NotNull
	private String dni;
	
	@JsonProperty(value = "name")
	@NotNull
	private String nombre;
	
	@JsonProperty(value = "address")
	private String direccion;
	
	@JsonProperty(value = "budget")
	private double saldo;
	
	
	
}
	
