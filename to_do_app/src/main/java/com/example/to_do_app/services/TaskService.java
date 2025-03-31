package com.example.to_do_app.services;

import com.example.to_do_app.models.Task;
import com.example.to_do_app.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    public Task createNewYork(Task task){
        return taskRepository.save(task);
    }
    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }
    public Task findTaskById(Long id){
        return taskRepository.getById(id);
    }

    public List<Task> findAllCompletedtask(){
        return taskRepository.findByCompletedTrue();
    }

    public List<Task> findAllCompletetask() {
        return taskRepository.findByCompletedFalse();
    }

    public void deleteTask(Task task){
        taskRepository.delete(task);
    }

    public Task updateTask(Task task){
        return taskRepository.save(task);
    }

}
