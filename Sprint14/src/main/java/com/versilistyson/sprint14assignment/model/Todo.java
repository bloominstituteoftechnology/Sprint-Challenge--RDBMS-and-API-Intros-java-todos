package com.versilistyson.sprint14assignment.model;


import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "TODO")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long id;

    @NotNull
    @Column(
            name = "description",
            nullable = false
    )
    String description;

    private Date datetime;

    @Column(
            name = "completed",
            nullable = false
    )
    private boolean isCompleted = false;

    @Transient
    public boolean wasBooleanValueChanged = false;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            nullable = false
    )
    private User user_id;

    public Todo() {
    }

    public Todo(@NotNull String description, Date datetime, @NotNull User user_id) {
        this.description = description;
        this.datetime = datetime;
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
        wasBooleanValueChanged = true;
        this.isCompleted = completed;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}
