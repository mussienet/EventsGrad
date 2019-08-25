package com.GradEvent.gradEvent.controller;

import com.GradEvent.gradEvent.model.Event;
import com.GradEvent.gradEvent.model.Person;
import com.GradEvent.gradEvent.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class EventController {

    @Autowired
    EventService eventService;

    @PostMapping(value = "createEvent")
    public ResponseEntity<Event> creatEvent(@RequestBody Event event) {

        return new ResponseEntity<>(this.eventService.creatEvent(event), HttpStatus.OK);
        // return  new ResponseEntity<Event>(event, HttpStatus.OK);
    }

    @GetMapping(value = "getallevents")
    public ResponseEntity<List<Event>> getAllEvents() {

        List<Event> events = this.eventService.getAllEvents();
        return new ResponseEntity<>(events, HttpStatus.OK);

    }

    @GetMapping(value = "geteventbyid/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable("id") Long eventId) {

        Event event = this.eventService.getEventById(eventId);

        return new ResponseEntity<>( event, HttpStatus.OK);

    }

    @GetMapping(value = "geteventbyeventname")
    public ResponseEntity<List<Event>> getEventByEventName(@RequestParam(value = "eventName", required = false) String eventName) {
        List<Event> eventlist = this.eventService.getEventByEventName(eventName);
       return new ResponseEntity<List<Event>>( eventlist,HttpStatus.OK);
    }

    @PutMapping(value = "updateevent")
    public ResponseEntity<Event> updateEvent(@RequestBody Event event) {

        Event event1 = this.eventService.updateEvent(event);
        return new ResponseEntity<Event>(event1, HttpStatus.OK);
    }

    @DeleteMapping(value = "deleteevent")
    public ResponseEntity<Event> deleteEvent(@RequestBody Event event) {
        this.eventService.deleteEvent(event);
        return new ResponseEntity<Event>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "deleteevent/{id}")
    public ResponseEntity<Event> deleteEventById(@PathVariable("id") Long eventId) {
        this.eventService.deleteEventById(eventId);
        return new ResponseEntity<Event>(HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "add-participant")
    public ResponseEntity<Event> addParticipant(@RequestParam("eventid") long event_id, @RequestParam("personid") long person_id ) {


        return new ResponseEntity<>(this.eventService.addParticipant(event_id, person_id), HttpStatus.OK);
    }

}
