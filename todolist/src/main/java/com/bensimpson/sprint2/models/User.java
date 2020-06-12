package com.bensimpson.sprint2.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long userid;

    @Column(nullable = false,unique=true)
    private String username;

    private String primaryemail;
    private String password;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Todo> todos =  new ArrayList<>();



}
