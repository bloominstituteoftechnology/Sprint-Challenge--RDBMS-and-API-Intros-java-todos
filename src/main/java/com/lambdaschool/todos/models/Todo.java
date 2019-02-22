package com.lambdaschool.todos.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long todoid;

    private String description;

    private Date dateStarted;

    private boolean completed;

    @ManyToOne
    @JoinColumn(name="userid", nullable = false)
    @JsonIgnore
    private User user;

}
