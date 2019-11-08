package com.stepasha.todobackend.services;

import com.stepasha.todobackend.models.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User findUserById(long id);

    User save(User user);
    User update(User user, long id);
    void delete(long id);

}
