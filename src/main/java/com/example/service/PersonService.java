package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Exception.PersonNotFound;
import com.example.model.Persons;
import com.example.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public List<Persons> getAllPersons() {
		return personRepository.findAll();
	}

	public Optional<Persons> getPersonById(Long id) {
		return personRepository.findById(id);
	}

	public Persons savePersons(Persons persons) {
		return personRepository.save(persons);
	}

	public Persons updatePersons(Long id, Persons updatePersons) {
		Optional<Persons> optionalPersons = personRepository.findById(id);

		if (optionalPersons.isPresent()) {
			Persons existingPersons = optionalPersons.get();

			existingPersons.setName(updatePersons.getName());
			existingPersons.setAge(updatePersons.getAge());

			return personRepository.save(existingPersons);
		} else {
			throw new PersonNotFound(id);
		}

	}

	public void delete(Long id) {
		personRepository.deleteById(id);
	}

}
