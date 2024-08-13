package com.eoi.es;

import java.util.List;

public class MedallasServiceImpl {
	
	private MedallasDaoJpaImpl dao= new MedallasDaoJpaImpl();
	
	public List<Medallas> findAll(){
		
		return dao.findAll();
		
	}
	
	public void add(String pais, String tipo) {
		
		Medallas informacion = dao.findByCodigo(pais);
		
		if(informacion!=null) {
			
			if(tipo.equals("oro")) {			
				informacion.setOro(informacion.getOro()+1);
			}
			
			if(tipo.equals("plata")) {			
				informacion.setPlata(informacion.getPlata()+1);
			}
			
			if(tipo.equals("bronce")) {			
				informacion.setBronce(informacion.getBronce()+1);
			}
			
			dao.update(informacion);
		}
		else {
			
			Medallas temp= new Medallas(pais, 0, 0, 0);
			
			if(tipo.equals("oro")) {			
				temp.setOro(temp.getOro()+1);
			}
			
			if(tipo.equals("plata")) {			
				temp.setPlata(temp.getPlata()+1);
			}
			
			if(tipo.equals("bronce")) {			
				temp.setBronce(temp.getBronce()+1);
			}
			
			dao.create(temp);
			
		}
		
		
	}

}
