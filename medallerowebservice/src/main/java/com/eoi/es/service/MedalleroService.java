package com.eoi.es.service;

import java.util.Map;

import com.eoi.es.model.InformacionPais;

public interface MedalleroService {

	Map<String, InformacionPais> findAll();
	
	public void add(String pais, String tipo);

}