package com.project.EventManagement.repository;

import com.project.EventManagement.model.Events;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Events,Long> {
    List<Events> findByUserId(Long userId);

}
