package com.lambdaschool.demo.models;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;


    private String description;
    private Date datestarted;
   /* private DateFormat datestarted = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//potentially hazardous*/

    @Transient
    public boolean completedSwitch; //Publicly available switch
    private Boolean completed;

    ///////////Foreign Key////////////////
    /*For Todos relationship with User, Many todos one user*/
    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;//User is the one and user has many todos



////////////////BOILER PLATE//////////////////////////////////
    public Todo(){
        //I hate that this is empty, but it has to be so
    }

    public Todo(String description, Date datestarted, User user) {
        this.description = description;
        this.datestarted = datestarted;
        this.user = user;
        this.completed = false;
    }

    //it is mighty morphing overloading time, if not then UserServiceImpl doesn't work
    public Todo(String description, Date datestarted,boolean completed, User user) {
        this.description = description;
        this.datestarted = datestarted;
        this.user = user;
        this.completed = completed;
    }

    public Boolean CompletedMethodSwitch(){
        return completed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatestarted() {
        return datestarted;
    }

    public void setDatestarted(Date datestarted) {
        this.datestarted = datestarted;
    }

    public void setCompleted(Boolean completed) {
        completedSwitch = true;
        this.completed = completed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
