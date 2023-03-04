package com.example.webapp.repository;
import com.example.webapp.model.Status;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends MongoRepository<Status, String>{

}
