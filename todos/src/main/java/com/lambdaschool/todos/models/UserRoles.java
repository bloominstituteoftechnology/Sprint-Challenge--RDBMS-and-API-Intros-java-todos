package com.lambdaschool.todos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "userroles",
       //when you combine two columns you want to make sure there is uniqueness
       uniqueConstraints = {@UniqueConstraint(columnNames = {"userid", "roleid"})})
//serializable is needed to make json objects because we have a composite key
public class UserRoles extends Auditable implements Serializable
{
    //composite key is a key made our of two foreign keys
    @Id
    @ManyToOne
    //foreign key
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties("userroles")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "roleid")
    @JsonIgnoreProperties("userroles")
    private Role role;

    public UserRoles()
    {
    }

    public UserRoles(User user,
                     Role role)
    {
        this.user = user;
        this.role = role;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Role getRole()
    {
        return role;
    }

    public void setRole(Role role)
    {
        this.role = role;
    }

    //need to override equals when ever we have serializable
    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof UserRoles))
        {
            return false;
        }
        UserRoles userRoles = (UserRoles) o;
        return getUser().equals(userRoles.getUser()) && getRole().equals(userRoles.getRole());
    }

    //need to override hashcode when ever we have serializable
    @Override
    public int hashCode()
    {
        return Objects.hash(getUser(),
                            getRole());
    }

    @Override
    public String toString()
    {
        return "UserRoles{" + "user=" + user.getUserid() + ", role=" + role.getRoleid() + '}';
    }
}
