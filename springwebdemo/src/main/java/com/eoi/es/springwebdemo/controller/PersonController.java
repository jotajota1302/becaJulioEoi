package com.eoi.es.springwebdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eoi.es.springwebdemo.dto.Person;

@RestController
@RequestMapping("/person")
public class PersonController {

	ArrayList<Person> persons = new ArrayList<Person>();

	@GetMapping	
	public Person getPersona(@RequestParam(required = false) String name) {

		for (Person person : persons) {
			if (person.getName().equals(name)) {
				return person;
			}
		}
		return null;
	}

	@GetMapping(value = "/{name}")	
	public Person getPersonaByPath(@PathVariable String name) {

		for (Person person : persons) {
			if (person.getName().equals(name)) {
				return person;
			}
		}
		return null;
	}

	@GetMapping(value = "/surname/{surname}")	
	public Person getPersonBySurname(@PathVariable String surname) {

		for (Person person : persons) {
			if (person.getSurname().equals(surname)) {
				return person;
			}
		}
		return null;
	}

	@GetMapping(value = "/all")	
	public List<Person> getPersons() {

		return persons;
	}

	@PostMapping	
	public void createPerson(@RequestBody @Valid Person person, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("hay campos incorrectos");
			System.out.println("errores: " + result.getAllErrors());			
		}
		else {
			persons.add(person);
		}
	}

	@PutMapping	
	public void updatePersonSurname(@RequestBody Person person) {

		persons.stream().filter(p -> p.getName().equals(person.getName())).findFirst().get()
				.setSurname(person.getSurname());

	}

	@DeleteMapping	
	public void deletePerson(@RequestParam String name) {

		persons.remove(persons.stream().filter(p -> p.getName().equals(name)).findFirst().get());
	}

}
