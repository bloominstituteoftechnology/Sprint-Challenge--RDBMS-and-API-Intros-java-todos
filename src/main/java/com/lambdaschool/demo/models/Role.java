package com.lambdaschool.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long roleid;

    private String rolename;



}
