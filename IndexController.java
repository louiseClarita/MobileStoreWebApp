package com.example.mobileStoreWebApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping(("/Products"))
	public String products() {
		
		return "ProductsClient2";
	}
}
