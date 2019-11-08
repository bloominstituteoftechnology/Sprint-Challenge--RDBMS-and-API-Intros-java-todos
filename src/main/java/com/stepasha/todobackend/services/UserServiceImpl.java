package com.stepasha.todobackend.services;

import com.stepasha.todobackend.models.Role;
import com.stepasha.todobackend.models.Todo;
import com.stepasha.todobackend.models.User;
import com.stepasha.todobackend.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Transactional
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userRepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public User findUserById(long id) {
        return userRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Could not find a costumer"));
    }
@Transactional
    @Override
    public User save(User user) {
    User newUser = new User();
    newUser.setUsername(user.getUsername());
    newUser.setPrimaryemail(user.getPrimaryemail());
    newUser.setPassword(user.getPassword());
    for(Todo td: user.getTodo()){
        Todo newTodo = new Todo(td.getDescription(), td.getDatestarted(), td.isCompleted());
        newUser.getTodo().add(newTodo);
    }
    
    return userRepo.save(newUser);
}

    @Override
    public User update(User user, long id) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
