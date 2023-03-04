//package com.example.demo;
//
//
//import com.example.models.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
////@RequestMapping("/employeee")
//
//public class EmployeeController {
//  @Autowired
//  private EmployeeRepository employeeRepository;
//  
// @PostMapping("/postt")
//  public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
//	  Employee saveEmployee = this.employeeRepository.save(employee);
//	  return ResponseEntity.ok(saveEmployee);
//  }
// 
//  @GetMapping("/employeee")
//  public ResponseEntity<?> getEmployee(){
//	  return ResponseEntity.ok(this.employeeRepository.findAll());
//  }
//	
//}
