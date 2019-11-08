package com.lambdaschool.demo.services;

import com.lambdaschool.demo.models.Todo;
import com.lambdaschool.demo.models.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserTodosById(long id);
    User addUser(User user);
    User addTodoToUer(Todo todo, long id );
    void deleteUser(long id);

}
