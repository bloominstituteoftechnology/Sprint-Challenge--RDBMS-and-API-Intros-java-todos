package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.models.User;
import com.lambdaschool.todos.repository.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "todoService")
public class TodosServiceImpl implements TodosService{

    @Autowired
    private TodosRepository todosRepository;

    @Autowired
    private UserService userService;

    @Override
    public Todos save(long userid, Todos todos)
    {
        User currentUser = userService.findUserById(userid);
        Todos returnTodos = new Todos(currentUser, todos.getDescription());
        todosRepository.save(returnTodos);
        return returnTodos;
    }

    @Override
    public Todos markComplete(long todoid) {
        Todos returnTodos = todosRepository.findById(todoid).orElseThrow(() -> new EntityNotFoundException("Todo " + todoid " not found."));
        returnTodos.setCompleted(true);
        return todosRepository.save(returnTodos);
    }
}
