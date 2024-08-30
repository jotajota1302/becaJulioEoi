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

import com.eoi.es.springwebdemo.model.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

	private List<Cliente> clientes = new ArrayList<>();

	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {

		return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
	}

	@GetMapping(value = "/{dni}")
	public ResponseEntity<Cliente> findById(@PathVariable String dni) {

		for (Cliente cliente : clientes) {
			if (cliente.getDni().equals(dni)) {
				return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
			}
		}

		return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);

	}

	@PostMapping
	public ResponseEntity<String> create(@RequestBody Cliente cliente) {

		if (!clientes.contains(cliente)) {
			clientes.add(cliente);

			return new ResponseEntity<String>(HttpStatus.CREATED);
		}
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}

	@PutMapping(value = "/{dni}")
	public ResponseEntity<String> update(@RequestBody Cliente cliente, @PathVariable String dni) {

		if (dni.equals(cliente.getDni())) {
			for (Cliente tmp : clientes) {
			
				if (tmp.getDni().equals((dni))) {
					tmp.setNombre(cliente.getNombre());
					tmp.setDireccion(cliente.getDireccion());
					
				}

				return new ResponseEntity<String>(HttpStatus.ACCEPTED);
			}
		}

		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping(value = "/{dni}")
	public ResponseEntity<String> deleteById(@PathVariable String dni) {

		for (Cliente cliente : clientes) {
			if (cliente.getDni().equals(dni)) {
				clientes.remove(cliente);
				
				return new ResponseEntity<String>(HttpStatus.ACCEPTED);
			}
		}
		
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST); 
	}

	@DeleteMapping
	public ResponseEntity<String> deleteAll() {

		clientes.removeAll(clientes);

		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
		
	}

}
