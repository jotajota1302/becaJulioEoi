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

@RequestMapping("/authors")
@RestController()
public class AuthorsController {
	
	@Autowired
	private AuthorsService authorsService;
	
	@GetMapping
	public ResponseEntity<List<AuthorDto>> findAll(){		
			
		return new ResponseEntity<List<AuthorDto>>(authorsService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AuthorDto> findById(@PathVariable Integer id){		
			
		return new ResponseEntity<AuthorDto>(authorsService.findById(id),HttpStatus.OK);
	}
	
	@GetMapping("/{id}/books")
	public ResponseEntity<AuthorDto> findByIdwithBooks(@PathVariable Integer id){		
			
		return new ResponseEntity<AuthorDto>(authorsService.findByIdWithBooks(id),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> create(@RequestBody AuthorDto dto){		
			
		authorsService.create(dto);
		
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
}
