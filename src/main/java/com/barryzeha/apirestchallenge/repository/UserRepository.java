package com.barryzeha.apirestchallenge.repository;

import com.barryzeha.apirestchallenge.model.User;
import com.barryzeha.apirestchallenge.model.VideoGame;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    //We creating a custom query for get a user by userName
    @Query(value = "{ delete: { $ne: true } }")
    List<User> findAllUsers();

    @Query(value = "{username: '?0'}")
    Optional<User> findUserByUserName(String username);
}
