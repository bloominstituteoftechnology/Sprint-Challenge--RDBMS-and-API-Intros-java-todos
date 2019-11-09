package com.stepasha.todobackend.services;

import com.stepasha.todobackend.models.Todo;
import com.stepasha.todobackend.repositories.TodoRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Transactional
@Service(value = "todoService")//turns this into a bean
public class TodoServiceImpl implements TodoService {

    @Autowired
    TodoRepo todorepos;

    @Autowired
    UserService userService;

    @Override
    public Todo getTodoById(long id) {
        return todorepos.findById(id).orElseThrow(() -> new EntityNotFoundException("Todo " + id + " not found"));
    }

    @Override
    public Todo save(Todo todo, long userid) {
        Todo newTodo = new Todo();
        newTodo.setDescription(todo.getDescription());//set get like John says
        newTodo.setUser(todo.getUser());
        newTodo.setDatetime(todo.getDatetime());

        return todorepos.save(newTodo);
    }


    @Transactional
    @Override
    public Todo updateTodo(Todo todo, long id) {
        Todo updateTodo = getTodoById(id);

        if(todo.getDatetime()!=null){
            updateTodo.setDatetime(todo.getDatetime());
        }
        if (todo.getDescription() != null) {
            updateTodo.setDescription(todo.getDescription());

        }
        if (todo.getUser() != null) {
            updateTodo.setUser(userService.findUserById(todo.getUser().getUserid()));

        }

        if (todo.getCompleted()) {
            updateTodo.setCompleted(todo.getCompleted());
        }

        return todorepos.save(updateTodo);
    }


}
