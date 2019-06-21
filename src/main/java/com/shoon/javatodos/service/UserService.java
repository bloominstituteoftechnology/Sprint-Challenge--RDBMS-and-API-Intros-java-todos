package com.shoon.javatodos.service;


import com.shoon.javatodos.model.ToDo;
import com.shoon.javatodos.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findUserByName(String name);

    User findUserById(long id);

    void delete(long id);

    User save(User user);

    User update(User user, long id);

    ToDo addTodo(ToDo todo, long id);
}