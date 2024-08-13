package com.eoi.es;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/calculardias")
public class MiPrimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String fecha = request.getParameter("fecha");

	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	    LocalDate fechaNacimiento = LocalDate.parse(fecha, formatter);

	    LocalDate fecha67Anios = fechaNacimiento.plusYears(67);

	    LocalDate fechaActual = LocalDate.now();

	    long dias = ChronoUnit.DAYS.between(fechaActual, fecha67Anios);

	    response.getWriter().append("Días que te faltan para cumplir 67 años: " + dias + " ");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
