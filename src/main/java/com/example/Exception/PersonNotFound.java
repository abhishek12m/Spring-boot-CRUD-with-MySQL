package com.example.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PersonNotFound extends RuntimeException {

	public PersonNotFound(Long id) {
		super("Person not found with id: " + id);
	}
}
