package com.example.webapp.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Type")
public class Type {

	@Id
	private ObjectId _id;
	
	private String type_name;

	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getType_name() {
		return type_name;
	}




	public void setType_name(String type_name) {
		this.type_name = type_name;
	}




	@Override
	public String toString() {
		return "Type [_id=" + _id + ", type_name=" + type_name + "]";
	}
	
	
	
	
	
	
	
	
}