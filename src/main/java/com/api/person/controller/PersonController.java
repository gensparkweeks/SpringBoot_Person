package com.api.person.controller;

import com.api.person.model.Person;
import com.api.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/home")
    public String home(){
        return "<html><h1>Welcome to this presentation</h1></html>";
    }

    @GetMapping("/persons")
    public List<Person> findAllPerson(){
        return personService.findAllPerson();
    }

    @GetMapping("/persons/{personId}")
    public Person findPersonById(@PathVariable int personId){
        return personService.findPersonById(personId);
    }

    @PostMapping("/persons")
    public Person createPerson(@RequestBody Person person){
        return personService.createPerson(person);
    }

    @PutMapping("/persons")
    public Person updatePerson(@RequestBody Person person){
        return personService.updatePerson(person);
    }

    @DeleteMapping("/persons/{personId}")
    public String deletePerson(@PathVariable int personId){
        return personService.deletePerson(personId);
    }
}
