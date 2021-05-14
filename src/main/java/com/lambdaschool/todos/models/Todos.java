package com.lambdaschool.todos.models;

import javax.persistence.*;

@Entity
@Table(name = "todos")
public class Todos extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;
    private String description;
    private boolean completed = false;

    private User user;

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

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Todos() {
    }

    public getTodos(String description, boolean completed, User user) {
        this.description = description;
        this.completed = completed;
        this.user = user;
    }
}
