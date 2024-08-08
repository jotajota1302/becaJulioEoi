package com.eoi.es;

public class Main {
	
	public static void main(String[] args) {
	
		
		
//		SubscripcionDAOImpl daoSubscripcion= new SubscripcionDAOImpl();
		
//		Subscripcion sub=new Subscripcion();
//		sub.setNombre("premium");
//		sub.setPrecio(50.0);
//		
//		daoSubscripcion.create(sub);
		
		UsuarioDAOImpl dao= new UsuarioDAOImpl();
//		Usuario usuario = dao.findById(10);
		
//		System.out.println(usuario.getMascota().getNombre());
		
		Usuario user = dao.findById(5);
		
		System.out.println(user.getFavoritos());
		
		System.out.println(dao.findAll());
		
//		dao.delete(user);
		
		
		
	}

}
