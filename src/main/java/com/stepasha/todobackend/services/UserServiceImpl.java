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

  // for (Role r: user.getRoles()){
  //     Role newRole = roleService.findRoleById(r.getRoleid());
  //     newUser.getRoles().add(newRole);
  // }
    for(Todo td: user.getTodos()){
        Todo newTodo = new Todo(td.getDescription(), td.getDatestarted(), td.isCompleted());
        newUser.getTodos().add(newTodo);
    }



    return userRepo.save(newUser);
}
@Transactional
    @Override
    public User update(User user, long id) {
    User currentUser = findUserById(id);
    if (user.getUsername() != null) {
        currentUser.setUsername(user.getUsername());
    }
    if (user.getPrimaryemail() != null) {
        currentUser.setPrimaryemail(user.getPrimaryemail());
        if (user.getPassword() != null) {
            currentUser.setPassword(user.getPassword());
        }
    }
    return userRepo.save(currentUser);
}

    @Override
    public void delete(long id) {
        if (findUserById(id) != null){
            userRepo.deleteById(id);
        }
    }
}
