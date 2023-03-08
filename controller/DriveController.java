package com.example.webapp.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

import jakarta.annotation.PostConstruct;

	//Define the controller class
	@RestController
	public class DriveController {
	 private Drive service;
	 GoogleCredentials GoogleCredentials;

	 @PostConstruct
	 public void init() {
	     // Build a new authorized API client service.
	     try {
	    	 GoogleCredentials = new GoogleCredentials();
	    	 System.out.println("init first line");
	         NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
	         service = new Drive.Builder(httpTransport, GoogleCredentials.JSON_FACTORY, GoogleCredentials.getCredentials(httpTransport))
	                 .setApplicationName(GoogleCredentials.APPLICATION_NAME)
	                 .build();
	         
	     } catch (GeneralSecurityException | IOException e) {
	         e.printStackTrace();
	     }
	 }

	 
	 @PostMapping("/uploadFile")
	 public String submitForm1(@RequestParam("file") MultipartFile file) {
	     try {
	         //init();
	         // Create a new file on Google Drive
	         File fileMetadata = new File();
	         fileMetadata.setName(file.getOriginalFilename());
	         fileMetadata.setMimeType(file.getContentType());
	         //fileMetadata.setId(UUID.randomUUID().toString());
	         //File createdFile = service.files().create(fileMetadata).execute();

	         // Upload the image file to the created file
	         ByteArrayContent content = new ByteArrayContent(file.getContentType(), file.getBytes());
	         Drive.Files.Create create = service.files().create(fileMetadata, content);
	         create.execute();
	         
	         

	         return "File uploaded successfully";
	     } catch (IOException e) {
	         e.printStackTrace();
	         return "Error uploading file";
	     }
	 }

	 
	 
	 
	 
	// @PostMapping("/uploadFile")
	 public String submitForm2(MultipartFile file) {
	     try {
	         init();
	         String folderId = "1HfBTBBq21D8Yg2hVKYMx7HsUVOVkBXSD";
	         // Create a new file on Google Drive
	         File fileMetadata = new File();
	         fileMetadata.setName(file.getOriginalFilename());
	         
			fileMetadata.setParents(Collections.singletonList(folderId));
	         fileMetadata.setMimeType(file.getContentType());
	         //fileMetadata.setId(UUID.randomUUID().toString());
	         //File createdFile = service.files().create(fileMetadata).execute();

	         // Upload the image file to the created file
	         ByteArrayContent content = new ByteArrayContent(file.getContentType(), file.getBytes());
	         Drive.Files.Create create = service.files().create(fileMetadata, content);
	         File createdFile = create.execute();
	         
	         

	         return createdFile.getId();
	     } catch (IOException e) {
	         e.printStackTrace();
	         return "Error uploading file";
	     }
	 }

	 //not used
	 @GetMapping("/submit2")
	 public String submitForm2() {
	     try {
	    	 
	    	// Set the file name and MIME type.
	    	 String fileName = "MyFile.txt";
	    	 String mimeType = "text/plain";

	    	 // Create the file metadata.
	    	 File fileMetadata = new File();
	    	 fileMetadata.setName(fileName);
	    	 fileMetadata.setMimeType(mimeType);

	    	 // Create a new file on Google Drive.
	    	 File file = service.files().create(fileMetadata).execute();
	    	 System.out.printf("File ID: %s\n", file.getId());
	    	 
	    	 System.out.printf("-----------------------------------");
	    	 
	    	 System.out.println("file created");
	    	// init();
	         // Print the names and IDs for up to 10 files.
	         FileList result = service.files().list()
	                 .setPageSize(3)
	                 .setFields("nextPageToken, files(id, name)")
	                 .execute();

	         List<File> files = result.getFiles();
	         if (files == null || files.isEmpty()) {
	             System.out.println("No files found.");
	         } else {
	             System.out.println("Files:");
	             for (File file2 : files) {
	                 System.out.printf("%s (%s)\n", file2.getName(), file2.getId());
	             }
	         }
	     } catch (IOException e) {
	         e.printStackTrace();
	     }
	     return "test";
	 }

	}