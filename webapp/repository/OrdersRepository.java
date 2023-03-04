package com.example.webapp.repository;
import com.example.webapp.model.Orders;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends MongoRepository<Orders, String>{

	@Query("{ orders_amount : { $ne : null }, orders_address : { $ne : null } }")
    List<Orders> findAllNotNull();

}