package com.eoi.es.springwebdemo.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eoi.es.springwebdemo.dto.Banco;

@RestController
@RequestMapping("/bancos")
public class BancoController {

	ArrayList<Banco> bancos = new ArrayList<Banco>();

	@GetMapping(value = "/{id}")
	public Banco getBanco(@RequestParam Integer id) {

		for (Banco banco : bancos) {
			if (banco.getId()==id) {
				return banco;
			}
		}
		return null;
	}

	@PostMapping	
	public void createBanco(@RequestBody @Valid Banco banco, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("hay campos incorrectos");
			System.out.println("errores: " + result.getAllErrors());			
		}
		else {
			bancos.add(banco);
		}
	}

	@DeleteMapping	
	public void deleteBanco(@RequestParam Integer id) {

		bancos.remove(bancos.stream().filter(p -> p.getId()==id).findFirst().get());
	}

}
