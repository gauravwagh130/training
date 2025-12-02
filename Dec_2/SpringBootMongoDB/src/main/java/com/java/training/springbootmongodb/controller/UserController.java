package com.java.training.springbootmongodb.controller;

import com.java.training.springbootmongodb.model.User;
import com.java.training.springbootmongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public User addUser(@RequestBody User u) {
        return service.saveUser(u);
    }

    @GetMapping
    public List<User> getUsers() {
        return service.getAllUsers();
    }
}
