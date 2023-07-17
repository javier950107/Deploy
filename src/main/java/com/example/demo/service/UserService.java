package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;

@Service
public interface UserService {
    public User insertUser(User user);
    public List<User> listUsers();
    public User insert(User user);
}
