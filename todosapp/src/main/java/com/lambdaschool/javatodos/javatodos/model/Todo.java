package com.lambdaschool.javatodos.javatodos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="todos")
public class Todo
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoId;

    @Column(nullable = false)
    private String todo;

    private Date dateStarted;
    private boolean completed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", nullable = false)
    @JsonIgnoreProperties("todo")
    private User user;

    public Todo()
    {
    }

    public Todo(String todo, Date dateStarted, User user)
    {
        this.todo = todo;
        this.dateStarted = dateStarted;
        this.user = user;
    }

    public long getTodoId()
    {
        return todoId;
    }

    public void setTodoId(long todoId)
    {
        this.todoId = todoId;
    }

    public String getTodo()
    {
        return todo;
    }

    public void setTodo(String todo)
    {
        this.todo = todo;
    }

    public Date getDateStarted()
    {
        return dateStarted;
    }

    public void setDateStarted(Date dateStarted)
    {
        this.dateStarted = dateStarted;
    }

    public boolean isCompleted()
    {
        return completed;
    }

    public void setCompleted(boolean completed)
    {
        this.completed = completed;
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
