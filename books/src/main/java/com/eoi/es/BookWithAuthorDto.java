package com.eoi.es;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookWithAuthorDto {

	private Integer id;

	private String title;

	private AuthorDto author;

}
