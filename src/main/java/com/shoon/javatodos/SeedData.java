package com.shoon.javatodos;

// Vivek Vishwanath


import com.shoon.javatodos.model.Role;

import com.shoon.javatodos.model.ToDo;
import com.shoon.javatodos.model.User;
import com.shoon.javatodos.model.UserRoles;
import com.shoon.javatodos.repository.RoleRepository;
import com.shoon.javatodos.repository.ToDoRepository;
import com.shoon.javatodos.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;

@Transactional
@Component
public class SeedData implements CommandLineRunner {
    RoleRepository rolerepos;
    UserRepository userrepos;
    ToDoRepository todorepos;

    public SeedData(RoleRepository rolerepos, UserRepository userrepos, ToDoRepository todorepos) {
        this.rolerepos = rolerepos;
        this.userrepos = userrepos;
        this.todorepos = todorepos;
    }

    @Override
    public void run(String[] args) throws Exception {
        Role r1 = new Role("admin");
        Role r2 = new Role("user");

        rolerepos.save(r1);
        rolerepos.save(r2);

        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u1 = new User("barnbarn", "ILuvM4th!", users);
        Date date=new Date();
        ToDo newToDo=new ToDo("Finish java-orders-swagger", date, u1);
        u1.getToDoslist().add(newToDo);
        u1.getToDoslist().add(new ToDo("Feed the turtles", date, u1));
        u1.getToDoslist().add(new ToDo("Complete the sprint challenge", date, u1));
        userrepos.save(u1);

        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));
        admins.add(new UserRoles(new User(), r2));
        User u2 = new User("admin", "password", admins);
        u2.getToDoslist().add(new ToDo("Walk the dogs", date, u2));
        u2.getToDoslist().add(new ToDo("provide feedback to my instructor", date, u2));
        userrepos.save(u2);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u3 = new User("Bob", "password", users);
        userrepos.save(u3);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u4 = new User("Jane", "password", users);
        userrepos.save(u4);
    }
}