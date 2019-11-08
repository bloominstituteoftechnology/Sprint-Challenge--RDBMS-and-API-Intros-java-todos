package com.stepasha.todobackend.services;

import com.stepasha.todobackend.models.Todo;
import com.stepasha.todobackend.repositories.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;

public class TodoServiceImpl implements TodoService {
    @Autowired
    TodoRepo todoRepo;

    @Autowired
    UserService userService;

    @Override
    public Todo updateTodo(long todoId, Todo todo) {
        Todo getTodo = todoRepo.findById(todoId).orElseThrow(() -> new EntityNotFoundException(Long.toString(todoId)));

        if (todo.getUser() != null) {
            getTodo.setUser(userService.findUserById(todo.getUser().getUserid()));
        }

        if (todo.getDescription() != null) {
            getTodo.setDescription(todo.getDescription());
        }

        if (todo.getDatestarted() != null) {
            getTodo.setDatestarted(todo.getDatestarted());
        }

        if (todo.isCompleted()) {
            getTodo.setCompleted(todo.isCompleted());
        }

        return todoRepo.save(getTodo);
    }
}
