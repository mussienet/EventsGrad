package com.GradEvent.gradEvent.service;

import com.GradEvent.gradEvent.model.Event;
import com.GradEvent.gradEvent.model.Person;
import com.GradEvent.gradEvent.respository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public Person getPersonByEvent(Event event) {
        return null;
    }

    public List<Person> getAllPersons() {
        return this.personRepository.findAll();
    }

    public Person createPerson(Person person) {
        return this.personRepository.save(person);
    }

    public void deletePerson(Person person) {
        this.personRepository.delete(person);
    }

    public void deletePersonById(Long personId) {
        this.personRepository.deleteById(personId);
    }

    public Person updatePerson(Person person) {
        return this.personRepository.save(person);
    }

    public Person getPerson(Long personId) {
        return  this.personRepository.findById(personId).orElse(new Person());
    }
}
