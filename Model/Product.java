package com.example.mobileStoreWebApp.Model;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "P¨roduct")
public class Product {

	@Id
	private ObjectId _id;
	
	
	private String product_imei;
	private String product_isavailable;

	//Foreign Key
	private ObjectId order;
	private String specs;
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId product) {
		this._id = product;
	}
	public String getProduct_imei() {
		return product_imei;
	}
	public void setProduct_imei(String product_imei) {
		this.product_imei = product_imei;
	}
	public String getProduct_isavailable() {
		return product_isavailable;
	}
	public void setProduct_isavailable(String product_isavailable) {
		this.product_isavailable = product_isavailable;
	}
	public ObjectId getOrder() {
		return order;
	}
	public void setOrder(ObjectId order) {
		this.order = order;
	}
	public String getSpecs() {
		return specs;
	}
	public void setSpecs(String specs) {
		this.specs = specs;
	}
	@Override
	public String toString() {
		return "Product [_id=" + _id + ", product_imei=" + product_imei + ", product_isavailable="
				+ product_isavailable + ", order=" + order + ", specs=" + specs + "]";
	}
	public Product(String product_imei, String product_isavailable, ObjectId order, String specs) {
		super();
		this.product_imei = product_imei;
		this.product_isavailable = product_isavailable;
		this.order = order;
		this.specs = specs;
	}
	public Product() {
		
	}
	
	
	
	
}
