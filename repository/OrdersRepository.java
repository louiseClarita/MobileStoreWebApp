package com.example.mobileStoreWebApp.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mobileStoreWebApp.Model.Orders;

public interface OrdersRepository extends MongoRepository<Orders,ObjectId>{

}
