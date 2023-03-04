package com.example.webapp.repository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.webapp.model.ProductCH;

public interface ProductRepositoryCH extends MongoRepository<ProductCH,ObjectId> {

	
	
	ProductCH findOneBySpecs(String specs);
}
