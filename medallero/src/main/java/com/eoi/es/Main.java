package com.eoi.es;

public class Main {

	public static void main(String[] args) {
		
		MedallasServiceImpl service= new MedallasServiceImpl();
		
//		MedallasDaoJpaImpl daoJpaImpl= new MedallasDaoJpaImpl();
//		
//		System.out.println(daoJpaImpl.findByCodigo("ESP"));
//		
//		System.out.println(daoJpaImpl.findAll());

		service.add("GHA", "oro");
		
		System.out.println(service.findAll());
		
	}

}
