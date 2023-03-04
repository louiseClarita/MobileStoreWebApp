package com.example.webapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.webapp.model.Orders;
import com.example.webapp.model.ProductCH;
import com.example.webapp.repository.OrdersRepository;
import com.example.webapp.repository.ProductRepository;
import com.example.webapp.repository.StatusRepository;

@Controller
public class ProductController {

	  @Autowired
	  private ProductRepository productRepository;
	  
	  @GetMapping("/products")
	  public String getAll(Model model) {
	    try {
	      List<ProductCH> products = new ArrayList<ProductCH>(); 
	    
	     // productRepository.findAll().forEach(products::add);
	     
	      
	      System.out.println("ordersTest "+ products.toArray());
	      model.addAttribute("orders", products);
	    } catch (Exception e) {
	      model.addAttribute("message", e.getMessage());
	    }

	    return "ProductCM";
	  }
	  
	  
	  
}
