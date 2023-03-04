package com.example.webapp.repository;

import com.example.webapp.model.Specs;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecsRepository extends MongoRepository<Specs, String>{

}
