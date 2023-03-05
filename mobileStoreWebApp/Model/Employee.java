package com.example.mobileStoreWebApp.Model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Employee")
public class Employee {

	
	
	@Override
	public String toString() {
		return "Employee [employee=" + employee + ", employee_name=" + employee_name + ", employee_lastname="
				+ employee_lastname + ", employee_number=" + employee_number + ", employee_orders=" + employee_orders
				+ "]";
	}
	@Id
	private ObjectId employee;
	private String employee_name;
	private String employee_lastname;
	
	@Indexed(unique = true)
	private String employee_number;
	private String employee_orders;
	public ObjectId getEmployee() {
		return employee;
	}
	public void setEmployee(ObjectId employee) {
		this.employee = employee;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getEmployee_lastname() {
		return employee_lastname;
	}
	public void setEmployee_lastname(String employee_lastname) {
		this.employee_lastname = employee_lastname;
	}
	public String getEmployee_number() {
		return employee_number;
	}
	public void setEmployee_number(String employee_number) {
		this.employee_number = employee_number;
	}
	public String getEmployee_orders() {
		return employee_orders;
	}
	public void setEmployee_orders(String employee_orders) {
		this.employee_orders = employee_orders;
	}
	public Employee(String employee_name, String employee_lastname, String employee_number, String employee_orders) {
		super();
		this.employee_name = employee_name;
		this.employee_lastname = employee_lastname;
		this.employee_number = employee_number;
		this.employee_orders = employee_orders;
	}
	
	
	
}
