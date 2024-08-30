package com.eoi.es.springwebdemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eoi.es.springwebdemo.entity.Book;
import com.eoi.es.springwebdemo.repository.BookRepository;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookRepository repository;

	@GetMapping
	public ResponseEntity<List<Book>> findAll() {

		return new ResponseEntity<List<Book>>(repository.findAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Book> findById(@PathVariable Integer id) {

		Optional<Book> resultado = repository.findById(id);

		if (resultado.isPresent()) {
			return new ResponseEntity<Book>(resultado.get(), HttpStatus.OK);
		}

		return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);

	}

	@PostMapping
	public ResponseEntity<String> create(@RequestBody Book book) {

		repository.save(book);

		return new ResponseEntity<String>(HttpStatus.CREATED);

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<String> update(@RequestBody Book book, @PathVariable int id) {

		if (id == book.getId()) {

			repository.save(book);

			return new ResponseEntity<String>(HttpStatus.ACCEPTED);

		}

		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id) {

		repository.deleteById(id);

		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}

	@DeleteMapping
	public ResponseEntity<String> deleteAll() {

		repository.deleteAll();

		return new ResponseEntity<String>(HttpStatus.ACCEPTED);

	}

}
