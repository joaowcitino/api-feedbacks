package com.example.feedback.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "feedbacks")
public class Feedback {
    @Id
    private String id;
    private String title;
    private String description;
    private int rating;
    private String userEmail;

    public Feedback() {}
    public Feedback(String title, String description, int rating, String userEmail) {
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.userEmail = userEmail;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }
    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
}
