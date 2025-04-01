package com.example.to_do_app.repositories;

import com.example.to_do_app.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long>{
    public Task findByTaskTitle(String taskTitle);
    public List<Task> findByCompletedTrue();
    public List<Task> findByCompletedFalse();
}
