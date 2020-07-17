package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.repository.TodosRepository;
import com.lambdaschool.todos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service(value = "todoService")
public class TodoServiceImpl implements TodosService
{
    @Autowired
    TodosRepository todosrepos;

    @Autowired
    UserRepository userrepos;

    @Override
    public Todos addTodo(long userid, String description){
        Todos newTodo = new Todos();
        newTodo.setUser(userrepos.findById(userid)
            .orElseThrow(() -> new EntityNotFoundException("User with " + userid +  " not found")));
        newTodo.setDescription(description);

        return todosrepos.save(newTodo);
    }

    @Override
    public Todos markComplete(long todoid){
        Todos newTodo = todosrepos.findById(todoid)
            .orElseThrow(()-> new EntityNotFoundException("Could not find todo " + todoid));
        newTodo.setCompleted(true);

        return todosrepos.save(newTodo);
    }



}
