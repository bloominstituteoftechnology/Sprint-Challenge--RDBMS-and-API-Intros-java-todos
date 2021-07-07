package com.lambda.sprint;

import com.lambda.sprint.mode.Role;
import com.lambda.sprint.mode.Todo;
import com.lambda.sprint.mode.User;
import com.lambda.sprint.mode.UserRole;
import com.lambda.sprint.repo.RoleRepo;
import com.lambda.sprint.repo.TodoRepo;
import com.lambda.sprint.repo.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;

@Transactional
@Component
public class SeedData implements CommandLineRunner {
    RoleRepo rolerepos;
    UserRepo userrepos;
    TodoRepo todorepos;

    public SeedData(RoleRepo rolerepos, UserRepo userrepos, TodoRepo todorepos) {
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

        ArrayList<UserRole> users = new ArrayList<>();
        users.add(new UserRole(new User(), r2));
        User u1 = new User("barnbarn", "ILuvM4th!", users);
        u1.getTodo().add(new Todo("Finish java-orders-swagger", new Date(), u1));
        u1.getTodo().add(new Todo("Feed the turtles", new Date(), u1));
        u1.getTodo().add(new Todo("Complete the sprint challenge", new Date(), u1));


        userrepos.save(u1);

        ArrayList<UserRole> admins = new ArrayList<>();
        admins.add(new UserRole(new User(), r1));
        admins.add(new UserRole(new User(), r2));
        User u2 = new User("admin", "password", admins);
        u2.getTodo().add(new Todo("Walk the dogs", new Date(), u2));
        u2.getTodo().add(new Todo("provide feedback to my instructor", new Date(), u2));
        userrepos.save(u2);

        users = new ArrayList<>();
        users.add(new UserRole(new User(), r2));
        User u3 = new User("Bob", "password", users);
        userrepos.save(u3);

        users = new ArrayList<>();
        users.add(new UserRole(new User(), r2));
        User u4 = new User("Jane", "password", users);
        userrepos.save(u4);
    }
}