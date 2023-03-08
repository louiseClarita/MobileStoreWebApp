package com.example.webapp.controller;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.webapp.model.Employee;
import com.example.webapp.model.OrdersCH;
import com.example.webapp.model.ProductCH;
import com.example.webapp.repository.EmployeeRepository;
import com.example.webapp.repository.OrdersRepository;

import java.util.List;






@Controller
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
	@Autowired
	private MongoTemplate mongoTemplate;
    /*
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }
    
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable String id) {
        return employeeRepository.findById(id).orElse(null);
    }
    
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable ObjectId id, @RequestBody Employee employee) {
        employee.setId(id);
        return employeeRepository.save(employee);
    }
    
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable String id) {
        employeeRepository.deleteById(id);
    }
    */
    
    
    @PostMapping("/client/auth")
    public String authEmployee(@RequestBody Employee employee, Model model,Employee employee1,BindingResult result,RedirectAttributes redirAttrs) {
        
	    Query getEmp = new Query(Criteria.where("username").is(employee1.getUsername()).and("emp_pass").is(employee1.getEmp_pass()));
	    Employee emp = mongoTemplate.findOne(getEmp,Employee.class);
    	
    	if(emp == null) {
            redirAttrs.addFlashAttribute("message", "Wrong Username Or Password!");
    		System.out.println("bad employee");
    		return "redirect:/specs";
    	}else {
    		
    		System.out.println("good employee");
    		return "redirect:/orders";
    	}
    	
    	
    	
    }
    
    
    
}
