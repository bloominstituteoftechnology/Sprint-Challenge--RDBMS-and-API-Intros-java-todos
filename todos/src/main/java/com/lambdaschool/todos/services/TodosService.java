package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todo;
import com.lambdaschool.todos.models.UserTodos;
import com.lambdaschool.todos.views.UserNameCountTodos;

import java.util.List;

public interface TodosService
{
    List<Todo> findAll();

    Todo findTodoById(long id);

    void delete(long id);

    Todo save(Todo todo);

    void markComplete(long todoid);

    List<UserNameCountTodos> getCountUserTodos();

}
