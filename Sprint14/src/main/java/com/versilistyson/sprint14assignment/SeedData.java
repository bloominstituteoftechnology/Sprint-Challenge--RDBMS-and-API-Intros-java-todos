package com.versilistyson.sprint14assignment;

import com.versilistyson.sprint14assignment.model.Role;
import com.versilistyson.sprint14assignment.model.Todo;
import com.versilistyson.sprint14assignment.model.User;
import com.versilistyson.sprint14assignment.service.RoleService;
import com.versilistyson.sprint14assignment.service.TodoService;
import com.versilistyson.sprint14assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Date;

@Transactional
@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    RoleService roleService;

    @Autowired
    TodoService todoService;

    @Autowired
    UserService userService;

    @Override
    public void run(String[] args) throws Exception {



        User u1 = new User(
                "adming",
                "anemail",
                "a pasword"
        );


        u1.getTodo().add(
                new Todo(
                        "Something",
                        new Date(),
                        u1
                )
        );
        u1.getTodo().add(
                new Todo(
                        "Yada",
                        new Date(),
                        u1
                )
        );
        u1.getTodo().add(
                new Todo(
                        "Bleh",
                        new Date(),
                        u1
                )
        );

        User u2 = new User("cinnamon",
                "1234567",
                "cinnamon@lambdaschool.local");

        u2.getTodo()
                .add(new Todo("Walk the dogs",
                        new Date(),
                        u2));
        u2.getTodo()
                .add(new Todo("provide feedback to my instructor",
                        new Date(),
                        u2));
        userService.saveUser(u2);

        // user
        User u3 = new User("barnbarn",
                "ILuvM4th!",
                "barnbarn@lambdaschool.local");

        userService.saveUser(u3);


        User u4 = new User("puttat",
                "password",
                "puttat@school.lambda");

        userService.saveUser(u4);

        User u5 = new User("misskitty",
                "password",
                "misskitty@school.lambda");
        userService.saveUser(u5);
    }
}
