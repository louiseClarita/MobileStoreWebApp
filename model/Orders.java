package com.example.webapp.model;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Orders")
public class  Orders {
    @Id
    private ObjectId orders;
    private String orders_createdon;
    private Double orders_amount;
    private String orders_address;
    private String orders_deliveredDate;
    private String orders_region;
    private String orders_reason;
    private String status_code;
    private String client;
    private String employee;
    
    public ObjectId getOrders() {
		return orders;
	}
	public void setOrders(ObjectId orders) {
		this.orders = orders;
	}
	public String getOrders_createdon() {
		return orders_createdon;
	}
	public void setOrders_createdon(String orders_createdon) {
		this.orders_createdon = orders_createdon;
	}
	public Double getOrders_amount() {
		return orders_amount;
	}
	public void setOrders_amount(Double orders_amount) {
		this.orders_amount = orders_amount;
	}
	public String getOrders_address() {
		return orders_address;
	}
	public void setOrders_address(String orders_address) {
		this.orders_address = orders_address;
	}
	public String getOrders_deliveredDate() {
		return orders_deliveredDate;
	}
	public void setOrders_deliveredDate(String orders_deliveredDate) {
		this.orders_deliveredDate = orders_deliveredDate;
	}
	public String getOrders_region() {
		return orders_region;
	}
	public void setOrders_region(String orders_region) {
		this.orders_region = orders_region;
	}
	public String getOrders_reason() {
		return orders_reason;
	}
	public void setOrders_reason(String orders_reason) {
		this.orders_reason = orders_reason;
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
	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	
    
    

}
