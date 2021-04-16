package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.repository.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "todoService")
public class TodoServiceImpl implements TodosService
{
    @Autowired
    private TodosRepository todosRepository;

    @Transactional
    @Override
    public void markComplete(long todoid)
    {
        if (todosRepository.findById(todoid).isPresent())
        {
            return todosRepository
        }else{

        }
    }
}
