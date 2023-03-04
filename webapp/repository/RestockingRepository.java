package com.example.webapp.repository;


import com.example.webapp.model.Restocking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestockingRepository extends MongoRepository<Restocking, String>{

}
