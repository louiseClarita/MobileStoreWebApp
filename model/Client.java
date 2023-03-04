package com.example.webapp.model;
	import org.bson.types.ObjectId;
	import org.springframework.data.annotation.Id;
	import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Client")
	public class Client {
	    @Id
	    private ObjectId client;
	    private String client_firstname;
	    private String client_lastname;
	    private String client_email;
	    private String client_phone_number;
	    private String client_address;
	    private String client_region;
	    
	    
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
	
	    
}
	
