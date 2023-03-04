package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.example.demo.*;

//import com.example.models.Employee;

//import com.example.models.Employee;



@RestController
public class Controller {
	  @Autowired
	  private EmployeeRepository employeeRepository;
	  @Autowired
	  private LocationRepository locationRepository;
	  @Autowired
	  private OrderRepository orderRepository;
	
@RequestMapping("/")
		
		
		public String home() {
			return "Hello, i'm testing Github deployment";
}




  
 @PostMapping("/postt")
  public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
	  Employee saveEmployee = this.employeeRepository.save(employee);
	  return ResponseEntity.ok(saveEmployee);
  }
 
 @GetMapping("/employeee")
public String getEmployee(){
  return "testing";
}
	
 
  @GetMapping("/employees")
  public ResponseEntity<?> getEmployees(){
	  return ResponseEntity.ok(this.employeeRepository.findAll());
  }
	
  @GetMapping("/employeess")
  public List<Employee> getAllEmployees() {
	    return employeeRepository.findAll();
	}
  @PostMapping("/save-location")
  public Location saveLocation(@RequestBody Map<String, Double> location) {
      double lat = location.get("lat");
      double lng = location.get("lng");
      
      Location loc = new Location(lat, lng);
     locationRepository.save(loc);
      return loc;
     
  }
  @PostMapping("/save-order")
  public Order saveOrder(@RequestBody Map<String, String> order) {
      String lat = order.get("lat");
      
      String lng = order.get("lng");
      String name = order.get("name");
      String address = order.get("address");
      String phone = order.get("phone");
      String email = order.get("email");
      String product = order.get("product");
      String quantity = order.get("quantity");
      String color = order.get("color");
      
      
      
      
      //Order(ObjectId id, double lat, double lng, String name, String address, String phone, String email,String product, String quantity, String color, String delivery_date)
      Order ord = new Order(lat,lng,name,address,phone,email,product,quantity,color);
      System.out.println(ord.toString());
     orderRepository.save(ord);
      return ord;
     
  }

}



