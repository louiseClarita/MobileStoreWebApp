package com.example.webapp.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.webapp.model.Tutorial;



@Repository

public interface TutorialRepository extends MongoRepository<Tutorial, String> {
 
}
