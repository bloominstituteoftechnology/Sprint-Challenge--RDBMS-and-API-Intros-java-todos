package com.lambdaschool.todos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * The entity allowing interaction with the todos table.
 */
@Entity
@Table(name = "todos")
public class Todo extends Auditable implements Serializable
{
    /**
     * The primary key (long) of the todos table.
     */
    @Id
    @Column(nullable = false,
        unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;

    @Id
    @ManyToOne
    @JoinColumn(name = "userid", nullable = false,
        unique = true)
    @JsonIgnoreProperties(value = "users", allowSetters = true)
    private User user;

    /**
     * The description (String) of the role. Cannot be null and must be unique.
     */
    @Column(nullable = false,
        unique = true)
    private String description;

    /**
     * Creates a join table joining Users and Todos in a Many-To-Many relationship.
     * Contains a List of Users Objects using this Role.
     */
    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = "todo", allowSetters = true)
    private Set<UserTodo> users = new HashSet<>();

    /**
     * Default Constructor used primarily by the JPA.
     */
    public Todo()
    {
    }

    /**
     * Given the description, create a new todo object. User gets added later
     *
     * @param name the name of the role in uppercase
     */
    public Todo(String description)
    {
        this.description = description;
    }


    public long getTodoid()
    {
        return todoid;
    }


    public void setTodoid(long todoid)
    {
        this.todoid = todoid;
    }


    public String getDescription()
    {
        return description;
    }


    public void setDescription(String description)
    {
        this.description = description;
    }


    public Set<UserTodo> getUsers()
    {
        return users;
    }


    public void setUsers(Set<UserTodo> users)
    {
        this.users = users;
    }

    @Override
    public boolean completed(Object o)
    {
        if (this == o)
        {
            return false;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        Todos that = (Todos) o;
        return ((this.todo == null) ? 0 : this.todo.getTodoid()) == ((that.todo == null) ? 0 : that.todo.getTodoid()) &&
            ((this.todo == null) ? 0 : this.todo.getTodoid()) == ((that.todo == null) ? 0 : that.todo.getTodoid());
    }

    @Override
    public int hashCode()
    {
        return 37;
    }
}