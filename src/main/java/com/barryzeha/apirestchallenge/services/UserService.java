package com.barryzeha.apirestchallenge.services;

import com.barryzeha.apirestchallenge.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<User> saveUser(User user);
    ResponseEntity<User> updateUser(User user);
    ResponseEntity<String> deleteUser(String userId);
    List<User >getAllUsers();
    ResponseEntity<User> getUserById(String id);
    ResponseEntity<User> getUserByUsername(String name);
    User checkUserNameAndPassword(String username, String password);
}
