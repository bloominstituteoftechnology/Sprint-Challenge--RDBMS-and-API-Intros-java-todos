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
        long id)
    {
        Todos currenttodos = todosrepos.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Todo " + id + " Not Found"));
        if (todos.getDescription() != null)
        {
            currenttodos.setDescription(todos.getDescription());
        }

        if (todos.getCompleted() == false)
        {
            currenttodos.setCompleted(todos.getCompleted());
        }
        //        if (todosrepos.findById(id)
//            .isPresent())
//        {
//            Todos todo = findTodosById(id);
//            todo.setCompleted(todo.getCompleted());
//            return todosrepos.save(todos);
//        } else
//        {
//            throw new EntityNotFoundException("Todo with id " + id + " Not Found!");
//        }
        return todosrepos.save(currenttodos);
    }

}
