package com.eoi.es.springwebdemo.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.eoi.es.springwebdemo.model.Book;

@RestController
@RequestMapping("/books")
public class BookController {

	private List<Book> books = new ArrayList<>();

	{
		books.add(new Book(1, "Cien años de soledad", "Gabriel García Márquez", "Ficción"));
		books.add(new Book(2, "1984", "George Orwell", "Distopía"));
		books.add(new Book(3, "El señor de los anillos", "J.R.R. Tolkien", "Fantasía"));
		books.add(new Book(4, "Don Quijote de la Mancha", "Miguel de Cervantes", "Clásico"));
		books.add(new Book(5, "Harry Potter y la piedra filosofal", "J.K. Rowling", "Fantasía"));
	}

	@GetMapping
	public ResponseEntity<List<Book>> findAll() {

		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Book> findById(@PathVariable String id) {

		for (Book book : books) {
			if (book.getId() == Integer.valueOf(id)) {
				return new ResponseEntity<Book>(book, HttpStatus.OK);
			}
		}

		return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);

	}

	@PostMapping
	public ResponseEntity<String> create(@RequestBody Book book) {

		if (!books.contains(book)) {
			books.add(book);

			return new ResponseEntity<String>(HttpStatus.CREATED);
		}
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<String> update(@RequestBody Book book, @PathVariable int id) {

		if (id == book.getId()) {
			for (Book tmp : books) {
				if (tmp.getId() == Integer.valueOf(id)) {
					tmp.setAuthor(book.getAuthor());
					tmp.setCategory(book.getCategory());
					tmp.setTitle(book.getTitle());
				}

				return new ResponseEntity<String>(HttpStatus.ACCEPTED);
			}
		}

		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteById(@PathVariable String id) {

		for (Book book : books) {
			if (book.getId() == Integer.valueOf(id)) {
				books.remove(book);
				
				return new ResponseEntity<String>(HttpStatus.ACCEPTED);
			}
		}
		
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST); 
	}

	@DeleteMapping
	public ResponseEntity<String> deleteAll() {

		books.removeAll(books);

		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
		
	}

}
