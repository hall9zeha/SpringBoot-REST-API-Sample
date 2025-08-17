package com.barryzeha.apirestchallenge.controllers;

import com.barryzeha.apirestchallenge.model.User;
import com.barryzeha.apirestchallenge.model.UserLogin;
import com.barryzeha.apirestchallenge.model.UserWithToken;
import com.barryzeha.apirestchallenge.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/id/{id}")
    public ResponseEntity<User>getUserById(@PathVariable String id){
        return userService.getUserById(id);
    }
    @GetMapping("/username/{username}")
    public ResponseEntity<User>getUserByUserName(@PathVariable String username){
        return userService.getUserByUsername(username);
    }
    @PostMapping("/login")
    public ResponseEntity<UserWithToken>login(@RequestBody UserLogin user){
        return userService.login(user);
    }
    @PostMapping("/register")
    public ResponseEntity<User>registerNewUser(@RequestBody User user){
        return userService.saveUser(user);
    }
    @PutMapping("/update")
    public ResponseEntity<User>updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
    @PostMapping("/delete/{id}")
    public ResponseEntity<String>deleteUser(@PathVariable String id){
        return userService.deleteUser(id);
    }
}
