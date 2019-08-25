package com.GradEvent.gradEvent.respository;

import com.GradEvent.gradEvent.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

//    @Query(value = "SELECT * FROM event e WHERE e.eventName = ?eventName", nativeQuery = true)
    List<Event> findEventByEventName( String eventName);
}
