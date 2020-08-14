package com.versilistyson.sprint14assignment.service;

import com.versilistyson.sprint14assignment.model.Todo;
import com.versilistyson.sprint14assignment.model.User;
import com.versilistyson.sprint14assignment.repository.TodoRepository;
import com.versilistyson.sprint14assignment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import java.util.List;
import java.util.Set;

@Service(value = "userService")
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    TodoRepository todoRepo;

    @Override
    public Set<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User findById(long id) {
        User user = userRepo.findById(id);
        if(user == null) {
            throw new EntityNotFoundException();
        }
        return user;
    }

    @Override
    public User saveUser(User newUser) {
        return userRepo.save(newUser);
    }

    @Transactional
    @Override
    public Todo saveTodoByUserId(Todo newTodo, long userId) {
        User user = findById(userId);
        Todo todo = new Todo(newTodo.getDescription(), newTodo.getDatetime(), user);
        return todoRepo.save(todo);
    }


    @Override
    public void deleteById(long id) {
        if(findById(id) != null) {
            userRepo.deleteById(id);
        }
    }


}
