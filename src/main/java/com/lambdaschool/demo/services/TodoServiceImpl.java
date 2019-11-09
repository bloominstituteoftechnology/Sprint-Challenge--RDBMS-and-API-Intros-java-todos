package com.lambdaschool.demo.services;

import com.lambdaschool.demo.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service(value = "todoService")//turns this into a bean
public class TodoServiceImpl implements TodoService {



    @Override
    public Todo updateTodo(Todo todo, long id) {
        Todo currentTodo = findUserTodosById(id) ;
       if(todo.getUser() != null){

       }
    }



}
