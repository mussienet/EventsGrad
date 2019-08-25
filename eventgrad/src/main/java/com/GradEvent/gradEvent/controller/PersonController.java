package com.GradEvent.gradEvent.controller;

import com.GradEvent.gradEvent.model.Event;
import com.GradEvent.gradEvent.model.Person;
import com.GradEvent.gradEvent.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping(value = "person/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") Long personId) {
        return new ResponseEntity<>(this.personService.getPerson(personId), HttpStatus.OK);
    }

    @GetMapping(value = "person/event")
    public ResponseEntity<Person> getPersonByEvent(Event event) {
        return new ResponseEntity<>(this.personService.getPersonByEvent(event), HttpStatus.OK);
    }

    @GetMapping(value = "persons")
    public ResponseEntity<List<Person>> getAllPersons() {
        //  List<Person> personList = this.personService.getAllPersons();
        return new ResponseEntity<>(this.personService.getAllPersons(), HttpStatus.OK);

    }

    @PostMapping(value = "createperson")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        return new ResponseEntity<>(this.personService.createPerson(person), HttpStatus.OK);
    }

    @PutMapping(value = "updateperson")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person) {

        return new ResponseEntity<Person>(this.personService.updatePerson(person), HttpStatus.OK);
    }

    @DeleteMapping(value = "deleteperson")
    public ResponseEntity<Person> deleteEvent(@RequestBody Person person) {
        this.personService.deletePerson(person);
        return new ResponseEntity<Person>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "deleteperson/{id}")
    public ResponseEntity<Person> deletePersonById(@PathVariable("id") Long personId) {
        this.personService.deletePersonById(personId);
        return new ResponseEntity<Person>(HttpStatus.ACCEPTED);
    }
}

