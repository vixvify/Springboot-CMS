package com.myapp.cms.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.cms.entities.User;
import com.myapp.cms.services.AuthService;

@RestController
@RequestMapping("/api")
public class AuthController {
    private final AuthService authservice;

    public AuthController(AuthService service) {
        this.authservice = service;
    }

    @PostMapping("/auth/signup")
    public User createUser(@RequestBody User user) {
        return this.authservice.createUser(user);
    }

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return this.authservice.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public User getUserById(UUID id) {
        return this.authservice.getUserById(id);
    }

    @PutMapping("/user/{id}")
    public User updateUser(@RequestBody User user, UUID id) {
        return authservice.updateUser(user, id);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(UUID id) {
        this.authservice.deleteUser(id);
    }
}
