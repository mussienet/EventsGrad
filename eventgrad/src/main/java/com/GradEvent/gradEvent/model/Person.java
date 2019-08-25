package com.GradEvent.gradEvent.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private long person_id;
    private String name;
    @Column(unique = true)
    private String email;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "Person_Event",
            joinColumns = {@JoinColumn(name = "person_id")},
            inverseJoinColumns = {@JoinColumn(name = "event_id")}
    )
//    @Fetch(FetchMode.SELECT)
    @JsonBackReference  // we use this for collections framework
//    @JsonManagedReference // we use this if it is not collections
    private Set<Event> events;

    public Person() {
        this.events = new HashSet<>();
    }

    public long getPerson_id() {
        return person_id;
    }

    public void setPerson_id(long person_id) {
        this.person_id = person_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addEvent(Event event) {
        this.events.add(event);
        event.addParticipant(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return person_id == person.person_id &&
                Objects.equals(name, person.name) &&
                Objects.equals(email, person.email) ;
//                Objects.equals(events, person.events); //we don't need to compare the events to compare person
    }

    @Override
    public int hashCode() {
        return Objects.hash(person_id, name, email); // events attribute is removed because we don't need to compare events in person plus it will create recursive infinite loop when we are using many to many relationships
    }
}
