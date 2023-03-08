package com.example.webapp.controller;

import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.webapp.model.OrdersCH;
import com.example.webapp.repository.OrdersRepositoryCH;

@RestController
public class LocationController {
	 @Autowired
	  private OrdersRepositoryCH orderRepository;
	 
	 @PostMapping("/save-order")
	  public void saveLocation(@RequestBody Map<String, String> location,RedirectAttributes redirAttrs) {
	      double lat = Double.parseDouble(location.get("lat"));
	      double lng = Double.parseDouble(location.get("lng"));
	      String orderid = location.get("id");
	      System.out.println("orderid" + orderid);
	     OrdersCH ord =  orderRepository.findById(new ObjectId(orderid)).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" +orderid));
	    ord.setOrders_latitude(lat);
	    ord.setOrders_longitude(lng);  
	    orderRepository.save(ord);
	     System.out.println("X("+String.valueOf(lat)+" , "+ String.valueOf(lng));
	    redirAttrs.addFlashAttribute("message", "Location Added successfully!");
	     
	  }
	 
}
