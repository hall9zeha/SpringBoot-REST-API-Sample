package com.barryzeha.apirestchallenge.services;

import com.barryzeha.apirestchallenge.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User >getAllUsers();
    User getUserById(String id);
    User getUserByUsername(String name);
    User checkUserNameAndPassword(String username, String password);
}
