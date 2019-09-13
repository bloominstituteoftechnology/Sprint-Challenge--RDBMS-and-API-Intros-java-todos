package com.lambdaschool.javatodos.javatodos.service;

import com.lambdaschool.javatodos.javatodos.model.Todo;
import com.lambdaschool.javatodos.javatodos.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "todoService")
public class TodoServiceImpl implements TodoService
{
    @Autowired
    private ToDoRepository todorepos;

    @Override
    public List<Todo> findAll()
    {
        List<Todo> list = new ArrayList<>();
        todorepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Todo findById(long id)
    {
        return todorepos.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
    }


    @Override
    public List<Todo> findByUserName(String username)
    {
        List<Todo> list = new ArrayList<>();
        todorepos.findAll().iterator().forEachRemaining(list::add);

        list.removeIf(q -> !q.getUser().getUsername().equalsIgnoreCase(username));
        return list;
    }

    @Override
    public void delete(long id)
    {
        if (todorepos.findById(id).isPresent())
        {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (todorepos.findById(id).get().getUser().getUsername().equalsIgnoreCase(authentication.getName()))
            {
                todorepos.deleteById(id);
            } else
            {
                throw new EntityNotFoundException(Long.toString(id) + " " + authentication.getName());
            }
        } else
        {
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    @Override
    public Todo save(Todo todo)
    {
        return todorepos.save(todo);
    }

    @Override
    public Todo update(Todo todo, long id)
    {
        Todo newTodo = todorepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        if (todo.getTodo() != null)
        {
            newTodo.setTodo(todo.getTodo());
        }

        if (todo.getUser() != null)
        {
            newTodo.setUser(todo.getUser());
        }

        return todorepos.save(newTodo);
    }
}
