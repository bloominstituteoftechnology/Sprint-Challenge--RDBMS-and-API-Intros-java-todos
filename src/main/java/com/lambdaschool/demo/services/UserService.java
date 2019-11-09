package com.lambdaschool.demo.services;

import com.lambdaschool.demo.models.Todo;
import com.lambdaschool.demo.models.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(long id);

    User save(User user);
    User update (User user, long id );



    void delete(long id);

}