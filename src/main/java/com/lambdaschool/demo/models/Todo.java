package com.lambdaschool.demo.models;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;

    private String description;
    private DateFormat datestarted = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//potentially hazardous
    private Boolean completed;

    ///////////Foreign Key////////////////
    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;//User is the one and user has many todos

////////////////BOILER PLATE//////////////////////////////////
    public Todo(){
        //I hate that this is empty, but it has to be so
    }

    public Todo(String description, DateFormat datestarted, Boolean completed, User user) {
        this.description = description;
        this.datestarted = datestarted;
        this.completed = completed;
        this.user = user;
    }

    public long getTodoid() {
        return todoid;
    }

    public void setTodoid(long todoid) {
        this.todoid = todoid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DateFormat getDatestarted() {
        return datestarted;
    }

    public void setDatestarted(DateFormat datestarted) {
        this.datestarted = datestarted;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
