package com.example.webapp.model;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Specs")
public class SpecsCH {

		@Id
		private ObjectId _id;
		
		private String specs_price;
		
		private String specs_barcode;
		private String specs_supprice;
		private String specs_availability;
		private String specs_image;
		private String specs_storage;
		private String specs_model;
		private String specs_color;
		private String specs_type;
		private String specs_url;
		private String specs_brand;
		private String specs_colorhex;
		

		public String getSpecs_brand() {
			return specs_brand;
		}
		public void setSpecs_brand(String specs_brand) {
			this.specs_brand = specs_brand;
		}
		public ObjectId get_id() {
			return _id;
		}
		public void set_id(ObjectId _id) {
			this._id = _id;
		}
		public String getSpecs_price() {
			return specs_price;
		}
		public void setSpecs_price(String specs_price) {
			this.specs_price = specs_price;
		}
		public String getSpecs_barcode() {
			return specs_barcode;
		}
		public void setSpecs_barcode(String specs_barcode) {
			this.specs_barcode = specs_barcode;
		}
		public String getSpecs_supprice() {
			return specs_supprice;
		}
		public void setSpecs_supprice(String specs_supprice) {
			this.specs_supprice = specs_supprice;
		}
		public String getSpecs_availability() {
			return specs_availability;
		}
		public void setSpecs_availability(String specs_availability) {
			this.specs_availability = specs_availability;
		}
		public String getSpecs_image() {
			return specs_image;
		}
		public void setSpecs_image(String specs_image) {
			this.specs_image = specs_image;
		}
		public String getSpecs_storage() {
			return specs_storage;
		}
		public void setSpecs_storage(String specs_storage) {
			this.specs_storage = specs_storage;
		}
		public String getSpecs_model() {
			return specs_model;
		}
		public void setSpecs_model(String specs_model) {
			this.specs_model = specs_model;
		}
		public String getSpecs_color() {
			return specs_color;
		}
		public void setSpecs_color(String specs_color) {
			this.specs_color = specs_color;
		}
		public String getSpecs_type() {
			return specs_type;
		}
		public void setSpecs_type(String specs_type) {
			this.specs_type = specs_type;
		}
		
		public String getSpecs_url() {
			return specs_url;
		}
		public void setSpecs_url(String specs_url) {
			this.specs_url = specs_url;
		}

		
		public SpecsCH() {
		    // No-argument constructor
		}
		@Override
		public String toString() {
			return "Specs [_id=" + _id + ", specs_price=" + specs_price + ", specs_barcode=" + specs_barcode
					+ ", specs_supprice=" + specs_supprice + ", specs_availability=" + specs_availability + ", specs_image="
					+ specs_image + ", specs_storage=" + specs_storage + ", specs_model=" + specs_model + ", specs_color="
					+ specs_color + ", specs_type=" + specs_type + ", specs_url=" + specs_url + ", specs_brand="
					+ specs_brand + ", specs_colorhex=" + specs_colorhex + "]";
		}
		public String getSpecs_colorhex() {
			return specs_colorhex;
		}
		public void setSpecs_colorhex(String specs_colorhex) {
			this.specs_colorhex = specs_colorhex;
		}


		
		
	}
