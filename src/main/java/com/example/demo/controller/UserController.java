package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.User;
import com.example.demo.service.UserServiceImpl;

@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping(value = "/insert")
    public ResponseEntity<?> insertUser(@RequestBody User user){
        try {
            User userInserted = userServiceImpl.insertUser(user);
            return ResponseEntity.ok(userInserted);
        } catch (Exception err) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, err.getMessage());
        }
    }

    @GetMapping(value = "/get")
    public ResponseEntity<?> getUsers(){
        try {
            List<User> users = userServiceImpl.listUsers();
            return ResponseEntity.ok(users);
        } catch (Exception err) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, err.getMessage());
        }
    }
}
