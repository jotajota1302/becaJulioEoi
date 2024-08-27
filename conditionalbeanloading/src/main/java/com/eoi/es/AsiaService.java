package com.eoi.es;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AsiaService implements MyService {
	
	private static Logger log=LoggerFactory.getLogger(AsiaService.class);
	
	@Override
	public void doSomething() {
		
		log.trace("entro en el metodo de do something por trace");
		log.debug("entro en el metodo de do something por debug");	
		log.info("entro en el metodo de do something por info");
		log.warn("entro en el metodo de do something por warn");
		log.error("entro en el metodo de do something por error");
		
		
		System.out.println("ハローワールド");
		
		
		
	}

	@Override
	public double calculateSomething(Double a, Double b) {	
	
		log.debug("entro en el metodo de do something por debug, a=" + a + " , y b=" + b);	
		log.info("entro en el metodo de calcular algo");
			
		return a/b;		
		
	}

}
