package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Exception.PersonNotFound;
import com.example.model.Persons;
import com.example.service.PersonService;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping("/getAll")
	public List<Persons> getAll() {
		return personService.getAllPersons();
	}

	@GetMapping("/get/{id}")
	public Persons getById(@PathVariable Long id) {
		return personService.getPersonById(id).orElseThrow(() -> new PersonNotFound(id));
	}

	@DeleteMapping("/delete/{id}")
	public void deletePerson(@PathVariable Long id) {
		personService.delete(id);
	}

	@PostMapping("/save")
	public Persons save(@RequestBody Persons persons) {
		return personService.savePersons(persons);
	}

	@PutMapping("/update/{id}")
	public Persons update(@RequestBody Persons persons, @PathVariable Long id) {
		return personService.updatePersons(id, persons);

	}

}
