package com.shoon.javatodos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// User is considered the parent entity of all - the Grand Poobah!

@Entity
@Table(name = "users")
public class User extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userid;

    @Column(nullable = false,
            unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private List<UserRoles> userRoles = new ArrayList<>();


    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private ArrayList<ToDo> todoslist = new ArrayList<>();

    public User()
    {
    }

    public User(String username, String password, List<UserRoles> userRoles, ArrayList<ToDo> todos)
    {
        this.username = username;
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(password);
        this.userRoles = userRoles;
    }

    public User(String username, String password, List<UserRoles> userRoles)
    {
        this.username = username;
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(password);
        this.userRoles = userRoles;
    }

    public ArrayList<ToDo> getTodoslist()
    {
        return (ArrayList<ToDo>)todoslist;
    }

    public void setTodoslist(ArrayList<ToDo> todoslist)
    {
        this.todoslist = todoslist;
    }

    public long getUserid()
    {
        return userid;
    }

    public ArrayList<ToDo> getTodos()
    {
        return todoslist;
    }

    public void setTodos(ArrayList<ToDo> todos)
    {
        this.todoslist = todos;
    }

    public void setUserid(long userid)
    {
        this.userid = userid;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(password);
    }
    public void setPasswordNoEncrypt(String password)
    {
        this.password = password;
    }

    public List<UserRoles> getUserRoles()
    {
        return userRoles;
    }

    public void setUserRoles(List<UserRoles> userRoles)
    {
        this.userRoles = userRoles;
    }

    public List<SimpleGrantedAuthority> getAuthority()
    {
        List<SimpleGrantedAuthority> rtnList = new ArrayList<>();

        for (UserRoles r : this.userRoles)
        {
            String myRole = "ROLE_" + r.getRole().getName().toUpperCase();
            rtnList.add(new SimpleGrantedAuthority(myRole));
        }
        return rtnList;
    }

}
