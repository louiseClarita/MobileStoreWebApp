package com.example.webapp.controller;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.google.api.services.gmail.GmailScopes;
import com.google.api.services.script.ScriptScopes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

//Define the DriveQuickstart class
public class GoogleCredentials {
 final String APPLICATION_NAME = "MobileStoreWebApp";
 final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
  public List<String> SCOPES = new ArrayList<>();
  
	// TODO Auto-generated constructor stub

  
 final String CREDENTIALS_FILE_PATH = "/credentials.json";

 /**
  * Creates an authorized Credential object.
  * @param httpTransport The network HTTP Transport.
  * @return An authorized Credential object.
  * @throws IOException If the credentials.json file cannot be found.
  */
 public Credential getCredentials(final NetHttpTransport httpTransport) throws IOException {
	 SCOPES.addAll(Collections.singletonList(DriveScopes.DRIVE));
	 SCOPES.addAll(Collections.singletonList("https://www.googleapis.com/auth/script.scriptapp"));
	 SCOPES.addAll(Collections.singletonList("https://www.googleapis.com/auth/userinfo.profile"));
	 SCOPES.addAll(Collections.singletonList("https://www.googleapis.com/auth/userinfo.email"));
	 SCOPES.addAll(Collections.singletonList(ScriptScopes.ADMIN_DIRECTORY_USER));
	 SCOPES.addAll(Collections.singletonList(GmailScopes.GMAIL_LABELS));
	 SCOPES.addAll(Collections.singletonList(ScriptScopes.SCRIPT_PROJECTS));
	 SCOPES.addAll(Collections.singletonList(ScriptScopes.SPREADSHEETS));
     // Load client secrets.
     InputStream in = GoogleCredentials.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
     GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

     // Build flow and trigger user authorization request.
     GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
             httpTransport, JSON_FACTORY, clientSecrets, SCOPES)
             .setDataStoreFactory(new FileDataStoreFactory(new java.io.File("tokens")))
             .setAccessType("offline")
             .build();
     LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
     return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
 }
}