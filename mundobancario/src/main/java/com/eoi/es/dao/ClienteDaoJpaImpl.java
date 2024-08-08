package com.eoi.es.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.eoi.es.entity.Cliente;

public class ClienteDaoJpaImpl {

	EntityManager entityManager= Persistence.createEntityManagerFactory("PU_PRUEBA").createEntityManager();
	
	public Cliente findById(String dni) {
	
		return entityManager.find(Cliente.class, dni);
	}

}
