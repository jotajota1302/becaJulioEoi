package com.eoi.es.springwebdemo.controller;

import java.util.List;

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

import com.eoi.es.springwebdemo.entity.Cliente;
import com.eoi.es.springwebdemo.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

	@Autowired
	ClienteRepository clienteRepository;

	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {

		return new ResponseEntity<List<Cliente>>(clienteRepository.findAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/{dni}")
	public ResponseEntity<Cliente> findById(@PathVariable String dni) {

		return new ResponseEntity<Cliente>(clienteRepository.findById(dni).get(), HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<String> create(@RequestBody Cliente cliente) {

		clienteRepository.save(cliente);

		return new ResponseEntity<String>(HttpStatus.CREATED);

	}

	@PutMapping(value = "/{dni}")
	public ResponseEntity<String> update(@RequestBody Cliente cliente, @PathVariable String dni) {

		clienteRepository.save(cliente);

		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}

	@DeleteMapping(value = "/{dni}")
	public ResponseEntity<String> deleteById(@PathVariable String dni) {

		clienteRepository.deleteById(dni);
		
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);

	}

}
