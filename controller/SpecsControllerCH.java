package com.example.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.example.webapp.model.OrdersCH;
import com.example.webapp.model.ProductCH;
import com.example.webapp.model.SpecsCH;
import com.example.webapp.model.Type;
import com.example.webapp.repository.OrdersRepositoryCH;
import com.example.webapp.repository.ProductRepositoryCH;
import org.springframework.data.mongodb.core.query.Query;

import com.example.webapp.repository.SpecsRepositoryCH;
import com.example.webapp.repository.TypeRepository;

import jakarta.servlet.http.HttpServletResponse;

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
	
	@Autowired
	private TypeRepository typeRepository;
	
	
	@Autowired
    private SpringTemplateEngine templateEngine;
	
	Document pr1;
	//@Autowired
	//private CacheManager cacheManager;

	//ObjectId orderid;
	
	
	@GetMapping("/specs")
    public String viewHomePage( Model model) {
		System.out.println("Specs Step 1...");
		System.out.println(specsRepository.count());
		System.out.println(specsRepository.findAll());
        model.addAttribute("specs", specsRepository.findAll());
       
        
        //Add types + Id for the tabs + the link to be able to see them
        List<Type> listOfTypes = new ArrayList<>();
        List<Map<String,String>> listOfIds = new ArrayList<>();
        List<String> listOfLinks = new ArrayList<>();
        listOfTypes = typeRepository.findAll();
        model.addAttribute("types", listOfTypes);
        
        for(int i=0;i<listOfTypes.size();i++) {
            Map<String,String> map = new HashMap<String,String>();
            map.put(listOfTypes.get(i).getType_name().toString(),"");
        	
        	listOfIds.add(map);
        	//listOfIds.add("top-"+listOfTypes.get(i).getType_name()+"-link");
        	
        }
        
        String typeName=listOfTypes.get(0).getType_name();
        System.out.println(typeName);
        List<SpecsCH> ListOfSpecs = new ArrayList<>();
    	Query getListOfSpecs = new Query(Criteria.where("specs_type").is(typeName).and("specs_availability").gte("1"));
    	ListOfSpecs = mongoTemplate.find(getListOfSpecs,SpecsCH.class);
    	
        model.addAttribute("listOfIds",listOfIds);
        model.addAttribute("specsFiltered",ListOfSpecs);
        System.out.println(ListOfSpecs);
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
        	List<SpecsCH> ListOfSpecs  = new ArrayList<>();
        	for(int i=0;i<order1.getProducts().size();i++) {
        		
        		
        		Document prodd = order1.getProducts().get(i);
        		
        		ProductCH prod11 = new  ProductCH();
        		prod11 = productRepository.findById(new ObjectId(prodd.get("_id").toString())).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + prodd.get("_id")));
        		System.out.println(prod11);
        		SpecsCH specc = new SpecsCH();
        		
        		specc = specsRepository.findById(new ObjectId(prod11.getSpecs())).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" ));
        		System.out.println(specc);
        		ListOfSpecs.add(specc);
        		
        	}
        	  List<Type> listOfTypes = new ArrayList<>();
              List<Map<String,String>> listOfIds = new ArrayList<>();
              List<String> listOfLinks = new ArrayList<>();
              listOfTypes = typeRepository.findAll();
              model.addAttribute("types", listOfTypes);
        	System.out.println(ListOfSpecs);
        	model.addAttribute("ListOfSpecs",ListOfSpecs);
        	model.addAttribute("order",order1);
        }else {
        	System.out.println("ID IS EMPTYYYYYYYYY");
        }
        return "productsClient3";
    }
	
	
	@GetMapping("/specs/addToCartEmpty/{id}")
	public String addToCart(@PathVariable("id") String id, Model model,RedirectAttributes redirAttrs) {
       // Creating a new Order
		
	//	clearAllCaches();
		
		
		
		
		System.out.println("Entered");
		ObjectId _id =new ObjectId(id);
	    SpecsCH spec = specsRepository.findById(_id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + _id));
	 
	    
	                     //Orders(String orders_createdon, String orders_amount, String orders_address, String orders_delivereddate,
		//String orders_reason, String region_code, ObjectId status_code, ObjectId client, ObjectId employee)
	    Query getProduct = new Query(Criteria.where("specs").is(spec.get_id().toString()).and("product_isavailable").is("1"));
	    ProductCH prodAv = mongoTemplate.findOne(getProduct,ProductCH.class);
	
	
	    
	  
	    
	    
	    
	    
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
	
	   
        
	    
	    
	    
	    
	    OrdersCH order = orderRepository.save(ord);

	    model.addAttribute("listOfProducts", pr1);
	    model.addAttribute("order",order);
	   //model.addAttribute("ListOfSpecs",ListOfSpecs);
	    System.out.println("ListOfSpecs"+order.getProducts());
	   //
        redirAttrs.addFlashAttribute("message", "Product Successfully added to cart!");
        return "redirect:/specs/"+order.get_id();
        
        
	}
	
	@GetMapping("/specs/addToCart/{id}/{id2}")
	public String addToCart2(@PathVariable("id") String id,@PathVariable("id2") String id2, Model model,OrdersCH order,RedirectAttributes redirAttrs) {
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
	    System.out.println(prodAv);
	    
	    
	    

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
    redirAttrs.addFlashAttribute("message", "Product Successfully added to cart!");
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
/*	public void clearAllCaches() {
	    for (String cacheName : cacheManager.getCacheNames()) {
	        cacheManager.getCache(cacheName).clear();
	    }
	}
	*/
	
	
	
    @GetMapping("/loadCategories/{type_name}")
	 public String FilterByCategory(@PathVariable("type_name") String type_name,Model model) {
	    	
    	System.out.println(specsRepository.findAll());
        model.addAttribute("specs", specsRepository.findAll());
       
        
        //Add types + Id for the tabs + the link to be able to see them
        List<Type> listOfTypes = new ArrayList<>();
       // List<Map<String,String>> listOfIds = new ArrayList<>();
      //  List<String> listOfLinks = new ArrayList<>();
        listOfTypes = typeRepository.findAll();
        model.addAttribute("types", listOfTypes);
       /* 
        for(int i=0;i<listOfTypes.size();i++) {
            Map<String,String> map = new HashMap<String,String>();
            map.put(listOfTypes.get(i).getType_name().toString(),"");
        	
        	listOfIds.add(map);
        	//listOfIds.add("top-"+listOfTypes.get(i).getType_name()+"-link");
        	
        }
        */
        //String typeName=listOfTypes.get(0).getType_name();
        //System.out.println(typeName);
        
    	
    	
           //model.addAttribute("listOfIds",listOfIds);
	    
	      
	      //  model.addAttribute("specsFiltered",ListOfSpecs);
	      //  System.out.println(ListOfSpecs);
	    	
	    	List<SpecsCH> ListOfSpecs = new ArrayList<>();
	    	System.out.println(type_name);
	    	Query getListOfSpecs = new Query(Criteria.where("specs_type").is(type_name).and("specs_availability").gte("1"));
	    	ListOfSpecs = mongoTemplate.find(getListOfSpecs,SpecsCH.class);
	    	System.out.println(ListOfSpecs);
	        model.addAttribute("specsFiltered",ListOfSpecs);

	        System.out.println("should reload");
	     //   return "categories.html";
	        model.addAttribute("specs", specsRepository.findAll());
	        return "productsClient4.html";


    }
    
    
    
    
    @GetMapping("/loadCategories0/{type_name}")
	 public String FilterByCategory0(@PathVariable("type_name") String type_name,Model model) {
	    	
    	System.out.println(specsRepository.findAll());
        model.addAttribute("specs", specsRepository.findAll());
       
        
        //Add types + Id for the tabs + the link to be able to see them
        List<Type> listOfTypes = new ArrayList<>();
       // List<Map<String,String>> listOfIds = new ArrayList<>();
      //  List<String> listOfLinks = new ArrayList<>();
      listOfTypes = typeRepository.findAll();
      model.addAttribute("types", listOfTypes);
        
      /*  for(int i=0;i<listOfTypes.size();i++) {
            Map<String,String> map = new HashMap<String,String>();
            map.put(listOfTypes.get(i).getType_name().toString(),"");
        	
        	listOfIds.add(map);
        	//listOfIds.add("top-"+listOfTypes.get(i).getType_name()+"-link");
        	
        }
        */
      
        //String typeName=listOfTypes.get(0).getType_name();
        //System.out.println(typeName);
        
    	
    	
           //model.addAttribute("listOfIds",listOfIds);
	    
	      
	      //  model.addAttribute("specsFiltered",ListOfSpecs);
	      //  System.out.println(ListOfSpecs);
	    	
	    	List<SpecsCH> ListOfSpecs = new ArrayList<>();
	    	System.out.println(type_name);
	    	Query getListOfSpecs = new Query(Criteria.where("specs_type").is(type_name).and("specs_availability").gte("1"));
	    	ListOfSpecs = mongoTemplate.find(getListOfSpecs,SpecsCH.class);
	    	System.out.println(ListOfSpecs);
	        model.addAttribute("specsFiltered",ListOfSpecs);

	        System.out.println("should reload");
	     //   return "categories.html";
	        model.addAttribute("specs", specsRepository.findAll());
	        return "productsClient5.html";


    }
    
    
    
    
    
    
    
    @GetMapping("/loadCategories2/{type_name}")
	 public String FilterByCategory2(@PathVariable("type_name") String type_name,Model model) {
	    	
      
       	
      
   	
   	
	      
	      //  model.addAttribute("specsFiltered",ListOfSpecs);
	      //  System.out.println(ListOfSpecs);
	    	
	    	List<SpecsCH> ListOfSpecs = new ArrayList<>();
	    	System.out.println(type_name);
	    	Query getListOfSpecs = new Query(Criteria.where("specs_type").is(type_name).and("specs_availability").gte("1"));
	    	ListOfSpecs = mongoTemplate.find(getListOfSpecs,SpecsCH.class);
	    	System.out.println(ListOfSpecs);
	        model.addAttribute("specsFiltered",ListOfSpecs);
           
	        System.out.println("should reload");
	       return "categories.html";
	     //    return "productsClient.html";


   }
   
    
    /*
    @GetMapping("/loadCategories/{type_name}")
	 public String FilterByCategory(@PathVariable("type_name") String type_name,Model model,@ModelAttribute("specsFiltered") List<Specs> specsFiltered) {
	    	
	     
	    	List<Specs> ListOfSpecs = new ArrayList<>();
	    	System.out.println(type_name);
	    	Query getListOfSpecs = new Query(Criteria.where("specs_type").is(type_name).and("specs_availability").gte("1"));
	    	ListOfSpecs = mongoTemplate.find(getListOfSpecs,Specs.class);
	    	System.out.println(ListOfSpecs);
	        model.addAttribute("specsFiltered",ListOfSpecs);

	        System.out.println("should reload");
	        return "productsClient.html";
	


   }
    */
    
    
    
    
    
    
    
    
}
