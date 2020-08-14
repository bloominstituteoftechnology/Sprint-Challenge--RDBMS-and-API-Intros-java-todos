package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.models.User;
import com.lambdaschool.todos.repository.TodosRepository;
import com.lambdaschool.todos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Objects;

@Transactional
@Service(value = "todosService")
public class TodosServiceImpl implements TodosService
{
    @Autowired
    private TodosRepository todosrepos;

    @Override
    public void markComplete(long todoid)
    {
    }

    @Override
    public Todos findTodosById(long id)
    {
        return todosrepos.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Todo with id " + id + " Not Found!"));
    }

    @Transactional
    @Override
    public Todos update(
        Todos todos,
        long todosid)
    {
        Todos currenttodos = todosrepos.findById(todosid)
            .orElseThrow(() -> new EntityNotFoundException("Todo " + todosid + " Not Found"));
        if (todos.getDescription() != null) //if i got a value, set to currenttodos description
        {
            currenttodos.setDescription(todos.getDescription());
        }

        if (todos.hasvalueforcompleted)
        {
            currenttodos.setCompleted(true);
        }

        return todosrepos.save(currenttodos);
    }
}
