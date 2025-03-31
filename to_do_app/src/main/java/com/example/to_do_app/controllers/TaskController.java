package com.example.to_do_app.controllers;

import com.example.to_do_app.models.Task;
import com.example.to_do_app.services.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;
    
    @GetMapping("/")
    public ResponseEntity<List<Task>> getAllTass(){
        return ResponseEntity.ok(taskService.getAllTask());
    }
    @GetMapping("/completed")
    public ResponseEntity<List<Task>> getAllCompletedTasks() {
        return ResponseEntity.ok(taskService.findAllCompletedtask());
    }
    @GetMapping("/incomplete")
    public ResponseEntity<List<Task>> getAllIncompleteTasks() {
        return ResponseEntity.ok(taskService.findAllInCompletetask());
    }

    @PostMapping("/")
    public ResponseEntity<Task> createTasks(@Requestbody task task) {
        return ResponseEntity.ok(taskService.createNewTask(task));
    }
    
    @PutMapping("/")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @requestBody Task task) {
        task.setId(id);
        return ResponseEntity.ok(taskService.updateTask(task));
    }
    
    @DeleteMapping("/")
    public ResponseEntity<Boolean> getAllTasks(@PathVariable Long id) {
       taskService.deleteTask(id);
        return ResponseEntity.ok(true);
    }
}
