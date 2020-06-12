package com.bensimpson.sprint2.models;


import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Todo {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long todoid;
    private String description;
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "userid",nullable = false)
    private User user;

    public Todo() {
    }

    public Todo(String description, boolean completed, User user) {
        this.description = description;
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

    @Override
    public String toString() {
        return "Todo{" +
                "todoid=" + todoid +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                ", user=" + user +
                '}';
    }
}
