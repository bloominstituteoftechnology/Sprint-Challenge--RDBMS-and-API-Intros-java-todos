package com.stepasha.todobackend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userid;
    @Column(nullable = false)
    private String username;
    private String primaryemail;
    private String password;

    @ManyToOne
    @JoinColumn(name = "todoid", nullable = false)
    @JsonIgnoreProperties("users")
    private Todo todo;

    @OneToMany(mappedBy = "users",
    cascade = CascadeType.ALL,
    orphanRemoval = true )
    private List<Todo> todos = new ArrayList<>();

    public User(){}
    public User(String username, String primaryemail, String password, Todo todo, List<Todo> todos) {
        this.username = username;
        this.primaryemail = primaryemail;
        this.password = password;
        this.todo = todo;
        this.todos = todos;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPrimaryemail() {
        return primaryemail;
    }

    public void setPrimaryemail(String primaryemail) {
        this.primaryemail = primaryemail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Todo getTodo() {
        return todo;
    }

    public void setTodo(Todo todo) {
        this.todo = todo;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }
}
