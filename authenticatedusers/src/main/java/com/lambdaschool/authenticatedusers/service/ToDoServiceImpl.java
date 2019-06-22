package com.lambdaschool.authenticatedusers.service;

import com.lambdaschool.authenticatedusers.model.ToDo;
import com.lambdaschool.authenticatedusers.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "todoService")
public class ToDoServiceImpl implements ToDoService
{
    @Autowired
    private ToDoRepository todorepos;

    @Override
    public List<ToDo> findAll()
    {
        List<ToDo> list = new ArrayList<>();
        todorepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public ToDo findToDoById(long id)
    {
        return todorepos.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
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

    @Transactional
    @Override
    public ToDo save(ToDo todo)
    {
        return todorepos.save(todo);
    }

    @Override
    public List<ToDo> findByUserName(String username)
    {
        List<ToDo> list = new ArrayList<>();
        todorepos.findAll().iterator().forEachRemaining(list::add);

        list.removeIf(q -> !q.getUser().getUsername().equalsIgnoreCase(username));
        return list;
    }

    @Override
    public ToDo update(ToDo todo, long id)
    {
            ToDo newToDo = todorepos.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

            if (todo.getToDo() != null)
            {
                newToDo.setToDo(todo.getToDo());
            }

            if (todo.getUser() != null)
            {
                newToDo.setUser(todo.getUser());
            }

            return todorepos.save(newToDo);
    }
}
