package com.eoi.es.springwebdemo.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
public class PersonDto {

	@NotNull
	private String name;
	
	@NotNull
	private String surname;

	@NotNull
	private String dni;	

	private String mail;
	
	@NotNull
	@Size(min = 8)
	private String password;
	
}
