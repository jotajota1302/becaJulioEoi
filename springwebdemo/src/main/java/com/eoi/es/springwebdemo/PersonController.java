package com.eoi.es.springwebdemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/person")
public class PersonController {

	ArrayList<Person> personas = new ArrayList<Person>();

	{
		personas.add(Person.builder().nombre("JJ").apellidos("JIMENEZ").build());
		personas.add(Person.builder().nombre("Maria").apellidos("RODRIGUEZ").build());
	}

	@GetMapping
	@ResponseBody
	public Person getPersona(@RequestParam(required = false) String nombre) {

		for (Person person : personas) {
			if (person.getNombre().equals(nombre)) {
				return person;
			}
		}
		return null;
	}

	@GetMapping(value = "/nombre/{nombre}")
	@ResponseBody
	public Person getPersonaByPath(@PathVariable String nombre) {

		for (Person person : personas) {
			if (person.getNombre().equals(nombre)) {
				return person;
			}
		}
		return null;
	}

	@GetMapping(value = "/apellidos/{apellidos}")
	@ResponseBody
	public Person getPersonaByApellidos(@PathVariable String apellidos) {

		for (Person person : personas) {
			if (person.getApellidos().equals(apellidos)) {
				return person;
			}
		}
		return null;
	}

	@GetMapping(value = "/all")
	@ResponseBody
	public List<Person> getPersonas() {

		return personas;
	}

	@PostMapping
	@ResponseBody
	public void createPerson(@RequestBody Person person) {

		personas.add(person);

	}

	@PutMapping
	@ResponseBody
	public void updatePersonSurname(@RequestBody Person person) {

		personas.stream().filter(p -> p.getNombre().equals(person.getNombre())).findFirst().get()
				.setApellidos(person.getApellidos());
		
	}

	@DeleteMapping
	@ResponseBody
	public void deletePerson(@RequestParam String nombre) {

		personas.remove(personas.stream().filter(p -> p.getNombre().equals(nombre)).findFirst().get());
	}

}
