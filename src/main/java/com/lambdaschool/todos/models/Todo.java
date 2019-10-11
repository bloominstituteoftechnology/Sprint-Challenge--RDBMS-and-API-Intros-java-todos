package com.lambdaschool.todos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Email;

public class Todo extends AudiTable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;


    @ManyToOne
    @JoinColumn(name = "todoid",
                nullable = false)
    @JsonIgnoreProperties("todos")
    private User user;

    public Todo()
    {
    }

    public Todo(User user)
    {
        this.user = user;
    }

    public long getTodoid()
    {
        return todoid;
    }

    public void setTodoid(long todoid)
    {
        this.todoid = todoid;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}
