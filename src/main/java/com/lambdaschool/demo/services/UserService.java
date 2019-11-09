package com.lambdaschool.demo.services;

import com.lambdaschool.demo.models.Todo;
import com.lambdaschool.demo.models.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserTodosById(long id);

    User save(User user);
    User addTodoToUser(Todo todo, long id );



    void delete(long id);

}
