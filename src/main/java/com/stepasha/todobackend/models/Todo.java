package com.stepasha.todobackend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "todos")
public class Todo {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = true)
    private long todoid;
    private String description;
    private String datestarted;
    @Transient
    public boolean iscompleted = false;


    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties({"users"})
    private User user;


    public Todo(){}
    public Todo(String description, String datestarted, boolean completed) {

        this.description = description;
        this.datestarted = datestarted;
        this.iscompleted = completed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDatestarted() {
        return datestarted;
    }

    public void setDatestarted(String datestarted) {
        this.datestarted = datestarted;
    }

    public boolean isCompleted() {
        return iscompleted;
    }

    public void setCompleted(boolean completed) {
        iscompleted = true;
        this.iscompleted = completed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
