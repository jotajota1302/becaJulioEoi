package com.eoi.es.springwebdemo.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.eoi.es.springwebdemo.dto.ClienteDto;
import com.eoi.es.springwebdemo.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

	@Autowired
	ClienteService clienteService;

	@GetMapping
	public ResponseEntity<List<ClienteDto>> findAll() {

		return new ResponseEntity<List<ClienteDto>>(clienteService.findAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/{dni}")
	public ResponseEntity<ClienteDto> findById(@PathVariable String dni) {

		return new ResponseEntity<ClienteDto>(clienteService.findByDni(dni), HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<String> create(@RequestBody @Valid ClienteDto cliente) {

		clienteService.create(cliente);

		return new ResponseEntity<String>(HttpStatus.CREATED);

	}

	@PutMapping(value = "/{dni}")
	public ResponseEntity<String> update(@RequestBody ClienteDto cliente, @PathVariable String dni) {

		clienteService.update(cliente);

		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}

	
	@DeleteMapping(value = "/{dni}")
	public ResponseEntity<String> deleteById(@PathVariable String dni) {

		clienteService.deleteById(dni);
		
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);

	}

}
