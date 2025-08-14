package com.barryzeha.apirestchallenge.repository;

import com.barryzeha.apirestchallenge.model.VideoGame;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VideoGameRepository  extends MongoRepository<VideoGame, String> {
/*    @Query(value = "{id:'?0'}", fields = "{'_id': 1}")
    Optional<VideoGame> findGameById(ObjectId id);*/

    //Optional<T> en Java es un contenedor que puede o no contener un valor.
    // Y su objetivo principal es evitar el uso de null directamente y prevenir el famoso NullPointerException.
    @Query(value = "{developer: '?0'}")
    Optional<List<VideoGame>> findByDeveloper(String developer);
}
