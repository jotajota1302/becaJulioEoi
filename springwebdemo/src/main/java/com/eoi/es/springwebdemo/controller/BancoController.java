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

import com.eoi.es.springwebdemo.dto.BancoDto;

@RestController
@RequestMapping("/bancos")
public class BancoController {

	ArrayList<BancoDto> bancos = new ArrayList<BancoDto>();

	@GetMapping(value = "/{id}")
	public BancoDto getBanco(@RequestParam Integer id) {

		for (BancoDto banco : bancos) {
			if (banco.getId()==id) {
				return banco;
			}
		}
		return null;
	}

	@PostMapping	
	public void createBanco(@RequestBody @Valid BancoDto banco, BindingResult result) {
		
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
