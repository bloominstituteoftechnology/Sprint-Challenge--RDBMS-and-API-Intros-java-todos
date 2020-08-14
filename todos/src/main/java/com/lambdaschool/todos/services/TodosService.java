package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.models.User;

public interface TodosService
{
    void markComplete(long todoid);

    Todos update(
        Todos todos,
        long id);

    Todos findTodosById(long id);
}
