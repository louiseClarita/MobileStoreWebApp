package com.example.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.example.webapp.model.OrdersCH;
import com.example.webapp.model.ProductCH;
import com.example.webapp.model.SpecsCH;
import com.example.webapp.repository.OrdersRepositoryCH;
import com.example.webapp.repository.ProductRepositoryCH;
import org.springframework.data.mongodb.core.query.Query;

import com.example.webapp.repository.SpecsRepositoryCH;

@Controller
public class SpecsControllerCH {

	@Autowired
	private SpecsRepositoryCH specsRepository;
	@Autowired
	private ProductRepositoryCH productRepository;
	@Autowired
	private OrdersRepositoryCH orderRepository;
	@Autowired
	private MongoTemplate mongoTemplate;
	Document pr1;
	
	//ObjectId orderid;
	
	
	@GetMapping("/specs")
    public String viewHomePage( Model model) {
		System.out.println("Specs Step 1...");
		System.out.println(specsRepository.count());
		System.out.println(specsRepository.findAll());
        model.addAttribute("specs", specsRepository.findAll());

        return "productsClient";
    }
	
	@GetMapping("/specs/{id}")
    public String viewHomePage(@PathVariable("id") String id, Model model) {
		System.out.println("Specs Step 1...");
		System.out.println(specsRepository.count());
		System.out.println(specsRepository.findAll());
		Query getSpecs = new Query(Criteria.where("specs_availability").ne("0"));
	    
       // model.addAttribute("specs", specsRepository.findAll());
		model.addAttribute("specs",mongoTemplate.find(getSpecs,SpecsCH.class));
        if(!id.isEmpty()) {
        	System.out.println("ID IS"+id);
        	OrdersCH order1= orderRepository.findById(new ObjectId(id)).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        	model.addAttribute("order",order1);
        }else {
        	System.out.println("ID IS EMPTYYYYYYYYY");
        }
        return "productsClient3";
    }
	
	
	@GetMapping("/specs/addToCartEmpty/{id}")
	public String addToCart(@PathVariable("id") String id, Model model) {

		System.out.println("Entered");
		ObjectId _id =new ObjectId(id);
	    SpecsCH spec = specsRepository.findById(_id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + _id));
	 
	    System.out.println("Specs chosen");
	    System.out.println(spec.toString());
	                     //Orders(String orders_createdon, String orders_amount, String orders_address, String orders_delivereddate,
		//String orders_reason, String region_code, ObjectId status_code, ObjectId client, ObjectId employee)
	    Query getProduct = new Query(Criteria.where("specs").is(spec.get_id().toString()).and("product_isavailable").is("1"));
	    ProductCH prodAv = mongoTemplate.findOne(getProduct,ProductCH.class);
	    System.out.println("Product Availabless2 = ");
	    System.out.println(prodAv.toString());
	    
	    
	    
	     //if(Objects.equals(this.orderid,null)) {
	    System.out.println("Creatiing new Order");
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	    LocalDateTime now = LocalDateTime.now();  
	    OrdersCH ord = new OrdersCH();
	    ord.setOrders_createdon(now.toString());
	    ord.setStatus_code("Bucket");
	    List<Document> list = new ArrayList<Document>();
	    pr1 = new Document("_id",prodAv.get_id().toString());
	    pr1.append("product_price", spec.getSpecs_price());
	    pr1.append("product_name", spec.getSpecs_model());
	    list.add(pr1);
	    ord.setProducts(list);
	    ord.setOrders_amount(spec.getSpecs_price());
	    System.out.println("order : ");
	    System.out.println(ord.toString());
	    
	    System.out.println("Saving...");

	    OrdersCH order = orderRepository.save(ord);
	    System.out.println(order);
	    // order.get_id();
	    System.out.println("model.addAttribute(\"listOfProducts\", ord.getProducts())");
	    model.addAttribute("listOfProducts", pr1);
	    System.out.println("model.addAttribute(\"order\",order)");
	    model.addAttribute("order",order);
        System.out.println("Should Load Second Page");
        return "redirect:/specs/"+order.get_id();
        
        
	}
	
	@GetMapping("/specs/addToCart/{id}/{id2}")
	public String addToCart2(@PathVariable("id") String id,@PathVariable("id2") String id2, Model model,OrdersCH order) {
		System.out.println("Entered");
		ObjectId _id =new ObjectId(id);
	    SpecsCH spec = specsRepository.findById(_id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + _id));
	 
	    System.out.println("Specs chosen");
	    System.out.println(spec.toString());
	                     //Orders(String orders_createdon, String orders_amount, String orders_address, String orders_delivereddate,
		//String orders_reason, String region_code, ObjectId status_code, ObjectId client, ObjectId employee)
	    Query getProduct = new Query(Criteria.where("specs").is(spec.get_id().toString()).and("product_isavailable").is("1"));
	    ProductCH prodAv = mongoTemplate.findOne(getProduct,ProductCH.class);
	    System.out.println("Product Availabless2 = ");
	    System.out.println(prodAv.toString());
	    
	    
	    

   	 System.out.println("OrderAlreadyExists");
	    pr1 = new Document("_id",prodAv.get_id().toString());
	    pr1.append("product_price", spec.getSpecs_price());
	    pr1.append("product_name", spec.getSpecs_model());
	    
	    OrdersCH ords = orderRepository.findById(new ObjectId(id2))
	    		.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" +id2));
	   System.out.println("Updating Order");
	   System.out.println(ords);
	  ords.setStatus_code("Bucket");
	  List<Document> list = ords.getProducts();
	 list.add(pr1);
	 int new_amount =  Integer.parseInt(ords.getOrders_amount().toString()) + Integer.parseInt(spec.getSpecs_price() );
    
    ords.setOrders_amount(String.valueOf(new_amount));
    System.out.println("new OrdS      " + ords);
    orderRepository.save(ords);
    System.out.println(" new v 2 : " + ords);
    return "redirect:/specs/"+ords.get_id();
    
	
	}
	
	@GetMapping("/specs/CheckOut/{id}")
	public String GoToCheckOut(Model model,@PathVariable("id") String id) {

		 if(!id.isEmpty()) {
		 OrdersCH ordss = orderRepository.findById(new ObjectId(id))
	 	    		.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		model.addAttribute("order",ordss);
		return "redirect://order/update/"+ordss.get_id();
		 }else {
			 System.out.println("Order Is Empty");
			 
			 return "redirect:/specs";
		 }
		
	}
	
}
