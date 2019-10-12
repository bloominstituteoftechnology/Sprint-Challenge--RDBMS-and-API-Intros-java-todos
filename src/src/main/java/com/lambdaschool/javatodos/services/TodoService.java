package com.lambdaschool.javatodos.services;

import com.lambdaschool.javatodos.models.Todo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TodoService
{
    List<Todo> findAll();
    Todo findRoleById(long id);
    void delete(long id);

    @Transactional
    Todo update(Todo todo, long id);

    Todo save(Todo todo);

    List<Todo> findAll(long id);

    Todo findTodoById(long id);

//    Todo findByName(String name);
    Todo update(long id, Todo todo);
}