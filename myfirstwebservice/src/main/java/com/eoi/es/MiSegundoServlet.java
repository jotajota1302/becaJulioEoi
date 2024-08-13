package com.eoi.es;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/listarproductos")
public class MiSegundoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public static List<Producto> productos= new ArrayList<Producto>(); 
    
    {
    	productos.add(new  Producto("TV","Televisión",399.0));
    	productos.add(new  Producto("PC","Ordenador",599.0));
    	productos.add(new  Producto("Ipad","Tableta interactiva",299.0));
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		  response.getWriter().append(productos.toString());		
	}

	

}
