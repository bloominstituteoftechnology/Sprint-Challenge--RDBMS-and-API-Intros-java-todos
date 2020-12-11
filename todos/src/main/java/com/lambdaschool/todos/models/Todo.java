package com.lambdaschool.todos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lambdaschool.todos.models.UserTodos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "todos")
public class Todo extends Auditable implements Serializable
{
    @Id
    @Column(nullable = false,
        unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;

    @Column(nullable = false,
        unique = true)
    private String description;

    @OneToMany(mappedBy = "users",
        cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = "users",
        allowSetters = true)
    private Set<UserTodos> users = new HashSet<>();

    public Todo()
    {
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


    public Set<UserTodos> getUsers()
    {
        return users;
    }


    public void setUsers(Set<UserTodos> users)
    {
        this.users = users;
    }
}