package com.example.to_do_app.models;

//import java.lang.annotation.Inherited;

import jakarta.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String task;
    private boolean completed;
    public Task(){}
    public Task(String task, boolean completed){
        this.task=task;
        this.completed=completed;

    }

    public Long getId(){
        return id;
    }
    public Long setId(Long id){
        this.id=id;
    }
    public Long getTask(){
        return task;
    }
    public Long setTask(String task){
        this.task=task;
    }
    public Long isComleted(){
        return completed;
    }
    public Long setCompleted(boolean completed){
        this.completed=completed;
    }
}
