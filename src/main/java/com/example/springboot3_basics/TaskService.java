package com.example.springboot3_basics;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TaskService {
    
    private final TaskRepository taskRepository;

    // DI:コンストラクタインジェクション
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(String title, String description) {
        // タイトルが空の場合、エラー
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }

        Task task = new Task(title, description, "TODO");
        return taskRepository.save(task);
    }

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }
    
}
