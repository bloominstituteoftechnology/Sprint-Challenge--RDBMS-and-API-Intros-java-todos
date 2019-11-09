package com.stepasha.todobackend.services;

import com.stepasha.todobackend.models.Todo;

public interface TodoService {
    Todo updateTodo(Todo todo, long id); //tod0 id

    Todo getTodoById(long id);

    Todo save(Todo todo, long userid);
}
