package com.lambdaschool.javatodos.javatodos.service;

import com.lambdaschool.javatodos.javatodos.model.Todo;

import java.util.List;

public interface TodoService
{
    List<Todo> findAll();

    Todo findById();

    List<Todo> findByUserName (String username);

    void delete (long id);

    Todo save (Todo todo);

    Todo update (Todo todo, long id);
}
