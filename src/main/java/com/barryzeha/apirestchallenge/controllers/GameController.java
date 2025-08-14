package com.barryzeha.apirestchallenge.controllers;

import com.barryzeha.apirestchallenge.model.VideoGame;
import com.barryzeha.apirestchallenge.repository.VideoGameRepository;
import com.barryzeha.apirestchallenge.services.GameService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/games")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService){
        this.gameService = gameService;
    }

    @GetMapping()
    public List<VideoGame> getAllGames(){
        return gameService.getAllGames();
    }
    @GetMapping("/{id}")
    public VideoGame getGameById(@PathVariable String id){
        return gameService.getGameById(id);
    }
    @GetMapping("/developer/{developer}")
    public ResponseEntity<List<VideoGame>> getGameByDeveloper(@PathVariable String developer){
       return gameService.getGameByDeveloper(developer);
    }
    @PostMapping("/create")
    public ResponseEntity<VideoGame> registerNewGame(@RequestBody VideoGame game){
       return gameService.registerNewGame(game);
    }
    @PutMapping("/update")
    public ResponseEntity<VideoGame> updatedGame(@RequestBody VideoGame game){
        return gameService.updateGame(game);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteGame(@PathVariable String id){
        return gameService.deleteGame(id);
    }
}
