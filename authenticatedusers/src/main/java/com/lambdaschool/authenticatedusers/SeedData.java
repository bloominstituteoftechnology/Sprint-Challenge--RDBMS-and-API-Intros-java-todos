package com.lambdaschool.authenticatedusers;
// provided by Vivek Vishwanath

import com.lambdaschool.authenticatedusers.model.Role;
import com.lambdaschool.authenticatedusers.model.ToDo;
import com.lambdaschool.authenticatedusers.model.User;
import com.lambdaschool.authenticatedusers.model.UserRoles;
import com.lambdaschool.authenticatedusers.repository.RoleRepository;
import com.lambdaschool.authenticatedusers.repository.ToDoRepository;
import com.lambdaschool.authenticatedusers.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
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

        ArrayList<UserRoles> userroles = new ArrayList<>();
        User u1 = new User("admin", "password");
  //      User u1 = new User("barnbarn", "ILuvM4th!");
        userroles.add(new UserRoles(u1, r1));
        u1.setUserRoles(userroles);

        u1.getToDos().add(new ToDo("Finish java-orders-swagger", new Date(), u1));
      //  u1.getToDos().add(new ToDo("Feed the turtles", new Date(), u1));
      //  u1.getToDos().add(new ToDo("Complete the sprint challenge", new Date(), u1));

        userrepos.save(u1);

  /*      ArrayList<UserRoles> admins = new ArrayList<>();
        User u2 = new User("admin", "password", admins);
        u2.getToDos().add(new ToDo("Walk the dogs", new Date(), u2));
        u2.getToDos().add(new ToDo("provide feedback to my instructor", new Date(), u2));
        admins.add(new UserRoles(u2, r1));
        admins.add(new UserRoles(u2, r2));

        userrepos.save(u2);

        users = new ArrayList<>();

        User u3 = new User("Bob", "password", users);
        users.add(new UserRoles(u3, r2));
        userrepos.save(u3);

        users = new ArrayList<>();

        User u4 = new User("Jane", "password", users);
        users.add(new UserRoles(u4, r2));
        userrepos.save(u4);*/
    }
}
