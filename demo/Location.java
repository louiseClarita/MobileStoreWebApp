package com.example.demo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Location")
public class Location {
    @Id
    private ObjectId id;
    private double lat;
    private double lng;

    public Location(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }
    // getters and setters

	public ObjectId getId() {
		return id;
	}
    

	public void setId(ObjectId id) {
		this.id = id;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}
    
    
}