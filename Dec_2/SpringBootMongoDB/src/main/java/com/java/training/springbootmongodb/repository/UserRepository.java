package com.java.training.springbootmongodb.repository;

import com.java.training.springbootmongodb.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
