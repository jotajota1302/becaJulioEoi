package com.eoi.es;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class MedallasDaoJpaImpl {

	EntityManager entityManager = Persistence.createEntityManagerFactory("PU_PRUEBA").createEntityManager();

	public Medallas findByCodigo(String codigo) {

		return entityManager.find(Medallas.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Medallas> findAll() {

		Query query = entityManager.createNativeQuery("SELECT * FROM medallas order by oro desc,plata desc,bronce desc",
				Medallas.class);

		return query.getResultList();
	}

	public void create(Medallas medallas) {

		entityManager.getTransaction().begin();
		entityManager.persist(medallas);
		entityManager.getTransaction().commit();
	}
	
	public void update(Medallas medallas) {

		entityManager.getTransaction().begin();
		entityManager.merge(medallas);
		entityManager.getTransaction().commit();
	}

}
