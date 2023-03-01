package com.example.mobileStoreWebApp.repository;

import org.bson.types.ObjectId;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import com.example.mobileStoreWebApp.Model.Specs;
@Repository
public interface SpecsRepository extends MongoRepository<Specs,ObjectId>{

}
