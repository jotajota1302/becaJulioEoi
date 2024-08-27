package com.eoi.es;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class UpdateMedallasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
						
		MedallasServiceImpl service= new MedallasServiceImpl();
		
		String pais=request.getParameter("pais");
		String tipo=request.getParameter("tipo");
	
		//TODO VALIDADOR que estos campos esten bien
		
		service.add(Pais.fromCodigo(pais).getCodigo(), tipo);
		
		response.getWriter().append("Medalla añadida");
		
	}
	
	

	
}