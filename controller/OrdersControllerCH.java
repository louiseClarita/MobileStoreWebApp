package com.example.webapp.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.webapp.model.OrdersCH;
import com.example.webapp.model.ProductCH;
import com.example.webapp.model.Type;
import com.example.webapp.repository.OrdersRepositoryCH;
import com.example.webapp.repository.ProductRepositoryCH;
import com.example.webapp.repository.SpecsRepositoryCH;
import com.example.webapp.repository.TypeRepository;

@Controller
public class OrdersControllerCH {

	@Autowired
	private SpecsRepositoryCH specsRepository;
	@Autowired
	private ProductRepositoryCH productRepository;
	@Autowired
	private OrdersRepositoryCH orderRepository;
	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private TypeRepository typeRepository;
	
	
	ObjectId orderid;
	
	
	@PostMapping("/order/submit/{id}")
	public String addToCart(@PathVariable("id") String id, Model model,OrdersCH order,BindingResult result) throws IOException, Exception {
		System.out.println("Posted .....");
		if (result.hasErrors()) {
            order.set_id(new ObjectId(id));
            System.out.println("Entered if");
            return "CheckOut";
            
        }
		
		OrdersCH ordss = orderRepository.findById(new ObjectId(id))
	 	    		.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + orderid));
		//System.out.println("RESULT BINDING"+ result.toString());
		ordss.setStatus_code("Submitted");
		ordss.setRegion_code(order.getRegion_code());
		ordss.setOrders_address(order.getOrders_address());
		ordss.setClient(order.getClient());
		ordss.setClientName(order.getClientName());
		System.out.println("orderid"+ order.get_id()+ "id passed" + id);
		System.out.println(ordss);
        //order.set_id(new ObjectId(id));
         
		//GoogleCredentials googleCredentials = new GoogleCredentials();
		AppsScriptContoller appsScript = new AppsScriptContoller();
		appsScript.sendemail(ordss.getClient(),ordss.getClientName());
		
		
		
        System.out.println("Saving ====================");
        System.out.println(orderRepository.save(ordss));
       // model.addAttribute("specs", specsRepository.findAll());
        return "redirect:/specs";
	}
	
	//hayde aal submit
	@GetMapping("/order/update/{id}")
	public String addToCart2(@PathVariable("id") String id, Model model,OrdersCH order,BindingResult result) {
		System.out.println("gott .....");
		if (result.hasErrors()) {
            order.set_id(new ObjectId(id));
            System.out.println("Entered if");
            return "redirect:/specs";
            
        }
		   List<Type> listOfTypes = new ArrayList<>();
		   listOfTypes = typeRepository.findAll();
	        model.addAttribute("types", listOfTypes);
		OrdersCH ordss = orderRepository.findById(new ObjectId(id))
 	    		.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + orderid));
        //System.out.println();
        //Orders ord = orderRepository.save(order);
		
		System.out.println(ordss.getProducts());
		model.addAttribute("ListOfProducts",ordss.getProducts());
	    
        model.addAttribute("order",ordss);
		return "CheckOut.html";
	}
	
	
	 
	
}
