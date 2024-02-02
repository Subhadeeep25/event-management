package com.project.EventManagement.exception;

public class EventsNotFoundException extends RuntimeException{
    public EventsNotFoundException(Long id){
        super("Could not find event/user: "+ id);
    }
}
