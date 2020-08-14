package com.versilistyson.sprint14assignment.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(unique = true)
    private String username;

    @Column(name = "primary_email",unique = true)
    private String primaryEmail;

    @NotNull
    @Column(nullable = false)
    private String password;

    @Column(
            name = "todos"
    )
    @OneToMany(
            mappedBy = "user_id",
            cascade = CascadeType.ALL
    )
    private List<Todo> todos = new ArrayList<>();

    @ManyToMany
    @JsonIgnoreProperties("user")
    @JoinTable(
            name = "USER_ROLE",
            joinColumns = @JoinColumn(name="user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="role_id", referencedColumnName = "id")
    )
    private List<Role> roles = new ArrayList<>();

    public User() {

    }

    public User(String username,@NotNull String password, String primaryEmail) {
        this.username = username;
        this.primaryEmail = primaryEmail;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPrimaryEmail() {
        return primaryEmail;
    }

    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Todo> getTodo() {
        return todos;
    }

    public void setTodoItems(List<Todo> todoItems) {
        this.todos = todoItems;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void addTodo(Todo todo) {
        todos.add(todo);
    }

    public void addRole(Role role){
            roles.add(role);
            role.getUsers().add(this);
    }
}
