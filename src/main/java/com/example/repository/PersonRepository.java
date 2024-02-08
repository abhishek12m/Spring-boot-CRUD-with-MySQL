package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Persons;

public interface PersonRepository extends JpaRepository<Persons, Long> {

}
