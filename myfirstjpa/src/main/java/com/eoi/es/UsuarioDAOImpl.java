package com.eoi.es;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

//DATA ACCES OBJECT - LA LOGICA DE TRABAJO CON BBDD - CRUD(CREATE - READ - UPDATE - DELETE)
public class UsuarioDAOImpl {

	EntityManager entityManager = Persistence.createEntityManagerFactory("PU_PRUEBA").createEntityManager();

	// READ BY ID
	public Usuario findById(int id) {

		return entityManager.find(Usuario.class, id);
	}
	
	// READ ALL
	public List<?> findAll() {
	
		Query query = entityManager.createQuery("FROM Usuario");
		
		query=entityManager.createNativeQuery("SELECT * FROM USUARIO",Usuario.class);
		return query.getResultList();
		
	}


	// CREATE
	public void create(Usuario usuario) {

		entityManager.getTransaction().begin();
		entityManager.persist(usuario);
		entityManager.getTransaction().commit();
	}

	// UPDATE
	public void update(Usuario usuario) {

		entityManager.getTransaction().begin();
		entityManager.merge(usuario);
		entityManager.getTransaction().commit();
	}

	// DELETE
	public void delete(Usuario usuario) {

		entityManager.getTransaction().begin();
		entityManager.remove(usuario);
		entityManager.getTransaction().commit();
	}

}
