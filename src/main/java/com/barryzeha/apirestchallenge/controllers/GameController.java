package com.barryzeha.apirestchallenge.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
    @GetMapping("/games")
    public String helloGames(){
        return "getting all games";
    }
}
