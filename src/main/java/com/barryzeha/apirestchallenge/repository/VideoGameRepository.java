package com.barryzeha.apirestchallenge.repository;

import com.barryzeha.apirestchallenge.model.VideoGame;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.http.ResponseEntity;

public interface VideoGameRepository  extends MongoRepository<VideoGame, String> {
/*    @Query(value = "{id:'?0'}", fields = "{'_id': 1}")
    ResponseEntity<VideoGame> findGameById(ObjectId id);*/
}
