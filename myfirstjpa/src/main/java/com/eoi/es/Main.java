package com.eoi.es;

import java.util.Calendar;

public class Main {

	public static void main(String[] args) throws Exception {

		long inicioMs = Calendar.getInstance().getTimeInMillis();

		UsuarioDao daoJDBC = new UsuarioDaoJdbcImpl();

		Usuario usuario1 = daoJDBC.findById(5);
		usuario1 = daoJDBC.findById(1);

		long finMs = Calendar.getInstance().getTimeInMillis();

		System.out.println("He tardado " + (finMs - inicioMs));

		long inicioJPAMs = Calendar.getInstance().getTimeInMillis();

		UsuarioDao daoJPA = new UsuarioDaoJpaImpl();

		Usuario usuario2 = daoJPA.findById(5);
		usuario2 = daoJPA.findById(1);

		long finJPAMs = Calendar.getInstance().getTimeInMillis();

		System.out.println("He tardado " + (finJPAMs - inicioJPAMs));

	}

}
