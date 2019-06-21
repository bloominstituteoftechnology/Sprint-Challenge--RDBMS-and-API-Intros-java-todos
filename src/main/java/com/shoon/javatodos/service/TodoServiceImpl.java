package com.shoon.javatodos.service;

import com.shoon.javatodos.model.ToDo;

import com.shoon.javatodos.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service(value = "todoService")
public class TodoServiceImpl implements TodoService
{
    @Autowired
    private ToDoRepository todoRepos;

    @Transactional
    @Override
    public ToDo update(ToDo todo, long id)
    {
        ToDo currentTodo = todoRepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
        if (todo.getStrDescription() != null)
        {
            currentTodo.setStrDescription(todo.getStrDescription());
        }

        return todoRepos.save(currentTodo);
    }


}
