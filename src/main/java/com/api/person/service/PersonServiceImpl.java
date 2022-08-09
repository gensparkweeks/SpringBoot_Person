package com.api.person.service;

import com.api.person.dao.PersonDao;
import com.api.person.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    PersonDao personDao;


    @Override
    public List<Person> findAllPerson() {
        return personDao.findAll();
    }

    @Override
    public Person findPersonById(int personId) {

        Person p = null;

        Optional<Person> opt =  personDao.findById(personId);
        if (opt.isPresent()){
            p = opt.get();
        }else{
            throw new RuntimeException("The person "+ personId+ " is not found");
        }

        return p;
    }

    @Override
    public Person createPerson(Person person) {
        return personDao.save(person);
    }

    @Override
    public Person updatePerson(Person person) {
        return personDao.save(person);
    }

    @Override
    public String deletePerson(int personId) {
        personDao.deleteById(personId);
        return "The person "+personId+" was deleted";
    }
}
