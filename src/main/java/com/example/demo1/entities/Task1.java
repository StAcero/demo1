package com.example.demo1.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="task")
public class Task1 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(name="description")
    private String description;
    @Column(name="done")
    private Boolean done;
    @Column(name="dueDate")
    private LocalDate dueDate;
    public Task1(){

    }
    public Task1(String description, Boolean done, LocalDate dueDate) {
        this.description = description;
        this.done = done;
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }






}
