package com.project.EventManagement.service;


import com.project.EventManagement.model.Events;
import com.project.EventManagement.model.User;
import com.project.EventManagement.repository.EventRepository;
import com.project.EventManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    @Transactional
    public void saveEventWithUser(Events event, User user) {
        userRepository.save(user);
        event.setUserId(user.getId());
        eventRepository.save(event);
    }
    public List<Events> getRecordsByUserId(Long userId){
        return eventRepository.findByUserId(userId);
    }
}
