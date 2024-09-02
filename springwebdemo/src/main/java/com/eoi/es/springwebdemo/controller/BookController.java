package com.eoi.es.springwebdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eoi.es.springwebdemo.dto.BookDto;
import com.eoi.es.springwebdemo.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping
	public ResponseEntity<List<BookDto>> findAll(@RequestParam @Nullable int page,@RequestParam @Nullable int size) {

		Pageable pageable = PageRequest.of(page,size);
		
		return new ResponseEntity<List<BookDto>>(bookService.findAll(pageable), HttpStatus.OK);
	}

//	@GetMapping(value = "/{id}")
//	public ResponseEntity<Book> findById(@PathVariable Integer id) {
//
//		Optional<Book> resultado = repository.findById(id);
//
//		if (resultado.isPresent()) {
//			return new ResponseEntity<Book>(resultado.get(), HttpStatus.OK);
//		}
//
//		return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
//
//	}
//
//	@PostMapping
//	public ResponseEntity<String> create(@RequestBody Book book) {
//
//		repository.save(book);
//
//		return new ResponseEntity<String>(HttpStatus.CREATED);
//
//	}
//
//	@PutMapping(value = "/{id}")
//	public ResponseEntity<String> update(@RequestBody Book book, @PathVariable int id) {
//
//		if (id == book.getId()) {
//
//			repository.save(book);
//
//			return new ResponseEntity<String>(HttpStatus.ACCEPTED);
//
//		}
//
//		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
//	}
//
//	@DeleteMapping(value = "/{id}")
//	public ResponseEntity<String> deleteById(@PathVariable Integer id) {
//
//		repository.deleteById(id);
//
//		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
//	}
//
//	@DeleteMapping
//	public ResponseEntity<String> deleteAll() {
//
//		repository.deleteAll();
//
//		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
//
//	}

}
