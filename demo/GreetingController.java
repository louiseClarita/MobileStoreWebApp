package com.example.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller	
public class GreetingController {

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name",required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
			return "greeting";
	}
	
	  @GetMapping("/map")
		public String map() {
			
				return "map";
		}
	
}
