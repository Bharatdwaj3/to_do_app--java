package com.example.to_do_app.controllers;

import com.example.to_do_app.models.Task;
import com.example.to_do_app.services.TaskService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
    private final TaskService  taskService;
    public TaskController(TaskService taskService){
        this.taskService=taskService;
    }
    
    
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
        return ResponseEntity.ok(taskService.findAllCompletetask());
    }

    @PostMapping("/")
    public ResponseEntity<Task> createTasks(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.createNewTask(task));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id);
        return ResponseEntity.ok(taskService.updateTask(task));
    }
    
    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> getAllTasks(@PathVariable Long id) {
       taskService.deleteTask(id);;
        return ResponseEntity.noContent().build();
    }
}

