package com.barryzeha.apirestchallenge.services;

import com.barryzeha.apirestchallenge.model.VideoGame;
import com.barryzeha.apirestchallenge.repository.VideoGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GameServiceImpl implements GameService{

    private final  VideoGameRepository gameRepository;

    @Autowired
    public  GameServiceImpl(VideoGameRepository gameRepository){
        this.gameRepository = gameRepository;
    }
    @Override
    public List<VideoGame> getAllGames() {
        return gameRepository.findAll();
    }

    @Override
    public VideoGame getGameById(String id) {
        return gameRepository.findById(id).orElse(null);
    }

    @Override
    public ResponseEntity<List<VideoGame>> getGameByDeveloper(String developer) {
        return gameRepository.findByDeveloper(developer).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<VideoGame> registerNewGame(VideoGame game) {
        VideoGame savedGame = gameRepository.save(game);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGame);
    }

    @Override
    public ResponseEntity<VideoGame> updateGame(VideoGame game) {
        return gameRepository.findById(game.getId()).map(vGame->{
                game.setId(vGame.getId());
                game.setUpdatedAt(LocalDateTime.now().toString());
        VideoGame updatedGame = gameRepository.save(game);
        return ResponseEntity.ok(updatedGame);
    }
        ).orElseGet(()->ResponseEntity.notFound().build());

    }

    @Override
    public ResponseEntity<String> deleteGame(String id) {
        return gameRepository.findById(id).map(game->{
            gameRepository.delete(game);
            return ResponseEntity.ok("VideoGame deleted successfully");
        }).orElseGet(()->{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("VideoGame not found");
        });
    }
}
