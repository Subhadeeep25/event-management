package com.project.EventManagement.service;

import com.project.EventManagement.model.Events; // Import Event class
import com.project.EventManagement.repository.EventRepository;
import com.project.EventManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List; // Import List class

public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    public void deleteUser(Long id) {
        // Find and delete associated events first
        List<Events> events = eventRepository.findByUserId(id);
        eventRepository.deleteAll(events);

        // Delete the user after deleting associated events
        userRepository.deleteById(id);
    }
}
