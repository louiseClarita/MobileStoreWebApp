package com.example.demo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Order")
public class Order {
    @Id
    private ObjectId id;
    private String lat;
    private String lng;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String product;
    private String quantity;
    private String color;
 
    

    @Override
	public String toString() {
		return "Order [id=" + id + ", lat=" + lat + ", lng=" + lng + ", name=" + name + ", address=" + address
				+ ", phone=" + phone + ", email=" + email + ", product=" + product + ", quantity=" + quantity
				+ ", color=" + color + "]";
	}

	
    public Order(String lat, String lng, String name, String address, String phone, String email,
			String product, String quantity, String color) {
		super();

		this.lat = lat;
		this.lng = lng;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.product = product;
		this.quantity = quantity;
		this.color = color;
	
	}


	// getters and setters

	public ObjectId getId() {
		return id;
	}
    

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}
    
    
}