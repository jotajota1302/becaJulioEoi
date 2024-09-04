package com.eoi.es;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyApiController {

	@Autowired
	private AuthorClient authorClient;
	
	@Autowired
	private BookClient bookClient;

	@GetMapping("/author/{id}")
	public AuthorDto getAuthor(@PathVariable("id") Integer id) {
		return authorClient.getAuthorById(id);
	}

	@GetMapping("/book/{id}")
	public BookWithAuthorDto getBook(@PathVariable("id") Integer id) {
		return bookClient.findByIdWithAuthorDto(id);
	}

}
