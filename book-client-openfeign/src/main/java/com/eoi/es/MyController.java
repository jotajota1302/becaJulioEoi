package com.eoi.es;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class MyController {

	@Autowired
	private BookClient client;
	
	@GetMapping("{id}")
	public ResponseEntity<BookDto> getMethodName(@PathVariable Integer id) {
	
		return new ResponseEntity<BookDto>(client.getBookById(id),HttpStatus.OK);
	}
	
}
