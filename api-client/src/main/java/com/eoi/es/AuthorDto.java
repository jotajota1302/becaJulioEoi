package com.eoi.es;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorDto {
	
		private Integer id;
		
		private String name;
		
		private String surname;		

		private List<BookDto> books;
}
