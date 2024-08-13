package com.eoi.es.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.eoi.es.model.Medalla;
import com.eoi.es.model.Pais;
import com.eoi.es.service.MedalleroService;

public class MedalleroServiceMemImpl implements MedalleroService {
	
	List<Medalla> medallas= new ArrayList<Medalla>();
	
	{		
		medallas.add(new Medalla("Oro", Pais.USA, 5));
		medallas.add(new Medalla("Oro", Pais.CHN, 3));
		medallas.add(new Medalla("Oro", Pais.JPN, 2));		
		medallas.add(new Medalla("Plata", Pais.ESP, 4));
		medallas.add(new Medalla("Plata", Pais.AND, 1));
		medallas.add(new Medalla("Plata", Pais.AUS, 2));		
		medallas.add(new Medalla("Bronce", Pais.ECU, 6));
		medallas.add(new Medalla("Bronce", Pais.ARG, 3));
		medallas.add(new Medalla("Bronce", Pais.ALB, 1));
	}
	
	@Override
	public List<Medalla> findAll(){
		
		//TODO ORDENAR LA LISTA DE MEDALLAS SEGUN CRITERIO OLIMPICO
		// PRIMERO EL ORO, LUEGO LA PLATA y POR ULTIMO EL BRONCE
		
		return medallas;
		
	}
	
	
	public void add(Medalla medalla){
		
		//TODO buscar en la lista el pais y el tipo y +1 la cantidad
		
		
		
	}

}
