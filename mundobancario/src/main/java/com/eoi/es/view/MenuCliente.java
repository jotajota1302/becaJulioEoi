package com.eoi.es.view;

import java.util.Scanner;

import com.eoi.es.service.ClienteService;

public class MenuCliente {

	public static void printMenuCliente() {

		System.out.println("Introduzca DNI:");

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String dni = scanner.next();	

		ClienteService service = new ClienteService();		
		
		System.out.println(service.findByDni(dni));

		MenuPrincipal.printMenuPrincipal();

	}

}
