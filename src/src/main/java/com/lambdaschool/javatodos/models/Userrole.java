package com.lambdaschool.javatodos.models;
//PAGE NOT COMPLETE, NEEDS WORK AT THE BOTTOM

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "userroles", uniqueConstraints = {@UniqueConstraint( columnNames = {"userid", "roleid"})})

public class Userrole extends Auditable implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties("userroles")
    //this may need to be rolename^

    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "roleid")
    @JsonIgnoreProperties("userroles")
    //I don't have userroles this may need to be rolename^
    private Role role;

    public Userrole(){

    }

    public Userrole(User user, Role role) {
        this.user = user;
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof Userrole))
        {
            return false;
        }
        Userrole userRole = (Userrole) o;
        return getUser().equals(userRole.getUser()) && getRole().equals(userRole.getRole());
    }


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
