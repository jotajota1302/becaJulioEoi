package com.eoi.es.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.eoi.es.model.InformacionPais;
import com.eoi.es.model.Pais;
import com.eoi.es.service.MedalleroService;

public class MedalleroServiceMemImpl implements MedalleroService {
	
	Map<String, InformacionPais> medallas=new HashMap<String, InformacionPais>();
		
	{		
		medallas.put(Pais.CHN.getCodigo(), new InformacionPais(0,23,5));
		medallas.put(Pais.USA.getCodigo(), new InformacionPais(5,3,0));
		medallas.put(Pais.ESP.getCodigo(), new InformacionPais(3,2,1));
		medallas.put(Pais.JPN.getCodigo(), new InformacionPais(1,1,8));		
	}
	
	@Override
	public Map<String, InformacionPais> findAll(){
		
		//logica de ordenacion con comparables
		
		return medallas;
		
	}
	
	
	public void add(String pais, String tipo){
		
		
		if(medallas.containsKey(pais)) {
			
			switch (tipo) {
			case "oro":
				medallas.get(pais).setOro(medallas.get(pais).getOro()+1);
				break;
			case "plata":
				medallas.get(pais).setPlata(medallas.get(pais).getPlata()+1);
				break;
			case "bronce":
				medallas.get(pais).setBronce(medallas.get(pais).getBronce()+1);
				break;
			default:
				break;
			}
			
			
		}
		
		
	}

}
