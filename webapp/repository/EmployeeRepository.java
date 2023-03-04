package com.example.webapp.repository;


import com.example.webapp.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
	
}
