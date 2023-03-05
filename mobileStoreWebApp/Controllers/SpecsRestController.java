package com.example.mobileStoreWebApp.Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.AbstractContext;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;
import org.thymeleaf.context.IWebContext;
import org.thymeleaf.context.WebContext;
import org.springframework.web.reactive.result.view.Rendering;
import com.example.mobileStoreWebApp.Model.Specs;
import com.example.mobileStoreWebApp.Model.Type;
import com.example.mobileStoreWebApp.repository.OrdersRepository;
import com.example.mobileStoreWebApp.repository.ProductRepository;
import com.example.mobileStoreWebApp.repository.SpecsRepository;
import com.example.mobileStoreWebApp.repository.TypeRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import reactor.core.publisher.Mono;

@Controller
public class SpecsRestController {
	
	
	
	

	@Autowired
	private SpecsRepository specsRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private OrdersRepository orderRepository;
	@Autowired
	private MongoTemplate mongoTemplate;
	
	
	@Autowired
	private TemplateEngine templateEngine;
	@Autowired
	private TypeRepository typeRepository;
	
	/*
	 * 
	 * 
	 * 
    public String FilterByCategory(@PathVariable("type_name") String type_name,Model model) {
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
        
       
        model.addAttribute("listOfIds",listOfIds);
      //  model.addAttribute("specsFiltered",ListOfSpecs);
      //  System.out.println(ListOfSpecs);
    	
    	List<Specs> ListOfSpecs = new ArrayList<>();
    	System.out.println(type_name);
    	Query getListOfSpecs = new Query(Criteria.where("specs_type").is(type_name).and("specs_availability").gte("1"));
    	ListOfSpecs = mongoTemplate.find(getListOfSpecs,Specs.class);
    	System.out.println(ListOfSpecs);
        model.addAttribute("specsFiltered",ListOfSpecs);
    //	model.addAttribute(getListOfSpecs)
        Context context = new Context();

      //  return ListOfSpecs;
        
        String specListFragment = templateEngine.process("spec-list-fragment", context);
    //    context.setVariable("variableName", variableValue);

       // return ListOfSpecs;
        return specListFragment;
    }
    */

/*

    @GetMapping("/loadCategoriess/{type_name}")
    @ResponseBody
    public String FilterByCategory(@PathVariable("type_name") String type_name,Model model, HttpServletRequest request, HttpServletResponse response) {
   
    	List<Specs> ListOfSpecs = new ArrayList<>();
    	System.out.println(type_name);
    	Query getListOfSpecs = new Query(Criteria.where("specs_type").is(type_name).and("specs_availability").gte("1"));
    	ListOfSpecs = mongoTemplate.find(getListOfSpecs,Specs.class);
    	
    	 WebContext context = new WebContext(request, response, request.getServletContext());
    	  context.setVariable("specsFiltered", ListOfSpecs);
    //	model.addAttribute(getListOfSpecs)
      //  Map<String, Object> modelMap = new HashMap<>();
      //  modelMap.put("specsFiltered", ListOfSpecs);
        
        String specListFragment = templateEngine.process("productsClient", context);
       // return ListOfSpecs;
        return specListFragment;
    }
*/
}
