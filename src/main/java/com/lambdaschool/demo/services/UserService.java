package com.lambdaschool.demo.services;

import com.lambdaschool.demo.models.Todo;
import com.lambdaschool.demo.models.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    Todo getUserTodosById(long id);
    User addUser(User user);
    Todo addTodoToUer(Todo todo, long id );
    void deleteUser(long id);

}
