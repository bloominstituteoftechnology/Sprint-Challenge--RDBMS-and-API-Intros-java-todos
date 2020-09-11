package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.repository.TodoRepository;
import com.lambdaschool.todos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service(value = "todosService")
public class TodoServiceImpl implements TodosService {

    @Autowired
    TodoRepository todorepo;

    @Autowired
    UserRepository userrepo;

    @Override
    public Todos addTodo(Todos todos) {

        return todorepo.save(todos);
    }

    @Override
    public void markComplete(long todoid) {
        Todos todo = todorepo.findById(todoid)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Todo %s not found.", todoid)));

        todo.setCompleted(true);
    }
}
