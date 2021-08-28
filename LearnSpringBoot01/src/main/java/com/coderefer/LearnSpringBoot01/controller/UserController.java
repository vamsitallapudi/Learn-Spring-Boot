package com.coderefer.LearnSpringBoot01.controller;

import com.coderefer.LearnSpringBoot01.entity.User;
import com.coderefer.LearnSpringBoot01.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDaoService service;

    @GetMapping("/users")
    public List<User> retrieveUsers() {
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        return service.findOne(id);
    }

    @PostMapping("/users/create")
    public void createUser(@RequestBody User user) {
       User newUser = service.save(user);
    }
}
