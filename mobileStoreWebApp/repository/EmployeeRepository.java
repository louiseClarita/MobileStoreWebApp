package com.example.mobileStoreWebApp.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mobileStoreWebApp.Model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee,ObjectId>{

}
