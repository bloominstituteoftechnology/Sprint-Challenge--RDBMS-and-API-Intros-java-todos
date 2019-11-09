package com.lambdaschool.demo.services;

import com.lambdaschool.demo.models.Todo;
import com.lambdaschool.demo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Transactional
@Service(value = "todoService")//turns this into a bean
public class TodoServiceImpl implements TodoService {

    @Autowired
    TodoRepository todorepos;

    @Autowired
    UserService userService;

    @Override
    public Todo getTodoById(long id) {
        return todorepos.findById(id).orElseThrow(()-> new EntityNotFoundException("Todo " + id + " not found"));
    }

    @Override
    public Todo updateTodo(Todo todo, long id) {
        Todo currentTodo = getTodoById(id) ;
       if(todo.getUser() != null){

       }
    }




}
