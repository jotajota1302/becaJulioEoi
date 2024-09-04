package com.eoi.es;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "BOOKS")
public interface BookClient {

	@GetMapping("books/{id}")
	public BookDto getBookById(@PathVariable("id") Integer id);
	
	@GetMapping("/{id}/withAuthor")
	public ResponseEntity<BookWithAuthorDto> findByIdWithAuthorDto(@PathVariable Integer id);
	
	@GetMapping("/author/{id}")
	public ResponseEntity<List<BookDto>> findBooksByAuthor(@PathVariable Integer id);


}