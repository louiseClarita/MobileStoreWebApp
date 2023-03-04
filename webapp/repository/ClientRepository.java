package com.example.webapp.repository;
import com.example.webapp.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ClientRepository extends MongoRepository<Client, String>{

}
