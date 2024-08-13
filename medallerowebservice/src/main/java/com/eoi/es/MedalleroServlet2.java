package com.eoi.es;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eoi.es.model.Pais;
import com.eoi.es.service.MedalleroService;
import com.eoi.es.service.impl.MedalleroServiceMemImpl;

@WebServlet("/addmedalla")
public class MedalleroServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
						
		MedalleroService service= new MedalleroServiceMemImpl();
		
		String pais=request.getParameter("pais");
		String tipo=request.getParameter("tipo");
	
		service.add(Pais.fromCodigo(pais).getCodigo(), tipo);
		
		response.getWriter().append("Medalla añadida");
		
	}
	
	

	
}