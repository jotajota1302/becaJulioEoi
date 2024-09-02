package com.eoi.es.springwebdemo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eoi.es.springwebdemo.dto.CreateCuentaDto;
import com.eoi.es.springwebdemo.dto.CuentaDto;
import com.eoi.es.springwebdemo.service.CuentaService;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {


	@Autowired
	CuentaService cuentaService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<CuentaDto> findById(@RequestParam String id) {	
		
		return new ResponseEntity<CuentaDto>(cuentaService.findById(id),HttpStatus.OK);
		
	}
	
//	@GetMapping
//	public ResponseEntity<?> findAll() {	
//		
//		return new ResponseEntity<List<CuentaDto>>(cuentaService.findAll(), HttpStatus.OK);
//		
//	}


	@PostMapping	
	public ResponseEntity<?> createCuenta(@RequestBody @Valid CreateCuentaDto cuenta, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("hay campos incorrectos");
			System.out.println("errores: " + result.getAllErrors());		
			
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		else {

			cuentaService.create(cuenta);
			return new ResponseEntity<String>(HttpStatus.CREATED);
		}
	}
//	
//	@PutMapping(value = "/{id}")
//	public ResponseEntity<String> update(@RequestBody CuentaDto cuenta, @PathVariable String id,BindingResult result) {
//
//		
//		if(id.equals(cuenta.getId())||result.hasErrors()) {
//			System.out.println("hay campos incorrectos");
//			System.out.println("errores: " + result.getAllErrors());		
//			
//			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
//		}
//		else {
//
//			cuentaService.update(cuenta);
//			return new ResponseEntity<String>(HttpStatus.ACCEPTED);
//		}
//	}
//
//	@DeleteMapping	
//	public void deleteCuenta(@RequestParam String id) {
//
//		cuentaService.deleteById(id);
//	}

}
