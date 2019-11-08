package com.versilistyson.sprint14assignment.service;

import com.versilistyson.sprint14assignment.model.Todo;
import com.versilistyson.sprint14assignment.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public interface IUserService {

    List<User> findAll();

    User findById(long id);

    User save(User newUser);

    Todo saveTodo(Todo newTodoItem);

    User delete(long id);

}
