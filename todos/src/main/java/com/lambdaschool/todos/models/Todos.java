package com.lambdaschool.todos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


@Entity
@Table(name = "todos")
public class Todos extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;

    private String description;

    private boolean completed = false;

    @ManyToOne
    @JoinColumn(name = "userid", nullable= false)
    @JsonIgnoreProperties(value = "todos", allowSetters = true)
    private User user;

    // default constructor

    public Todos()
    {

    }

    public Todos(User user, String description)
    {
        this.user = user;
        this.description = description;
    }
}
