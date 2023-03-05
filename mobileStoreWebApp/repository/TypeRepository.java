package com.example.mobileStoreWebApp.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mobileStoreWebApp.Model.Type;

public interface TypeRepository extends MongoRepository<Type,ObjectId>{

}
