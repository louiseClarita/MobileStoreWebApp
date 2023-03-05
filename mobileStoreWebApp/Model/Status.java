package com.example.mobileStoreWebApp.Model;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Status")
public class Status {

	
	@Id
	private ObjectId status_code;
	private String status_desc;
	
	@Override
	public String toString() {
		return "Status [status_code=" + status_code + ", status_desc=" + status_desc + "]";
	}
	
	
}
