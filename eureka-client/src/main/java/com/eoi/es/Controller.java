package com.eoi.es;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Controller {

	@GetMapping
	public ResponseEntity<String> sayHello() {
		
		return ResponseEntity.ok("Hola desde mi servicio");
		
	}
	
}
