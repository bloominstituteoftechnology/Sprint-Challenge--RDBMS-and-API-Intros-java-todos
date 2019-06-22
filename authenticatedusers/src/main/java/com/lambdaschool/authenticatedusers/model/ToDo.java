package com.lambdaschool.authenticatedusers.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "quotes")
public class ToDo extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long quotesid;

    @Column(nullable = false)
    private String quote;

    @Column(nullable = false)
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid",
            nullable = false)
    @JsonIgnoreProperties({"quotes", "hibernateLazyInitializer"})
    private User user;

    public ToDo()
    {
        this.date= new Date();

    }

    public ToDo(String quote, User user)
    {
        this.quote = quote;
        this.user = user;
        this.date= new Date();
    }

    public ToDo(String quote, Date date, User user) {
        this.quote = quote;
        this.user = user;
        this.date= new Date();
    }

    public Date getDate() {
        return date;
    }


    public long getToDoid()
    {
        return quotesid;
    }

    public void setToDoid(long quotesid)
    {
        this.quotesid = quotesid;
    }

    public String getToDo()
    {
        return quote;
    }

    public void setToDo(String quote)
    {
        this.quote = quote;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}