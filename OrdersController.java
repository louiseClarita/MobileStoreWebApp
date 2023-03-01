package com.example.mobileStoreWebApp;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.mobileStoreWebApp.Model.Orders;
import com.example.mobileStoreWebApp.Model.Product;
import com.example.mobileStoreWebApp.repository.OrdersRepository;
import com.example.mobileStoreWebApp.repository.ProductRepository;
import com.example.mobileStoreWebApp.repository.SpecsRepository;

@Controller
public class OrdersController {

	@Autowired
	private SpecsRepository specsRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private OrdersRepository orderRepository;
	@Autowired
	private MongoTemplate mongoTemplate;

	
	ObjectId orderid;
	
	
	@PostMapping("/order/submit/{id}")
	public String addToCart(@PathVariable("id") String id, Model model,Orders order,BindingResult result) {
		System.out.println("Posted .....");
		if (result.hasErrors()) {
            order.set_id(new ObjectId(id));
            System.out.println("Entered if");
            return "CheckOut";
            
        }
		
		 Orders ordss = orderRepository.findById(new ObjectId(id))
	 	    		.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + orderid));
		//System.out.println("RESULT BINDING"+ result.toString());
		ordss.setStatus_code("Submitted");
		ordss.setRegion_code(order.getRegion_code());
		ordss.setOrders_address(order.getOrders_address());
		ordss.setClient(order.getClient());
		
		System.out.println(ordss);
        //order.set_id(new ObjectId(id));
       
        System.out.println("Saving ====================");
        System.out.println(orderRepository.save(ordss));
       // model.addAttribute("specs", specsRepository.findAll());
        return "redirect:/specs";
	}
	
	//hayde aal submit
	@GetMapping("/order/update/{id}")
	public String addToCart2(@PathVariable("id") String id, Model model,Orders order,BindingResult result) {
		System.out.println("gott .....");
		if (result.hasErrors()) {
            order.set_id(new ObjectId(id));
            System.out.println("Entered if");
            return "redirect:/specs";
            
        }
		Orders ordss = orderRepository.findById(new ObjectId(id))
 	    		.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + orderid));
        //System.out.println();
        //Orders ord = orderRepository.save(order);
		
		System.out.println(ordss.getProducts());
		model.addAttribute("ListOfProducts",ordss.getProducts());
	    
        model.addAttribute("order",ordss);
		return "CheckOut.html";
	}
	
	
}
