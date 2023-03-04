package com.example.demo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Employee")
public class Employee {
	private ObjectId id;
	private String name;
	private String age;

	
	
	public Employee(ObjectId id, String name, String age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	
	}
	
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}

	
	
}
