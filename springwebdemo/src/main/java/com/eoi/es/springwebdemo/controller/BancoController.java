package com.eoi.es.springwebdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eoi.es.springwebdemo.dto.BancoDto;
import com.eoi.es.springwebdemo.service.BancoService;

@RestController
@RequestMapping("/bancos")
public class BancoController {


	@Autowired
	BancoService bancoService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<BancoDto> findById(@RequestParam String id) {	
		
		return new ResponseEntity<BancoDto>(bancoService.findById(id),HttpStatus.OK);
		
	}
	
	@GetMapping
	public ResponseEntity<?> findAll() {	
		
		return new ResponseEntity<List<BancoDto>>(bancoService.findAll(), HttpStatus.OK);
		
	}


	@PostMapping	
	public ResponseEntity<?> createBanco(@RequestBody @Valid BancoDto banco, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("hay campos incorrectos");
			System.out.println("errores: " + result.getAllErrors());		
			
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		else {

			bancoService.create(banco);
			return new ResponseEntity<String>(HttpStatus.CREATED);
		}
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<String> update(@RequestBody BancoDto banco, @PathVariable String id,BindingResult result) {

		
		if(id.equals(banco.getId())||result.hasErrors()) {
			System.out.println("hay campos incorrectos");
			System.out.println("errores: " + result.getAllErrors());		
			
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		else {

			bancoService.update(banco);
			return new ResponseEntity<String>(HttpStatus.ACCEPTED);
		}
	}

	@DeleteMapping	
	public void deleteBanco(@RequestParam String id) {

		bancoService.deleteById(id);
	}

}
