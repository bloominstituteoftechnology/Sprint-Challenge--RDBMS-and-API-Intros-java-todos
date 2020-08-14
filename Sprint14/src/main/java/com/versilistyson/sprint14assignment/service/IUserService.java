package com.versilistyson.sprint14assignment.service;

import com.versilistyson.sprint14assignment.model.Todo;
import com.versilistyson.sprint14assignment.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


public interface IUserService {

    Set<User> findAll();

    User findById(long id);

    User saveUser(User newUser);

    Todo saveTodoByUserId(Todo newTodo, long userId);

    void deleteById(long id);

}
