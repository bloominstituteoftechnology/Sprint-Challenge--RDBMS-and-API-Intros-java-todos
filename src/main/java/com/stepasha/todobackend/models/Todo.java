package com.stepasha.todobackend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "todos")
public class Todo {

    Date date = new Date();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;
    private String description;
    private Date datestarted;
    @Transient
    public boolean iscompleted = false;
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties({"users"})
    private User user;


    public Todo(String description, Date datestarted, boolean completed){}
    public Todo(Date date, String description, Date datestarted, boolean completed) {
        this.date = date;
        this.description = description;
        this.datestarted = datestarted;
        this.completed = completed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatestarted() {
        return datestarted;
    }

    public void setDatestarted(Date datestarted) {
        this.datestarted = datestarted;
    }

    public boolean isCompleted() {
        return iscompleted;
    }

    public void setCompleted(boolean completed) {
        iscompleted = true;
        this.completed = completed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
