package com.barryzeha.apirestchallenge.controllers;

import com.barryzeha.apirestchallenge.model.VideoGame;
import com.barryzeha.apirestchallenge.repository.VideoGameRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/games")
public class GameController {

    @Autowired
    private VideoGameRepository gameRepo;

    @GetMapping()
    public List<VideoGame> getAllGames(){
        return gameRepo.findAll();
    }
    @GetMapping("/{id}")
    public VideoGame getGameById(@PathVariable String id){
        //return gameRepo.findGameById(new ObjectId(id));
        return gameRepo.findById(id).orElse(null);
    }

}
