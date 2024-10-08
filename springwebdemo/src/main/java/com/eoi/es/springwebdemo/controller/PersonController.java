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

import com.eoi.es.springwebdemo.dto.PersonDto;

@RestController
@RequestMapping("/person")
public class PersonController {

	ArrayList<PersonDto> persons = new ArrayList<PersonDto>();

	@GetMapping	
	public PersonDto getPersona(@RequestParam(required = false) String name) {

		for (PersonDto person : persons) {
			if (person.getName().equals(name)) {
				return person;
			}
		}
		return null;
	}

	@GetMapping(value = "/{name}")	
	public PersonDto getPersonaByPath(@PathVariable String name) {

		for (PersonDto person : persons) {
			if (person.getName().equals(name)) {
				return person;
			}
		}
		return null;
	}

	@GetMapping(value = "/surname/{surname}")	
	public PersonDto getPersonBySurname(@PathVariable String surname) {

		for (PersonDto person : persons) {
			if (person.getSurname().equals(surname)) {
				return person;
			}
		}
		return null;
	}

	@GetMapping(value = "/all")	
	public List<PersonDto> getPersons() {

		return persons;
	}

	@PostMapping	
	public void createPerson(@RequestBody @Valid PersonDto person, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("hay campos incorrectos");
			System.out.println("errores: " + result.getAllErrors());			
		}
		else {
			persons.add(person);
		}
	}

	@PutMapping	
	public void updatePersonSurname(@RequestBody PersonDto person) {

		persons.stream().filter(p -> p.getName().equals(person.getName())).findFirst().get()
				.setSurname(person.getSurname());

	}

	@DeleteMapping	
	public void deletePerson(@RequestParam String name) {

		persons.remove(persons.stream().filter(p -> p.getName().equals(name)).findFirst().get());
	}

}
