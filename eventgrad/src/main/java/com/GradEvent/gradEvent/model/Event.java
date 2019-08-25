package com.GradEvent.gradEvent.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Event implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private long event_id;
    private String eventName;
    private String eventDescription;
    @Column
    private LocalDate eventDate;
    private String eventAddress;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "events")
//    @Fetch(FetchMode.SELECT)
//    @JsonManagedReference // we use this if it is not collections framework
//    @JsonBackReference // we use this for collections framework
    private Set<Person> participant;

    public Event() {
        this.participant = new HashSet<>();
    }

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

    public Set<Person> getParticipant() {
        return participant;
    }

    public void setParticipant(Set<Person> participant) {
        this.participant = participant;
    }

    public void addParticipant(Person person) {
        this.participant.add(person);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return event_id == event.event_id &&
                Objects.equals(eventName, event.eventName) &&
                Objects.equals(eventDescription, event.eventDescription) &&
                Objects.equals(eventDate, event.eventDate) &&
                Objects.equals(eventAddress, event.eventAddress);
//                Objects.equals(participant, event.participant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(event_id, eventName, eventDescription, eventDate, eventAddress); // participant removed to avoid infinite loop
    }
}
