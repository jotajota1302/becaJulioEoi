package com.eoi.es;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/books")
@RestController()
public class BooksController {
	
	@Autowired
	private BooksService booksService;
	
	@GetMapping
	public ResponseEntity<List<BookDto>> findAll(){		
			
		return new ResponseEntity<List<BookDto>>(booksService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BookDto> findByIdAll(@PathVariable Integer id){		
			
		return new ResponseEntity<BookDto>(booksService.findById(id),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> create(@RequestBody BookDto dto){		
			
		booksService.create(dto);
		
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
}