package com.example.to_do_app.services;

import com.example.to_do_app.models.Task;
import com.example.to_do_app.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private final TaskRepository taskRepository;
    public TaskService (TaskRepository taskRepository){
        this.taskRepository=taskRepository;
    }
    public Task createNewTask(Task task){
        return taskRepository.save(task);
    }
    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }
    public Optional <Task> findTaskById(Long id){
        return taskRepository.findById(id);
    }

    public List<Task> findAllCompletedtask(){
        return taskRepository.findByCompletedTrue();
    }

    public List<Task> findAllCompletetask() {
        return taskRepository.findByCompleteFalse();
    }

    public void deleteTask(Long taskId){
        taskRepository.deleteById(taskId);
    }

    public Task updateTask(Task task){
        return taskRepository.save(task);
    }

}
