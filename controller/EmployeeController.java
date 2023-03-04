package com.example.webapp.controller;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.webapp.model.Employee;
import com.example.webapp.repository.EmployeeRepository;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    
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
}
