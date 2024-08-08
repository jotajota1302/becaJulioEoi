package com.eoi.es.view;

import java.util.Scanner;

public class MenuPrincipal {
	
	public static void printMenuPrincipal() {
		
		System.out.println("Elige una opcion:");
		System.out.println("1-Menu de clientes");
		System.out.println("2-Menu de cuentas");
		System.out.println("3-Menu de bancos");
		
	
		@SuppressWarnings("resource")
		Scanner scanner= new Scanner(System.in);		
		int resultado = scanner.nextInt();		
		
		switch (resultado) {
		case 1:
			MenuCliente.printMenuCliente();
			break;

		default:
			break;
		}
		
		printMenuPrincipal();
	}

}
