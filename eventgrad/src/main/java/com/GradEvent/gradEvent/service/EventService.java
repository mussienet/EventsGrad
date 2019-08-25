package com.GradEvent.gradEvent.service;

import com.GradEvent.gradEvent.model.Event;
import com.GradEvent.gradEvent.model.Person;
import com.GradEvent.gradEvent.respository.EventRepository;
import com.GradEvent.gradEvent.respository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    PersonRepository personRepository;

    public Event creatEvent(Event event) {

        return this.eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return this.eventRepository.findAll();
    }

    public Event updateEvent(Event event) {
        return this.eventRepository.save(event);
    }

    public void deleteEvent(Event event) {

        this.eventRepository.delete(event);

    }

    public void deleteEventById(Long id) {
        this.eventRepository.deleteById(id);
    }

    public Event getEventById(Long eventId) {
        return this.eventRepository.findById(eventId).orElse(new Event());
    }

    public List<Event> getEventByEventName(String eventName) {
        return this.eventRepository.findEventByEventName(eventName);
    }


    public Boolean addParticipant(long event_id, long person_id) {
        Event event1 = this.eventRepository.findById(event_id).get();
        Person person1 = this.personRepository.findById(person_id).get();
        person1.addEvent(event1);

        this.personRepository.save(person1);
        this.eventRepository.save(event1);

        return true;

    }
}
