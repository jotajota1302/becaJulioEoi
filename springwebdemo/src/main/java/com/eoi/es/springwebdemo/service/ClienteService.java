package com.eoi.es.springwebdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eoi.es.springwebdemo.dto.ClienteDto;
import com.eoi.es.springwebdemo.entity.Cliente;
import com.eoi.es.springwebdemo.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public List<ClienteDto> findAll() {
		
		//en BBDD recupero entidades
		
		List<Cliente> clientes=clienteRepository.findAll();	
		
		//tengo que devolver DTO
		
		List<ClienteDto> dtos=new ArrayList<ClienteDto>();
		
		for (Cliente cliente : clientes) {
			
			ClienteDto dto= new ClienteDto();
			dto.setDni(cliente.getDni());
			dto.setNombre(cliente.getNombre());
			//COMO CONSIGO EL SALDO
			dto.setSaldo(500);
			
			dtos.add(dto);
		}
				
		return dtos;
		
	}

}
