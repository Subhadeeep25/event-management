package com.project.EventManagement.controller;

import com.project.EventManagement.exception.EventsNotFoundException;
import com.project.EventManagement.model.User;
import com.project.EventManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/user/add-new")
    User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }
    @GetMapping("/user")
    List<User>getAllUsers(){
        return userRepository.findAll();
    }
    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id){
        return userRepository.findById(id).orElseThrow(()->new EventsNotFoundException(id));
    }
    @PutMapping("user/{id}")
    User updateUser(@RequestBody User newUser,@PathVariable Long id){
        return userRepository.findById(id).map(user -> {
            user.setName(newUser.getName());
            user.setEmail(newUser.getEmail());
            user.setPhoneNumber(newUser.getPhoneNumber());
            user.setUpiId(newUser.getUpiId());
            return userRepository.save(user);
        }).orElseThrow(()->new EventsNotFoundException(id));
    }

    @DeleteMapping("user/{id}")
    User deleteUser(@PathVariable Long id){
        User deluser=userRepository.findById(id).orElseThrow(()->new EventsNotFoundException(id));
        userRepository.delete(deluser);
        return deluser;

    }

}
