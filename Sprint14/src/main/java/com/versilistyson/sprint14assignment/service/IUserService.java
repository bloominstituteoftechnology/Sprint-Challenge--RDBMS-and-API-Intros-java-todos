package com.versilistyson.sprint14assignment.service;

import com.versilistyson.sprint14assignment.model.TodoItem;
import com.versilistyson.sprint14assignment.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public interface IUserService {

    List<User> findAll();

    User findUserById(long id);

    User addUser();

    TodoItem addTodo(long id);

    User deleteUser(long id);

}
