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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

	import com.example.webapp.model.Orders;
	import com.example.webapp.model.SpecsCH;
import com.example.webapp.model.Tutorial;
import com.example.webapp.repository.OrdersRepository;
	import com.example.webapp.repository.ProductRepository;
	import com.example.webapp.repository.SpecsRepositoryCH;

	@Controller
	public class SpecsController {

		  @Autowired
		  private SpecsRepositoryCH specsRepository;
		  
		  @GetMapping("/productspecs")
		  public String getAll(Model model) {
		    try {
		      List<SpecsCH> specs = new ArrayList<SpecsCH>(); 
		    
		      specsRepository.findAll().forEach(specs::add);
		     
		      
		      System.out.println("ordersTest "+ specs.toArray());
		      model.addAttribute("specs", specs);
		    } catch (Exception e) {
		      model.addAttribute("message", e.getMessage());
		    }

		    return "ProductSpecsCM";
		  }
		  
		  @GetMapping("/productspecs/new")
		  public String addTutorial(Model model) {
		    SpecsCH specs = new SpecsCH();
		    

		    model.addAttribute("specs", specs);
		    //model.addAttribute("pageTitle", "Create new Tutorial");
		    System.out.println("test1"+specs);
		    return "productSpecsFormCreate";
		  }

		

		  

		  @PostMapping("/productspecs/save")
		  public String savespecs2( SpecsCH specs, MultipartFile file,  RedirectAttributes redirectAttributes) {
		    try {
		    	DriveController driveController = new DriveController();
		    	specs.setSpecs_image(driveController.submitForm2(file));
		    	 System.out.println("ordersTest3save "+ specs);
		    	specsRepository.save(specs);

		      redirectAttributes.addFlashAttribute("message", "The product has been saved successfully!");
		    } catch (Exception e) {
		      redirectAttributes.addAttribute("message", e.getMessage());
		    }

		    return "redirect:/productspecs";
		  }
		  
		  
		  
		  @PostMapping("/productspecs/save/{id}")
		  public String saveorder(@PathVariable("id") ObjectId id, SpecsCH specs, RedirectAttributes redirectAttributes) {
		    try {
		    	specs.set_id(id);
		    	 System.out.println("ordersTest3save "+ specs);
		    	specsRepository.save(specs);

		      redirectAttributes.addFlashAttribute("message", "The product has been saved successfully!");
		    } catch (Exception e) {
		      redirectAttributes.addAttribute("message", e.getMessage());
		    }

		    return "redirect:/productspecs";
		  }
		  
		  
		  
		  

		  @GetMapping("/productspecs/delete/{id}")
		  public String deleteorder(@PathVariable("id") ObjectId id, Model model, RedirectAttributes redirectAttributes) {
		    try {
		    	//specsRepository.deleteById(id.toString());
		    	specsRepository.deleteById(id);
		      redirectAttributes.addFlashAttribute("message", "The order with id=" + id + " has been deleted successfully!");
		    } catch (Exception e) {
		      redirectAttributes.addFlashAttribute("message", e.getMessage());
		    }

		    return "redirect:/productspecs";
		  } 
		  
		  @GetMapping("/productspecs/{id}")
		  public String editorder(@PathVariable("id") ObjectId id, Model model, RedirectAttributes redirectAttributes) {
		    try {
		     // SpecsCH specs = specsRepository.findById(id.toString()).get();
		    	SpecsCH specs = specsRepository.findById(id).get();
		     // Optional<Status> status = statusRepository.findById(order.getStatus_code().toString());
		      
		      System.out.println("ordersTest2 "+ specs);
		      model.addAttribute("specs", specs);
		     // model.addAttribute("order", status);
		      model.addAttribute("pageTitle", "Edit Product");

		      return "productSpecsFormEdit";
		    } catch (Exception e) {
		      redirectAttributes.addFlashAttribute("message", e.getMessage());

		      return "redirect:/wishlist";
		    }}
		  
	
		  
	}
