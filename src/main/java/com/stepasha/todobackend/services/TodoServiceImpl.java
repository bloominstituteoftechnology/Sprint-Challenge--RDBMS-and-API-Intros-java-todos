package com.stepasha.todobackend.services;

import com.stepasha.todobackend.models.Todo;
import com.stepasha.todobackend.repositories.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "todoService")
public class TodoServiceImpl implements TodoService{
    @Autowired
    private TodoRepo todoRepository;

    @Transactional
    @Override
    public Todo updateTodo(long todoid, Todo todo) {
        Todo existingTodo = todoRepository.findById(todoid).orElseThrow(() ->
                new EntityNotFoundException(Long.toString(todoid)));

        if (todo.getDescription() != null) {
            existingTodo.setDescription(todo.getDescription());
        }

        if (todo.getDatestarted() != null) {
            existingTodo.setDatestarted(todo.getDatestarted());
        }

        existingTodo.setCompleted(todo.isCompleted());

        return todoRepository.save(existingTodo);
    }

}
