package com.eoi.es.springwebdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eoi.es.springwebdemo.entity.Cuenta;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

}
