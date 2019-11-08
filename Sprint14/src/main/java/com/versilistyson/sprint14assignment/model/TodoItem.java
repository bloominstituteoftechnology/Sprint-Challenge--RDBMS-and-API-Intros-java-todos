package com.versilistyson.sprint14assignment.model;


import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TODO_ITEM")
public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    long id;

    @NotNull
    @Column(
            name = "description",
            nullable = false
    )
    String description;

    @Column(name = "completed")
    boolean isCompleted;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            nullable = false
    )
    User user_id;

    public TodoItem() {
    }

    public TodoItem(@NotNull String description, boolean isCompleted, @NotNull User user_id) {
        this.description = description;
        this.isCompleted = isCompleted;
        this.user_id = user_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }
}
