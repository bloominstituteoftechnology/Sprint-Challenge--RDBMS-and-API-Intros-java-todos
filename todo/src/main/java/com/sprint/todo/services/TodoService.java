package com.sprint.todo.services;

import com.sprint.todo.models.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> findAllById(long id);

    Todo findTodoById(long id);

    Todo save(Todo todo);

    void delete(long id);

    Todo update(Todo todo, long id);
}