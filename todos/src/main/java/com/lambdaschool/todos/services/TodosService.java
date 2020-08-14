package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.models.User;

public interface TodosService
{
    void markComplete(long todoid);

//    Todos update(
//        long todoid,
//        String description,
//        String completed,
//        User user);
}
