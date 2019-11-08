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
    @Column(nullable = false)
    private long userid;
    @Column(nullable = true)
    private String username;
    @Column(nullable = true)
    private String primaryemail;
  //  @Column(nullable = false)
    private String password;


    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }

    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnoreProperties("user")
    private List<Todo> todos = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "userroles",
            joinColumns = @JoinColumn(name = "userid"),
            inverseJoinColumns = @JoinColumn(name = "roleid")
    )
    @JsonIgnoreProperties("users")
    List<Role> roles = new ArrayList<>();

    public User(){}
    public User(String username, String primaryemail, String password) {
        this.username = username;
        this.primaryemail = primaryemail;
        this.password = password;



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


    //trying to set a role

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role r1) {
        roles.add(r1);
        r1.getUsers().add(this);
    }

    public List<Todo> getTodos() {
        return todos;
    }
    public void addTodo(Todo todo) {
        todos.add(todo);
    }


}
