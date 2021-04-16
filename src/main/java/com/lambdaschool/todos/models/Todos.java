package com.lambdaschool.todos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
@Table(name = "todos")
public class Todos extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;

    @Column(nullable = false)
    private String description;

    @Transient
    public boolean completed = false;

    @ManyToOne
    @JoinColumn(name = "userid",
                nullable = false)
    @JsonIgnoreProperties(value = "users", allowSetters = true)
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
    }

    public long getTodoid()
    {
        return todoid;
    }

    public void setTodoid(long todoid)
    {
        this.todoid = todoid;
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

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

}
