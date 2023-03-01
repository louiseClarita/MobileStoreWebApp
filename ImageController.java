package com.example.mobileStoreWebApp;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class ImageController {
	/*

	    @GetMapping("/image-url")
	    public String getImageUrl() {
	    	ConnectionString connectionString = new ConnectionString("mongodb+srv://Clarita:Hawat@atlascluster.9gfb3cx.mongodb.net/?retryWrites=true&w=majority");
			MongoClientSettings settings = MongoClientSettings.builder()
			        .applyConnectionString(connectionString)
			        //.serverApi(ServerApi.builder()
			            .version(ServerApiVersion.V1)
			            .build())
			        .build();
			MongoClient mongoClient = MongoClients.create(settings);
			MongoDatabase testDb = mongoClient.getDatabase("MobileStoreWebApp");
			
			//testDb.createCollection("test");
			MongoCollection<Document> Specs = testDb.getCollection("Specs");
			  Document imageDoc = Specs.find(new Document("Name", "Iphone X")).first();
		        String imageId = imageDoc.getString("image_id");
		        System.out.println("/sn imageUrl =  " + imageId);
		        System.out.println("trying to display image"); 
		        
	      String image_id = "1qoc5K5R3J-lSCUtJI_sD8Z0rpWorBqwS";
	        // Get the URL of the image from Google Drive using the Google Drive API
	        //String imageUrl = MobileStoreWebApp1Application.imageUrl;
	      String imageUrl = "https://drive.google.com/uc?export=view&id="+imageId;
	    //	String imageUrl = "https://lh5.googleusercontent.com/ZVdyhnHoYy6W8TFx81i-a8Uu1_pPJIjOvB4AnKsr5AwajXy66FZHGNA6ilU4mu4p9_I=w2400";
	    	return imageUrl;
	    	*/
	    
	    
	    
	@PostMapping("/addToOrder")
	public void createOrder(String Name) {
		/*
		System.out.println("Image Controller : "+ Name); 
		ConnectionString connectionString = new ConnectionString("mongodb+srv://Clarita:Hawat@atlascluster.9gfb3cx.mongodb.net/?retryWrites=true&w=majority");
		MongoClientSettings settings = MongoClientSettings.builder()
		        .applyConnectionString(connectionString)
		        .serverApi(ServerApi.builder()
		            .version(ServerApiVersion.V1)
		            .build())
		        .build();
		MongoClient mongoClient = MongoClients.create(settings);
		MongoDatabase MobileStoreDB= mongoClient.getDatabase("MobileStoreWebApp");
		MongoCollection<Document> Specs = MobileStoreDB.getCollection("Specs");
        System.out.println("adding"); 
		Document Spec = Specs.find(new Document("Name", Name)).first();
		System.out.println(Spec.toString());
	    String ID = Spec.get("_id").toString();
	    System.out.println("id" + ID); 
		
		//testDb.createCollection("test");
		MongoCollection<Document> Orders = MobileStoreDB.getCollection("Orders");
		Document ORDER = new Document();   
		ORDER.append("orderName","Testing from HTML");
		ORDER.append("specs_id",ID);
		Orders.insertOne(ORDER);
		System.out.println("Added check db"); 
		*/
	}

}
