package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.models.User;
import com.lambdaschool.todos.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "todosService")
public interface TodosServiceImpl implements TodosService {

    @Autowired
    public TodoRepository todorepos;

    @Autowired
    UserService userService;

    @Override
    public Todos save(long userid, Todos newTodo)
    {
        User currentUser = userService.findUserById(userid);
        Todos saveTodo = new Todos(currentUser, newTodo.getDescription());
        todorepos.save(saveTodo);
        return saveTodo;
    }

    @Override
    public Todos markComplete(long todoid)
    {
        Todos updateTodos = todorepos.findById(todoid).orElseThrow() -> new EntityNotFoundException("Error Finding Todo Item" + todoid);
        updateTodos.setCompleted(true);
        return todorepos.save(updateTodos);
    }


}
