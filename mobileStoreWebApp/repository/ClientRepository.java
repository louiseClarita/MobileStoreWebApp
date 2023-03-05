package com.example.mobileStoreWebApp.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mobileStoreWebApp.Model.Client;
import org.bson.types.ObjectId;

@Repository
public interface ClientRepository extends MongoRepository<Client,ObjectId>{

}
