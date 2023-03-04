package com.example.webapp.model;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Tutorial")
public class  Tutorial {
    @Id
  private ObjectId id;

  
  private String title;


  private String description;

 
  private int level;


  private boolean published;

  public Tutorial() {

  }

  public Tutorial(String title, String description, int level, boolean published) {
    this.title = title;
    this.description = description;
    this.level = level;
    this.published = published;
  }

  public ObjectId getId() {
    return id;
  }

  public void setId(ObjectId id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public boolean isPublished() {
    return published;
  }

  public void setPublished(boolean published) {
    this.published = published;
  }

  @Override
  public String toString() {
    return "Tutorial [id=" + id + ", title=" + title + ", description=" + description + ", level=" + level
        + ", published=" + published + "]";
  }

}
