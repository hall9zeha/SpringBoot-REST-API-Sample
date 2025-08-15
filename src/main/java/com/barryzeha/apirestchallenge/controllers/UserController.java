package com.barryzeha.apirestchallenge.controllers;

import com.barryzeha.apirestchallenge.model.User;
import com.barryzeha.apirestchallenge.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping()
    public List<User> helloUsers(){
        return userService.getAllUsers();
    }
}
