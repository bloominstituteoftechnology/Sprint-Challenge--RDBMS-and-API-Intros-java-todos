package com.lambdaschool.javatodos.services;

import com.lambdaschool.javatodos.models.Todo;
import com.lambdaschool.javatodos.repos.TodoRepo;
import com.lambdaschool.javatodos.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "todoService")
public class TodoServiceImpl implements TodoService {

    @Autowired
    TodoRepo todorepos;

    @Autowired
    UserRepo userrepos;

    @Override
    public List<Todo> findAll(long id)
    {
        List<Todo> todo = new ArrayList<>();
        todorepos.findAll()
                .iterator()
                .forEachRemaining(todo::add);
        return todo;
    }


    @Override
    public Todo findTodoById(long id)
    {
        return todorepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Role id " + id + " not found!"));
    }

//    @Override
//    public Todo findByName(String name)
//    {
//        Todo tr = todorepos.findByNameIgnoreCase(name);
//
//        if (tr != null)
//        {
//            return tr;
//        } else
//        {
//            throw new EntityNotFoundException(name);
//        }
//    }

    @Override
    public Todo update(long id, Todo todo) {
        return null;
    }

    @Override
    public List<Todo> findAll() {
        return null;
    }

    @Override
    public Todo findRoleById(long id) {
        return null;
    }

    @Transactional
    @Override
    public void delete(long id)
    {
        todorepos.findById(id).orElseThrow(() -> new EntityNotFoundException((Long.toString(id))));
        todorepos.deleteById(id);
    }


    @Transactional
    @Override
    public Todo update(Todo todo, long id)
    {
        Todo currentTodo = todorepos.findById(id).orElseThrow(() -> new EntityNotFoundException((Long.toString(id))));
        if (todo.getDatestarted() != null){
            currentTodo.setDatestarted(todo.getDatestarted());
        }
        if (todo.getDescription() != null){
            currentTodo.setDescription(todo.getDescription());
        }
        if (todo.isCompleted()){
            currentTodo.setCompleted(true);
        }else{
            currentTodo.setCompleted(false);
        }
        todorepos.save(currentTodo);
        return currentTodo;
    }


    @Transactional
    @Override
    public Todo save(Todo todo)
    {
        return todorepos.save(todo);
    }
}
