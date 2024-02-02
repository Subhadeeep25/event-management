package com.project.EventManagement.repository;

import com.project.EventManagement.model.Events;
import com.project.EventManagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

}
