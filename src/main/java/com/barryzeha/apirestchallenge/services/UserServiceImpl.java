package com.barryzeha.apirestchallenge.services;

import com.barryzeha.apirestchallenge.model.User;
import com.barryzeha.apirestchallenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepo;

    @Autowired
    public UserServiceImpl(UserRepository userRepo){
        this.userRepo = userRepo;
    }
    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(String id) {
        return null;
    }

    @Override
    public User getUserByUsername(String name) {
        return null;
    }

    @Override
    public User checkUserNameAndPassword(String username, String password) {
        return null;
    }
}
