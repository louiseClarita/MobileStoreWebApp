package com.example.webapp;

import org.bson.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@SpringBootApplication
public class MobileStoreWebappV2Application {

	public static void main(String[] args) {
		SpringApplication.run(MobileStoreWebappV2Application.class, args);
		
		
		
		ConnectionString connectionString = new ConnectionString("mongodb+srv://Clarita:Hawat@atlascluster.9gfb3cx.mongodb.net/?retryWrites=true&w=majority");
		MongoClientSettings settings = MongoClientSettings.builder()
		        .applyConnectionString(connectionString)
		        .build();
		MongoClient mongoClient = MongoClients.create(settings);
		MongoDatabase database = mongoClient.getDatabase("test");
		
		
		MongoCollection<Document> test = database.getCollection("test");
		
		Document employee = new Document();
		employee.append("fname", "Main");
		employee.append("lname", "Test");
		test.insertOne(employee);	
	}

}
