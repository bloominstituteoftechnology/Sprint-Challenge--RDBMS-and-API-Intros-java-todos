package com.lambdaschool.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private String username;
    private String primaryemail;
    private String password; //stored in plain text for demo purposes
    ///////////Foreign Keys////////////////
    /*For User relationship with Todos, One user Many todos*/
    @OneToMany(
            //Mapped by essential means what does the other object call you, thanks Vivek!
            mappedBy = "user",//The tod0 class calls the USER user
            cascade = CascadeType.ALL, //saves, updates, deletes items without you having to individually do them yourself
            orphanRemoval = true //if user goes do I want the todos in my list to go? the answer is yes
    )
            @JsonIgnoreProperties("user")//this prevents a never ending loop, must be the same name as the mappedBy above and the same name that the Tod0 class calls it
    List<Todo> todos = new ArrayList<>();




    ////////////////BOILER PLATE//////////////////////////////////
    public User (){}

    public User(String username, String primaryemail, String password) {
        this.username = username;
        this.primaryemail = primaryemail;
        this.password = password;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
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
}
