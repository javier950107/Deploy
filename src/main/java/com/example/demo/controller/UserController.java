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
//import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/insert")
    public ResponseEntity<?> insertUser(@RequestBody User user){
        try {
            System.out.println(user);
            User userInserted = userServiceImpl.insertUser(user);
            return ResponseEntity.ok(userInserted);
        } catch (Exception err) {
            System.out.println(err);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, err.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getUsers(){
        try {
            List<User> users = userServiceImpl.listUsers();
            return ResponseEntity.ok(users);
        } catch (Exception err) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, err.getMessage());
        }
    }

    @GetMapping(value="/create")
    public ResponseEntity<?> getMethodName(@RequestBody String param) {
        System.out.println(param);
        User newUser = new User();
        newUser.setEmail("test");
        newUser.setName("Name");

        User userInserted = userServiceImpl.insert(newUser);

        return ResponseEntity.ok(userInserted);
    }
    
}
