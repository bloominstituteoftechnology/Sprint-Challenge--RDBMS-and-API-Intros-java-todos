package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.repository.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "todoService")
public class TodoServiceImpl implements TodosService
{
    @Autowired
    private TodosRepository todosRepository;

    @Transactional
    @Override
    public void markComplete( long todoid)
    {
        Todos currentTodo = todosRepository.findById(todoid)
            .orElseThrow(() -> new  EntityNotFoundException("Todo " + todoid + " Not Found"));

            currentTodo.setCompleted(true);

        todosRepository.save(currentTodo);
    }
}
