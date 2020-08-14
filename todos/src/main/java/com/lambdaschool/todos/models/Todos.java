package com.lambdaschool.todos.models;
/*
    todoid primary key, not null long
    description string, not null
    completed boolean. Note that for all new todos, default completed to false
    userid foreign key (one user to many todos) not null
    All tables must have the standard 4 auditing fields in place and working, being populated: created on, created by, last modified on, last modified by. The auditing usernames will all default to llama.
    USERS have a one to many relationship with TODOS.
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "todos")
@JsonIgnoreProperties(value = {"hasvalueforcompleted"}) // The hasvalueforsalary field will be used internally to the application to determine if a salary value came from the frontend client or should be treated as NULL
public class Todos extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;

    @Column(nullable = false)
    private String description;

    @Transient // will not be saved in the database and is just part of the Java object
    public boolean hasvalueforcompleted = false;
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties(value = "todos", allowSetters = true)
    private User user;

    public Todos()
    {
    }

    public Todos(
        User user,
        String description)
    {
        this.user = user;
        this.description = description;
        this.completed = false;
    }

    public long getTodoid()
    {
        return todoid;
    }

    public void setTodoid(long todoid)
    {
        this.todoid = todoid;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public boolean getCompleted()
    {
        return completed;
    }

    public void setCompleted(boolean completed)
    {
        hasvalueforcompleted = true;
        this.completed = completed;
        /*
        * Setters are always used to make the conversion from the JSON received
        * from the frontend client to Java objects. We take advantage of that fact
        * by setting hasvalueforsalary = true in the setter for salary. If salary
        * is not included in the JSON from the frontend client, setSalary is never
        * called and hasvalueforsalary remains false
        * */
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
