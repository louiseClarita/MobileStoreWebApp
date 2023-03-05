package com.example.mobileStoreWebApp.Model;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;

@Document(collection = "Client")
public class Client {

	@Override
	public String toString() {
		return "Client [client=" + client + ", client_firstname=" + client_firstname + ", client_lastname="
				+ client_lastname + ", client_email=" + client_email + ", client_phone_number=" + client_phone_number
				+ ", client_address=" + client_address + ", client_region=" + client_region + "]";
	}
	@Id
	private ObjectId client;
	
	private String client_firstname;
	private String client_lastname;

	@Indexed(unique = true)
	private String client_email;
	
	private String client_phone_number;
	private String client_address;
	private String client_region;
	
	
	//Getters and Setters
	public ObjectId getClient() {
		return client;
	}
	public void setClient(ObjectId client) {
		client = client;
	}
	public String getClient_firstname() {
		return client_firstname;
	}
	public void setClient_firstname(String client_firstname) {
		this.client_firstname = client_firstname;
	}
	public String getClient_lastname() {
		return client_lastname;
	}
	public void setClient_lastname(String client_lastname) {
		this.client_lastname = client_lastname;
	}
	public String getClient_email() {
		return client_email;
	}
	public void setClient_email(String client_email) {
		this.client_email = client_email;
	}
	public String getClient_phone_number() {
		return client_phone_number;
	}
	public void setClient_phone_number(String client_phone_number) {
		this.client_phone_number = client_phone_number;
	}
	public String getClient_address() {
		return client_address;
	}
	public void setClient_address(String client_address) {
		this.client_address = client_address;
	}
	public String getClient_region() {
		return client_region;
	}
	public void setClient_region(String client_region) {
		this.client_region = client_region;
	}
	public Client(String client_firstname, String client_lastname, String client_email,
			String client_phone_number, String client_address, String client_region) {
		super();
	
		this.client_firstname = client_firstname;
		this.client_lastname = client_lastname;
		this.client_email = client_email;
		this.client_phone_number = client_phone_number;
		this.client_address = client_address;
		this.client_region = client_region;
	}
	
	
	
	
}
