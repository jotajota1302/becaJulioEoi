package com.eoi.es.springwebdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eoi.es.springwebdemo.dto.BancoDto;
import com.eoi.es.springwebdemo.dto.ClienteDto;
import com.eoi.es.springwebdemo.dto.CreateCuentaDto;
import com.eoi.es.springwebdemo.dto.CuentaDto;
import com.eoi.es.springwebdemo.entity.Banco;
import com.eoi.es.springwebdemo.entity.Cliente;
import com.eoi.es.springwebdemo.entity.Cuenta;
import com.eoi.es.springwebdemo.repository.BancoRepository;
import com.eoi.es.springwebdemo.repository.ClienteRepository;
import com.eoi.es.springwebdemo.repository.CuentaRepository;

@Service
public class CuentaService {

	@Autowired
	CuentaRepository cuentaRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	BancoRepository bancoRepository;

	public CuentaDto findById(String id) {

		CuentaDto cuentaDto = new CuentaDto();
		Cuenta entity = cuentaRepository.findById(Integer.valueOf(id)).get();
		cuentaDto.setSaldo(entity.getSaldo());

		ClienteDto clienteDto = new ClienteDto();
		clienteDto.setDni(entity.getCliente().getDni());
		clienteDto.setNombre(entity.getCliente().getNombre());

		BancoDto bancoDto = new BancoDto();
		bancoDto.setId(String.valueOf(entity.getBanco().getId()));
		bancoDto.setCiudad(entity.getBanco().getCiudad());
		bancoDto.setNombre(entity.getBanco().getNombre());

		cuentaDto.setCliente(clienteDto);
		cuentaDto.setBanco(bancoDto);
		
		return cuentaDto;
	}

//	public List<CuentaDto> findAll() {
//
//		List<CuentaDto> dtos = new ArrayList<CuentaDto>();
//		List<Cuenta> entities = cuentaRepository.findAll();
//
//		for (Cuenta cuenta : entities) {
//			CuentaDto dto = new CuentaDto();
//			dto.setId(String.valueOf(cuenta.getId()));
//			dto.setCiudad(cuenta.getCiudad());
//			dto.setNombre(cuenta.getNombre());
//
//			dtos.add(dto);
//		}
//
//		return dtos;
//
//	}
//
	public void create(CreateCuentaDto dto) {

		Cliente cliente= clienteRepository.findById(dto.getDni()).get();
		Banco banco= bancoRepository.findById(Integer.valueOf(dto.getIdbanco())).get();
		
		Cuenta entity = new Cuenta();	
		
		entity.setSaldo(dto.getSaldo());
		entity.setCliente(cliente);
		entity.setBanco(banco);
	
		cliente.getCuentas().add(entity);
		banco.getCuentas().add(entity);
		
		cuentaRepository.save(entity);

	}

//	public void update(CuentaDto dto) {
//
//		Cuenta entity = new Cuenta();
//		entity.setId(Integer.valueOf(dto.getId()));
//		entity.setNombre(dto.getNombre());
//		entity.setCiudad(dto.getCiudad());
//
//		cuentaRepository.save(entity);
//
//	}
//
//	public void deleteById(String id) {
//
//		cuentaRepository.deleteById(Integer.valueOf(id));
//
//	}
}
