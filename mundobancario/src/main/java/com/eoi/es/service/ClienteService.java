package com.eoi.es.service;

import com.eoi.es.dao.ClienteDaoJpaImpl;
import com.eoi.es.entity.Cliente;

public class ClienteService {

	// si tengo que llamar a la tabla clientes utilizaré

	ClienteDaoJpaImpl dao = new ClienteDaoJpaImpl();

	public Cliente findByDni(String dni) {

		Cliente cliente = dao.findById(dni);
	
		return cliente;
	}

}
