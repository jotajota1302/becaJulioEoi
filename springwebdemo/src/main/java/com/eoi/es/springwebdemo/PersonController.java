package com.eoi.es.springwebdemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/person")
public class PersonController {

	@GetMapping
	@ResponseBody
	public List<Person> getPersonas() {

		ArrayList<Person> personas=new ArrayList<Person>();
		personas.add(Person.builder().nombre("JJ").apellidos("JIMENEZ").build());
		personas.add(Person.builder().nombre("MARIA").apellidos("PEREZ").build());
		
		return personas;
	}
	
	@PostMapping
	public void createPerson() {
		
		System.out.println("create person from post");
	}
	
	@PutMapping
	public void updatePerson() {
		
		System.out.println("update person from post");
	}
	
	@DeleteMapping
	public void deletePerson() {
		
		System.out.println("delete person from post");
	}
	
}
