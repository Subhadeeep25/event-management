package com.project.EventManagement.controller;

import com.project.EventManagement.exception.EventsNotFoundException;
import com.project.EventManagement.model.Events;
import com.project.EventManagement.model.User;
import com.project.EventManagement.repository.EventRepository;
import jdk.jfr.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventsController {
    @Autowired
    private EventRepository eventRepository;
     @PostMapping("/events/add-new")
     Events newEvents(@RequestBody Events newEvent){
         return eventRepository.save(newEvent);
     }

    @GetMapping("/events")
    List<Events> getAllEvents(){
        return eventRepository.findAll();
    }
    @GetMapping("/events/{id}")
    Events getEventById(@PathVariable Long id){
         return eventRepository.findById(id).orElseThrow(()->new EventsNotFoundException(id));
    }
    @PutMapping("events/{id}")
    Events updateEvents(@RequestBody Events newEvents,@PathVariable Long id){
        return eventRepository.findById(id).map(events -> {
            events.setName(newEvents.getName());
            events.setType(newEvents.getType());
            events.setEventDate(newEvents.getEventDate());
            events.setPackage(newEvents.getPackage());
            events.setServices(newEvents.getServices());
            events.setUserId(newEvents.getUserId());
            events.setManagedBy(newEvents.getManagedBy());
            return eventRepository.save(events);
        }).orElseThrow(()->new EventsNotFoundException(id));
    }

    @DeleteMapping("events/{id}")
    Events deleteEvents(@PathVariable Long id){
        Events delevents=eventRepository.findById(id).orElseThrow(()->new EventsNotFoundException(id));
        eventRepository.delete(delevents);
        return delevents;
    }

}
