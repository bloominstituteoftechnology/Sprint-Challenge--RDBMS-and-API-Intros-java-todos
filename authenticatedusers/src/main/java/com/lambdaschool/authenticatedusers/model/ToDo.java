package com.lambdaschool.authenticatedusers.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "todos")
public class ToDo extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todosid;

    @Column(nullable = false)
    private String todo;


    @Column(nullable = false)
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid",
                nullable = false)
    @JsonIgnoreProperties({"quotes", "hibernateLazyInitializer"})
    private User user;



    public ToDo(){  }

    public ToDo(String todo, User user){
        this.todo = todo;
        this.user = user;
        this.date= new Date();
    }

    public ToDo(String todo, Date date, User user){
        this.todo = todo;
        this.user = user;
        this.date=date;
    }

    public long getToDosid()
    {
        return todosid;
    }

    public void setToDosid(long todosid)
    {
        this.todosid = todosid;
    }

    public String getToDo()
    {
        return todo;
    }

    public void setToDo(String todo)
    {
        this.todo = todo;
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