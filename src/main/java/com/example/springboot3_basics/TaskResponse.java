package com.example.springboot3_basics;

public class TaskResponse {

    private Long id;
    private String title;
    private String description;
    private String status;

    //コンストラクタ
    public TaskResponse(Long id, String title, String description, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
    }
    
    // Getterのみ（レスポンスは変更しないためSetterは不要）
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }
    
}
