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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.webapp.model.Orders;
import com.example.webapp.model.Status;
import com.example.webapp.repository.OrdersRepository;
import com.example.webapp.repository.StatusRepository;


@Controller
public class OrdersController {

  @Autowired
  private OrdersRepository orderRepository;
  private StatusRepository statusRepository;

  @GetMapping("/orders")
  public String getAll(Model model) {
    try {
      List<Orders> orders = new ArrayList<Orders>(); 
    
      orderRepository.findAllNotNull().forEach(orders::add);
     
      
      System.out.println("ordersTest "+ orders.toArray());
      model.addAttribute("orders", orders);
    } catch (Exception e) {
      model.addAttribute("message", e.getMessage());
    }

    return "wishlist";
  }
  
  
  
  @GetMapping("/powerbi")
  public String getPowerbi() {

    return "dashboard";
  }
  
  
  @PostMapping("/orders/save")
  public String saveorder(Orders tutorial, RedirectAttributes redirectAttributes) {
    try {
    	orderRepository.save(tutorial);

      redirectAttributes.addFlashAttribute("message", "The Order has been saved successfully!");
    } catch (Exception e) {
      redirectAttributes.addAttribute("message", e.getMessage());
    }

    return "redirect:/orders";
  }

//  @GetMapping("/orders/{id}")
//  public String editorder(@PathVariable("id") ObjectId id, Model model, RedirectAttributes redirectAttributes) {
//    try {
//      Orders order = orderRepository.findById(id.toString()).get();
//
//      model.addAttribute("order", order);
//      model.addAttribute("pageTitle", "Edit Tutorial (ID: " + id + ")");
//
//      return "tutorial_form";
//    } catch (Exception e) {
//      redirectAttributes.addFlashAttribute("message", e.getMessage());
//
//      return "redirect:/wishlist";
//    }
//  }

@GetMapping("/{id}")
public String editorder(@PathVariable("id") ObjectId id, Model model, RedirectAttributes redirectAttributes) {
  try {
    Orders order = orderRepository.findById(id.toString()).get();
   // Optional<Status> status = statusRepository.findById(order.getStatus_code().toString());
    
    System.out.println("ordersTest2 "+ order);
    model.addAttribute("order", order);
   // model.addAttribute("order", status);
    model.addAttribute("pageTitle", "Edit Order");

    return "tutorial_form";
  } catch (Exception e) {
    redirectAttributes.addFlashAttribute("message", e.getMessage());

    return "redirect:/wishlist";
  }
}

  
  @GetMapping("/orders/delete/{id}")
  public String deleteorder(@PathVariable("id") ObjectId id, Model model, RedirectAttributes redirectAttributes) {
    try {
    	orderRepository.deleteById(id.toString());

      redirectAttributes.addFlashAttribute("message", "The order with id=" + id + " has been deleted successfully!");
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
    }

    return "redirect:/orders";
  }
  
}