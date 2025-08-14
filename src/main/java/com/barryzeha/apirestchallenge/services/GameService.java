package com.barryzeha.apirestchallenge.services;

import com.barryzeha.apirestchallenge.model.VideoGame;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface GameService {
    List<VideoGame> getAllGames();
    VideoGame getGameById(String id);
    ResponseEntity<List<VideoGame>> getGameByDeveloper(String developer);
    ResponseEntity<VideoGame> registerNewGame(VideoGame game);
    ResponseEntity<VideoGame> updateGame(VideoGame game);
    ResponseEntity<String> deleteGame(String id);
}
