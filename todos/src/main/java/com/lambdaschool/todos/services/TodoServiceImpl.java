package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.repository.TodosRepository;
import com.lambdaschool.todos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "todoService")
public class TodoServiceImpl implements TodosService
{
    @Autowired
    TodosRepository todosrepos;

    @Autowired
    UserRepository userrepos;

    @Override
    public Todos save(Todos todos){
        return null;
    }

    @Override
    public void markComplete(long todoid){
        Todos completedTodo = todosrepos.findById(todoid)
            .orElseThrow(()-> new EntityNotFoundException("Could not find todo " + todoid));
        todosrepos.save(completedTodo);

    }
}
