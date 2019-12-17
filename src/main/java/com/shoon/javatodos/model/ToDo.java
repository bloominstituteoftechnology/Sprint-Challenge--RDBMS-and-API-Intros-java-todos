package com.shoon.javatodos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "todos")
public class ToDo extends Auditable
{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long lIDtoDo;

    private String strDescription;
    private long lStarted;
    private boolean bCompleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"todoslist"})
    @JoinColumn(name = "userid")
    private User user;  // foreign key (one user to many todos) not null


    @OneToMany(mappedBy = "todo",
            cascade = CascadeType.ALL)
    @JsonIgnoreProperties("todo")
    private List<User> userTodos = new ArrayList<>();

    public ToDo(String strDescription, User newUser) {
        this.strDescription=strDescription;
        user=newUser;

    }

    public ToDo(String strDescription, Date date, User user) {
        this.strDescription=strDescription;
        this.user=user;
        lStarted=Long.parseLong(String.valueOf(date));
    }


    public long getlIDtoDo() {
        return lIDtoDo;
    }

    public void setlIDtoDo(long lIDtoDo) {
        this.lIDtoDo = lIDtoDo;
    }

    public String getStrDescription() {
        return strDescription;
    }

    public void setStrDescription(String strDescription) {
        this.strDescription = strDescription;
    }

    public long getlStarted() {
        return lStarted;
    }

    public void setlStarted(long lStarted) {
        this.lStarted = lStarted;
    }

    public boolean isbCompleted() {
        return bCompleted;
    }

    public void setbCompleted(boolean bCompleted) {
        this.bCompleted = bCompleted;
    }

    public User getUserID() {
        return user;
    }

    public void setUserID(User user) {
        this.user = user;
    }

    public List<User> getUserTodos() {
        return userTodos;
    }

    public void setUserTodos(List<User> userTodos) {
        this.userTodos = userTodos;
    }
}
