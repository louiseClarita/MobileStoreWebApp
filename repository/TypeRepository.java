package com.example.webapp.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.webapp.model.Type;

public interface TypeRepository extends MongoRepository<Type,String>{

}