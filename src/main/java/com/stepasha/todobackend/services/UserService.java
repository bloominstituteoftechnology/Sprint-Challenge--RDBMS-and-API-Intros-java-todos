package com.stepasha.todobackend.services;

import com.stepasha.todobackend.models.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User findUserById(long id);

}
