package com.stepasha.todobackend.services;

import com.stepasha.todobackend.models.Todo;

public interface TodoService {
    Todo updateTodo(long todoid, Todo todo);
}
