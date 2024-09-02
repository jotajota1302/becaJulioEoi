package com.eoi.es.springwebdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eoi.es.springwebdemo.dto.BancoDto;
import com.eoi.es.springwebdemo.entity.Banco;
import com.eoi.es.springwebdemo.repository.BancoRepository;

@Service
public class BancoService {
	
	@Autowired
	BancoRepository bancoRepository;
	
	public BancoDto findById(String id) {
		
		 BancoDto dto= new BancoDto();		 
		 Banco entity = bancoRepository.findById(Integer.valueOf(id)).get();
	
		 BeanUtils.copyProperties(entity,dto);		 
		 
		 return dto;	
	}
	
	public List<BancoDto> findAll() {
		
		
		List<BancoDto> dtos= new ArrayList<BancoDto>();		
		List<Banco> entities=bancoRepository.findAll();
				
		for (Banco banco : entities) {
			BancoDto dto= new BancoDto();
			dto.setId(String.valueOf(banco.getId()));
			dto.setCiudad(banco.getCiudad());
			dto.setNombre(banco.getNombre());
			
			dtos.add(dto);
		}
				
		return dtos;
		
	}

	public void create(BancoDto dto) {
		
		Banco entity= new Banco();
		entity.setNombre(dto.getNombre());
		entity.setCiudad(dto.getCiudad());
		
		bancoRepository.save(entity);
		
	}
	
	public void update(BancoDto dto) {
	
		Banco entity= new Banco();
		entity.setId(Integer.valueOf(dto.getId()));
		entity.setNombre(dto.getNombre());
		entity.setCiudad(dto.getCiudad());
		
		bancoRepository.save(entity);
		
	}

	public void deleteById(String id) {
		
		bancoRepository.deleteById(Integer.valueOf(id));
		
	}


}
