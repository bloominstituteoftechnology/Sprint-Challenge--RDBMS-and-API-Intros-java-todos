package com.versilistyson.sprint14assignment.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public long id;

    @Column(unique = true)
    public String username;

    @Column(name = "primary_email",unique = true)
    public String primaryEmail;

    @NotNull
    @Column(nullable = false)
    public String password;

    @Column(
            name = "todo_items"
    )
    @OneToMany(mappedBy = "user_id")
    public Set<TodoItem> todoItems;

    @ManyToMany
    @JoinTable(
            name = "USER_ROLE",
            joinColumns = @JoinColumn(name="user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="role_id", referencedColumnName = "id")
    )
    public Set<Role> roles;

    public User() {

    }

    public User(String username, String primaryEmail, @NotNull String password, Set<TodoItem> todoItems, Set<Role> roles) {
        this.username = username;
        this.primaryEmail = primaryEmail;
        this.password = password;
        this.todoItems = todoItems;
        this.roles = roles;
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

    public Set<TodoItem> getTodoItems() {
        return todoItems;
    }

    public void setTodoItems(Set<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
