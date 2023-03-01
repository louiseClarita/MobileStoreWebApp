package com.example.mobileStoreWebApp.repository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mobileStoreWebApp.Model.Status;

public interface StatusRepository extends MongoRepository<Status,ObjectId>{

}
