package com.example.mobileStoreWebApp.Model;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Restocking")
public class Restocking {

	@Id
	private ObjectId restocking;
	
	private String restocking_date;
	private String restocking_quantity;
	
	//Foreign Keys
	private ObjectId specs;

	public ObjectId getRestocking() {
		return restocking;
	}

	public void setRestocking(ObjectId restocking) {
		this.restocking = restocking;
	}

	public String getRestocking_date() {
		return restocking_date;
	}

	public void setRestocking_date(String restocking_date) {
		this.restocking_date = restocking_date;
	}

	public String getRestocking_quantity() {
		return restocking_quantity;
	}

	public void setRestocking_quantity(String restocking_quantity) {
		this.restocking_quantity = restocking_quantity;
	}

	public ObjectId getSpecs() {
		return specs;
	}

	public void setSpecs(ObjectId specs) {
		this.specs = specs;
	}

	@Override
	public String toString() {
		return "Restocking [restocking=" + restocking + ", restocking_date=" + restocking_date
				+ ", restocking_quantity=" + restocking_quantity + ", specs=" + specs + "]";
	}

	public Restocking(String restocking_date, String restocking_quantity, ObjectId specs) {
		super();
		this.restocking_date = restocking_date;
		this.restocking_quantity = restocking_quantity;
		this.specs = specs;
	}
	
	
	
	
}
