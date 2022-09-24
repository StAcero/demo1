package com.example.demo1.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskList1 {
    private String name;
    private List<Task1> taskList;

    public TaskList1(String name) {
        this.name = name;
        this.taskList = new ArrayList<Task1>();

    }
    public void addTaskList(Task1 task){
        this.taskList.add(task);
    }
    public List<Task1> getTaskList(){
        return this.taskList;
    }

    public void setTaskList(List<Task1> taskList) {
        this.taskList = taskList;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void removeTask(String description){
        this.taskList = taskList.stream().filter(t->{
            return !t.getDescription().equals(description);
        }).collect(Collectors.toList());
    }
    public void printTask(){
        this.taskList.forEach(task->{
            System.out.println("description: ");
            System.out.println(task.getDescription());
            System.out.println("fecha: ");
            System.out.println(task.getDueDate());
            System.out.println("realizada: ");
            System.out.println(task.getDone());
            System.out.println("-----------------------------");
        });
    }
}
