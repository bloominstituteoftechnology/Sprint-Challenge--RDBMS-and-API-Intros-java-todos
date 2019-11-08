package com.lambdaschool.demo.services;

import com.lambdaschool.demo.models.Todo;
import com.lambdaschool.demo.models.User;
import com.lambdaschool.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userrepos;

    @Override
    public List<User> getAllUsers() {
        List<User> list = new ArrayList <>();
        userrepos.findAll().iterator().forEachRemaining(list::add);//comes back as iterator then converts to arraylist
        return list;
    }

    @Override
    public Todo getUserTodosById(long id) {
        return null;
    }

    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public Todo addTodoToUer(Todo todo, long id) {
        return null;
    }

    @Override
    public void deleteUser(long id) {

    }
}
