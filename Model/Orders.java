package com.example.mobileStoreWebApp.Model;

import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Orders")
public class Orders {

	@Id
    private ObjectId _id;
    
    private String orders_createdon;
    private String orders_amount;
    private String orders_address;
    private String orders_delivereddate;
    private String orders_reason;
    //This should be a foreign key
    private String region_code;
    
    //Foreign Keys
    private String status_code;
    private String client;
	private String employee;
	private List<org.bson.Document> products;
	
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId orders) {
		this._id = orders;
	}
	public String getOrders_createdon() {
		return orders_createdon;
	}
	public void setOrders_createdon(String orders_createdon) {
		this.orders_createdon = orders_createdon;
	}
	public String getOrders_amount() {
		return orders_amount;
	}
	public void setOrders_amount(String orders_amount) {
		this.orders_amount = orders_amount;
	}
	public String getOrders_address() {
		return orders_address;
	}
	public void setOrders_address(String orders_address) {
		this.orders_address = orders_address;
	}
	public String getOrders_delivereddate() {
		return orders_delivereddate;
	}
	public void setOrders_delivereddate(String orders_delivereddate) {
		this.orders_delivereddate = orders_delivereddate;
	}
	public String getOrders_reason() {
		return orders_reason;
	}
	public void setOrders_reason(String orders_reason) {
		this.orders_reason = orders_reason;
	}
	public String getRegion_code() {
		return region_code;
	}
	public void setRegion_code(String region_code) {
		this.region_code = region_code;
	}
	

	
	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	public List<org.bson.Document> getProducts() {
		return products;
	}
	public void setProducts(List<org.bson.Document> p) {
		this.products = p;
	}

	public String getStatus_code() {
		return status_code;
	}
	public void setStatus_code(String status_code) {
		this.status_code = status_code;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public Orders() {}
	@Override
	public String toString() {
		return "Orders [orders=" + _id + ", orders_createdon=" + orders_createdon + ", orders_amount="
				+ orders_amount + ", orders_address=" + orders_address + ", orders_delivereddate="
				+ orders_delivereddate + ", orders_reason=" + orders_reason + ", region_code=" + region_code
				+ ", status_code=" + status_code + ", client=" + client + ", employee=" + employee + ", products="
				+ products + "]";
	}
	
	
}
