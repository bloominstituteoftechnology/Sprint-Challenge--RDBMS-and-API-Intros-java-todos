package com.shoon.javatodos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "usertodos")
public class UserToDos extends Auditable implements Serializable
{
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"todos", "hibernateLazyInitializer"})
    @JoinColumn(name = "userid")
    private User user;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"userToDos", "hibernateLazyInitializer"})
    @JoinColumn(name = "todoid")
    private ToDo todo;

    public UserToDos()
    {
    }

    public UserToDos(User user, ToDo todo)
    {
        this.user = user;
        this.todo = todo;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public ToDo getToDo()
    {
        return todo;
    }

    public void setToDo(ToDo todo)
    {
        this.todo = todo;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof UserToDos))
        {
            return false;
        }
        UserToDos userToDos = (UserToDos) o;
        return getUser().equals(userToDos.getUser()) &&
                getToDo().equals(userToDos.getToDo());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getUser(), getToDo());
    }
}
