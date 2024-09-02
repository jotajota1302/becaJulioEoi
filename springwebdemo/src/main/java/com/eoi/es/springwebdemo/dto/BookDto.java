package com.eoi.es.springwebdemo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class BookDto {
	
	@JsonIgnore
	private int id;	

	private String title;	
	
	private String author;	
	
	private String category;
	
	
	
}
