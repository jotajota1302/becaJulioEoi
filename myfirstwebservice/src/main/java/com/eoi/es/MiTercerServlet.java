package com.eoi.es;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/addproducto")
public class MiTercerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
    	 String codigo=request.getParameter("codigo");
    	 String descripcion=request.getParameter("descripcion");
    	 String precio=request.getParameter("precio");
    	 
    	 Producto p= new Producto(codigo, descripcion,Double.valueOf(precio));
    	
		 MiSegundoServlet.productos.add(p);	
	}

}
