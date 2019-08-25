package com.GradEvent.gradEvent.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private long event_id;
    private String eventName;
    private String eventDescription;
    @Column
    private LocalDate eventDate;
    private String eventAddress;


    @ManyToMany(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "events")
    private List<Person> participant = new ArrayList<>();


    public long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(long event_id) {
        this.event_id = event_id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventAddress() {
        return eventAddress;
    }

    public void setEventAddress(String eventAddress) {
        this.eventAddress = eventAddress;
    }

    public List<Person> getParticipant() {
        return participant;
    }

    public void setParticipant(List<Person> participant) {
        this.participant = participant;
    }

    public void addParticipant(Person person){
        this.participant.add(person);
    }
}
