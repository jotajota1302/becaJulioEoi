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
	
	public ClienteDto findByDni(String dni) {
		
		Cliente cliente=clienteRepository.findById(dni).get();
		
		ClienteDto dto= new ClienteDto();
		dto.setDni(cliente.getDni());
		dto.setNombre(cliente.getNombre());
		
		cliente.getCuentas().forEach(c->{			
			dto.setSaldo(dto.getSaldo()+ c.getSaldo());
		});
				
		return dto;
	}
	
	public List<ClienteDto> findAll() {
		
		//en BBDD recupero entidades
		
		List<Cliente> clientes=clienteRepository.findAll();	
		
		//tengo que devolver DTO
		
		List<ClienteDto> dtos=new ArrayList<ClienteDto>();
		
		for (Cliente cliente : clientes) {
			
			ClienteDto dto= new ClienteDto();
			dto.setDni("#########");
			dto.setNombre(cliente.getNombre());
			//COMO CONSIGO EL SALDO
			dto.setSaldo(500);
			
			dtos.add(dto);
		}
				
		return dtos;
		
	}

	public void create(ClienteDto dto) {
		
		Cliente entity= new Cliente();
		entity.setDni(dto.getDni());
		entity.setDireccion(dto.getDireccion());
		entity.setNombre(dto.getNombre());		
	
		clienteRepository.save(entity);
		
	}
	
	public void update(ClienteDto dto) {
		
		Cliente entity= new Cliente();
		entity.setDni(dto.getDni());
		entity.setDireccion(dto.getDireccion());
		entity.setNombre(dto.getNombre());		
	
		clienteRepository.save(entity);
		
	}

	public void deleteById(String dni) {
		
		clienteRepository.deleteById(dni);
		
	}

}
