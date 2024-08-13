package com.eoi.es;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eoi.es.service.MedalleroService;
import com.eoi.es.service.impl.MedalleroServiceMemImpl;

@WebServlet("/ranking")
public class MedalleroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MedalleroService service= new MedalleroServiceMemImpl();
		
		response.getWriter().append("Medallero: " + service.findAll());
		
	}

	
}