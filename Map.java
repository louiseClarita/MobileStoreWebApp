package com.example.mobileStoreWebApp;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
public class Map{
	
	@GetMapping("/map")
	public String home() {
	//console.log("hello");
     return "map";
	}

	

}