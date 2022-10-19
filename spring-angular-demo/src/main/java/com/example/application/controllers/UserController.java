package com.example.application.controllers;

import com.example.application.entities.Person;
import com.example.application.repositories.UserRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<Person> getUsers() {
        return (List<Person>) userRepository.findAll();
    }

    @PostMapping("/users")
    void addUser(@RequestBody Person user) {
        userRepository.save(user);
    }
    
}