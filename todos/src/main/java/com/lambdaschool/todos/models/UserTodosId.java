package com.lambdaschool.todos.models;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserTodosId implements Serializable {

    private long user;

    private long todo;

    public UserTodosId()
    {
    }

    public long getUser()
    {
        return user;
    }

    public void setUser(long user)
    {
        this.user = user;
    }

    public long getTodo()
    {
        return todo;
    }

    public void setTodo(long todo)
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
        // boolean temp = (o.getClass() instanceof Class);
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        UserTodosId that = (UserTodosId) o;
        return user == that.user &&
            todo == that.todo;
    }

    @Override
    public int hashCode()
    {
        return 37;
    }
}