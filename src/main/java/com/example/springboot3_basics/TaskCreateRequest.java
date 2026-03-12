package com.example.springboot3_basics;

public class TaskCreateRequest {
    
    private String title;
    private String description;

    //Getter
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    //Setter
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
