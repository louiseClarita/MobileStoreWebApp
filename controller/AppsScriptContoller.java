package com.example.webapp.controller;


	import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.RestController;
	import org.springframework.web.multipart.MultipartFile;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
	import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.http.javanet.NetHttpTransport;
	import com.google.api.services.drive.Drive;
	import com.google.api.services.drive.model.File;
	import com.google.api.services.drive.model.FileList;
import com.google.api.services.script.Script;
import com.google.api.services.script.Script.Scripts.Run;
import com.google.api.services.script.model.ExecutionRequest;
import com.google.api.services.script.model.Operation;

import jakarta.annotation.PostConstruct;

		//Define the controller class
		@RestController
		public class AppsScriptContoller {
		 private Script service;
		 GoogleCredentials GoogleCredentials;

		 @PostConstruct
		 public void init() {
		     // Build a new authorized API client service.
		     try {
		    	 GoogleCredentials = new GoogleCredentials();
		    	 System.out.println("init first line");
		         NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
		         service = new Script.Builder(httpTransport, GoogleCredentials.JSON_FACTORY, GoogleCredentials.getCredentials(httpTransport))
		        		 .setApplicationName(GoogleCredentials.APPLICATION_NAME)
		                 .build();
		         
		     } catch (GeneralSecurityException | IOException e) {
		         e.printStackTrace();
		     }
		 }

		 
	

		 
		
		// @GetMapping("/sendemail")
		 public void sendemail(String Email, String Name) throws Exception, IOException  {  // Build HTTP transport and credentials
			 init();
		    NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
		    Credential credential = GoogleCredentials.getCredentials(httpTransport);

		    // Create an instance of the HTTP request factory using the authenticated credential
		    HttpRequestFactory requestFactory = httpTransport.createRequestFactory(credential);

		    // Create a GenericUrl object for the API endpoint
		    GenericUrl url = new GenericUrl("https://script.google.com/macros/s/AKfycbw_0Qhadl_jYo1p6qAAxnoDnfMAj1bi7TzHwbvQfCuh3Dqc1xCM2L7Nq6O-6OvLsjBH/exec");

		    // Create a map of parameters to be sent in the POST request
		    Map<String, Object> params = new HashMap<>();
		    params.put("to", Email);
		    params.put("subject", "Thank you for your order!");
		    params.put("body", "Dear "+Name +",\r\n"
		    		+ "\r\n"
		    		+ "We wanted to personally thank you for placing an order with us. We appreciate your business and are excited to get your order to you as soon as possible.\r\n"
		    		+ "\r\n"
		    		+ "We're happy to let you know that your order has been processed and is on its way. You can expect to receive it by 9 March 2023.\r\n"
		    		+ "\r\n"
		    		+ "If you have any questions or concerns about your order, please don't hesitate to reach out to us. We're always here to help!\r\n"
		    		+ "\r\n"
		    		+ "Thanks again for your order, and we hope to do business with you again soon.\r\n"
		    		+ "\r\n"
		    		+ "Best regards,\r\n"
		    		+ "Crazy Phone Team");

		    // Create an HttpContent object with the parameter map as the content
		    HttpContent content = new UrlEncodedContent(params);

		    try {
		        // Make a POST request to the API endpoint using the requestFactory instance
		        HttpResponse response = requestFactory.buildPostRequest(url, content).execute();

		        // Print the response body
		        System.out.println(response.parseAsString());
		    } catch (Exception e) {
		        e.printStackTrace();
		    }}}
		    
	
		
		

		 
//		 
//		 @GetMapping("/sendemail")
//		 public void sendemail6() throws Exception, IOException  {
//			 
//		 
//		        // Build HTTP transport and credentials
//		        NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
//		        Credential credential = GoogleCredentials.getCredentials(httpTransport);
//
//		        // Create an instance of the HTTP request factory using the authenticated credential
//		        HttpRequestFactory requestFactory = httpTransport.createRequestFactory(credential);
//
//		        // Create a GenericUrl object for the API endpoint
//		        GenericUrl url = new GenericUrl("https://script.google.com/macros/s/AKfycbwPrJnJ4n82Kuu4ICG4VlU4GLpgNvoycmHIVBO8qqMUil1Jy_xTyZ6vCds60Ed6myQj/exec");
//
//		        try {
//		            // Make a GET request to the API endpoint using the requestFactory instance
//		            HttpResponse response = requestFactory.buildGetRequest(url).execute();
//
//		            // Print the response body
//		            System.out.println(response.parseAsString());
//		        } catch (Exception e) {
//		            e.printStackTrace();
//		        }
		        
//		 }

