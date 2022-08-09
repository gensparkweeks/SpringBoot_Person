package com.api.person.service;

import com.api.person.model.Person;

import java.util.List;

public interface PersonService {

    List<Person> findAllPerson();
    Person findPersonById(int personId);
    Person createPerson(Person person);
    Person updatePerson(Person person);
    String deletePerson(int personId);
}
