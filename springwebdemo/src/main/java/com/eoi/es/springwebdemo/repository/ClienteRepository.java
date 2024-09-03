package com.eoi.es.springwebdemo.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eoi.es.springwebdemo.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String>{

	public List<Cliente> findByAltaGreaterThan(Date fecha);
	
	public List<Cliente> findByFechaNacimiento(Date fecha);
	
	@Query("FROM Cliente c where c.direccion= :direccion")
	public List<Cliente> findByAdress(String direccion);
	
	@Query(nativeQuery = true, value = "SELECT * FROM cliente c where c.direccion= :direccion")
	public List<Cliente> findByAdressNative(String direccion);
}
