package com.stepasha.todobackend.services;

import com.stepasha.todobackend.models.Role;
import com.stepasha.todobackend.models.Todo;
import com.stepasha.todobackend.models.User;
import com.stepasha.todobackend.repositories.RoleRepo;
import com.stepasha.todobackend.repositories.TodoRepo;
import com.stepasha.todobackend.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepository;
    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleRepo roleRepo;




    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public User findUserById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User with ID: " + id + " does not exist"));
    }

    @Transactional
    @Override
    public User save(User user) {
        User newUser = new User();

        newUser.setPassword(user.getPassword());
        newUser.setEmail(user.getEmail());
        newUser.setUsername(user.getUsername());

        for (Todo t : user.getTodos()) {
            Todo newTodo = new Todo(t.getDescription(), t.getDatetime(),  newUser);
            newUser.getTodos().add(newTodo);
        }

    for (Role r : user.getRoles()) {
        Role newRole = roleService.findRoleById(r.getRoleid());
        newUser.getRoles().add(newRole);
    }

        return userRepository.save(newUser);
    }

    @Override
    public User update(User user, long id) {
        User updateUser = findUserById(id);
if (user.getPassword() != null) {
    updateUser.setPassword(user.getPassword());
}
if (user.getEmail() !=null) {
    updateUser.setEmail(user.getEmail());
}
if (user.getUsername() != null) {
    updateUser.setUsername(user.getUsername());
}
if(user.getTodos() != null) {
    for (Todo t : user.getTodos()) {
        Todo newTodo = new Todo(t.getDescription(), t.getDatetime(),  updateUser);
        updateUser.getTodos().add(newTodo);
    }
}
if (user.getRoles() != null) {
    for (Role r : user.getRoles()) {
        Role newRole = roleRepo.findById(r.getRoleid()).orElse(r);
        updateUser.getRoles().add(newRole);
    }
}
        return null;
    }

    @Transactional
    @Override
    public void delete(long id) {
        if (findUserById(id) != null) {
            userRepository.deleteById(id);
        }
    }
}
