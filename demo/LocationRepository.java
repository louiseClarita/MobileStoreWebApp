package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;
//import com.example.models.Employee;

public interface LocationRepository extends MongoRepository<Location,String>{

	
	
}
