package com.example.springboot3_basics;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class TaskController {
    
    private final TaskService taskService;
    
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    

    // @GetMapping("/tasks")
    // public List<TaskResponse> getTasks() {
    //     return List.of(
    //         new TaskResponse(1L, "勉強する", "Spring Boot学習する", "TODO"),
    //         new TaskResponse(2L, "ご飯を食べる", "ドミノを買いに行く", "DOING"),
    //         new TaskResponse(3L, "掃除をする", "部屋を掃除する", "DOING")
    //     );
    // }

    // @PostMapping("/tasks")
    // public TaskResponse createTask(@RequestBody TaskCreateRequest request) {
        
    //     //チャレンジ１
    //     if (request.getTitle() == null || request.getTitle().isBlank()) {
    //         throw new IllegalArgumentException("title is null");
    //     }

    //     //ダミデータ
    //     Long newId = 1L;
    //     String initialStatus ="TODO";
        
    //     return new TaskResponse(
    //         newId, 
    //         request.getTitle(),
    //         request.getDescription(),
    //         initialStatus
    //     );
    // }

    @PostMapping("/tasks")
    public TaskResponse createTask(@RequestBody TaskCreateRequest request) {
        Task task = taskService.createTask(request.getTitle(), request.getDescription());
        
        //チャレンジ１
        if (request.getTitle() == null || request.getTitle().isBlank()) {
            throw new IllegalArgumentException("title is null");
        }
        
        return new TaskResponse(
            task.getId(),
            task.getTitle(),
            task.getDescription(),
            task.getStatus()
        );
    }

    @GetMapping("/tasks")
    public List<TaskResponse> getTasks() {

        List<Task> tasks = taskService.findAllTasks();

        return tasks.stream()
        .map(task -> new TaskResponse(
            task.getId(),
            task.getTitle(),
            task.getDescription(),
            task.getStatus()
        ))
        .collect(Collectors.toList());
    }
    

}
