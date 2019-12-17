package com.lambdaschool.authenticatedusers.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "todos")
public class ToDo extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ToDosid;

    @Column(nullable = false)
    private String toDo;

    @Column(nullable = false)
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users",
            nullable = false)
    @JsonIgnoreProperties({"toDos", "hibernateLazyInitializer"})
    private User user;

    public ToDo()
    {
        this.date= new Date();

    }

    public ToDo(String ToDo, User user)
    {
        this.toDo = ToDo;
        this.user = user;
        this.date= new Date();
    }

    public ToDo(String todo, Date date, User user) {
        this.toDo = todo;
        this.user = user;
        this.date= new Date();
    }

    public Date getDate() {
        return date;
    }


    public long getToDoID()
    {
        return ToDosid;
    }

    public void setToDoID(long ToDosid)
    {
        this.ToDosid = ToDosid;
    }

    public String getToDo()
    {
        return toDo;
    }

    public void setToDo(String ToDo)
    {
        this.toDo = ToDo;
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