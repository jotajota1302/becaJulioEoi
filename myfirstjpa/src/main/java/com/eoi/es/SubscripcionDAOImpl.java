package com.eoi.es;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

//DATA ACCES OBJECT - LA LOGICA DE TRABAJO CON BBDD - CRUD(CREATE - READ - UPDATE - DELETE)
public class SubscripcionDAOImpl {

	EntityManager entityManager = Persistence.createEntityManagerFactory("PU_PRUEBA").createEntityManager();

	// READ BY ID
	public Subscripcion findById(int id) {

		return entityManager.find(Subscripcion.class, id);
	}

	// CREATE
	public void create(Subscripcion subscripcion) {

		entityManager.getTransaction().begin();
		entityManager.persist(subscripcion);
		entityManager.getTransaction().commit();
	}

	// UPDATE
	public void update(Subscripcion subscripcion) {

		entityManager.getTransaction().begin();
		entityManager.merge(subscripcion);
		entityManager.getTransaction().commit();
	}

	// DELETE
	public void delete(Subscripcion subscripcion) {

		entityManager.getTransaction().begin();
		entityManager.remove(subscripcion);
		entityManager.getTransaction().commit();
	}

}
