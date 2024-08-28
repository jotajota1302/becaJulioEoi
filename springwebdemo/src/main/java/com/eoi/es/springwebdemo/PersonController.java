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

	ArrayList<Person> personas=new ArrayList<Person>();
	
	
	@GetMapping
	@ResponseBody
	public List<Person> getPersonas() {		
		
		return personas;
	}
	
	@PostMapping
	@ResponseBody
	public void createPerson() {

		personas.add(Person.builder().nombre("JJ").apellidos("JIMENEZ").build());	
	}
	
	@PutMapping
	@ResponseBody
	public void updatePerson() {
		
		personas.get(personas.size()-1).setApellidos("RODRIGUEZ");
	}
	
	@DeleteMapping
	@ResponseBody
	public void deletePerson() {
		
		personas.remove(personas.size()-1);
	}
	
}
