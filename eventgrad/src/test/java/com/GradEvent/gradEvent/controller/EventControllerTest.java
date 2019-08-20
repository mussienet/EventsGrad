package com.GradEvent.gradEvent.controller;


import com.GradEvent.gradEvent.model.Event;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EventControllerTest {

    private Event event;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        event = new Event();
        event.setEventName("Graduation");
//        event.setEventDate(LocalDate.of(2020, 3, 2));
        event.setEventDescription("grad");
        event.setEventAddress("1206 Kelston pl apt 104");

    }

    @Test
    public void createEventTestUnit() {
        ResponseEntity<Event> actual = (new EventController()).creatEvent(event);
        ResponseEntity<Event> expect = new ResponseEntity<>(event, HttpStatus.OK);

        assertEquals(expect, actual);
    }

    @Test
    public void creatEventTest() throws Exception {

        // ResponseEntity<Event> actual= (new EventController()).creatEvent(event); for smokeTest

        //  ResponseEntity<Event> expect = new ResponseEntity<>(event, HttpStatus.OK);

//        ResponseEntity<Event> actual;
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/createEvent")
                .content(asJsonSting(this.event))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.eventName").value("Graduation"));


//        assertEquals(expect,actual);
    }

    @Test
    public void getAllEventsTestUnit() {

        ResponseEntity<List<Event>> actual = (new EventController()).getAllEvents();

        List<Event> events = new ArrayList<>();
        events.add(event);
        ResponseEntity<List<Event>> expect = new ResponseEntity<>(events, HttpStatus.OK);

        assertEquals(expect.toString(), actual.toString());
    }

    @Test
    public void getAllEventsTest() throws Exception {


//        this.mockMvc.perform(MockMvcRequestBuilders
//                .post("/createEvent")
//                .content(asJsonSting(this.event))
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON));

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/getallevents")
                //  .content(asJsonSting(this.event))
                //.contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].eventName").value("Graduation"));


    }

    @Test
    public void getEventByIdTest() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/geteventbyid/{id}", 7)
                //  .content(asJsonSting(this.event))
                //.contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.eventName").value("Wedding"));
    }

    @Test
    public void getEventByEventNameTest() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/geteventbyeventname")
                .param("eventName","Wedding")
                //  .content(asJsonSting(this.event))
                //.contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
//                .andExpect(MockMvcResultMatchers.jsonPath("$.eventName").value("Wedding"));
    }

    @Test
    public void updateEventTest() throws Exception {
        this.event.setEventName("Wedding");
        this.event.setId(11);
        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/updateevent")
                .content(asJsonSting(this.event))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                //  .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.eventName").value("Wedding"));
    }

    @Test
    public void deletEventTest() throws Exception {

        this.event.setId(11);
        this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/deleteevent")
                .content(asJsonSting(this.event))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted());
        // .andExpect(MockMvcResultMatchers.jsonPath("$.eventName").value("Graduation"));

    }

    @Test
    public void deletEventByIdTest() throws Exception {


        this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/deleteevent/{id}", 10)
                //.content(asJsonSting(this.event))
                // .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted());

    }

    private String asJsonSting(Event event) {

        try {
            return new ObjectMapper().writeValueAsString(event);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
