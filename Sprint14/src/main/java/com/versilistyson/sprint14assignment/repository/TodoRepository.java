package com.versilistyson.sprint14assignment.repository;

import com.versilistyson.sprint14assignment.model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {

    Todo getTodoById(long todoId);
    Todo save(Todo todo);
}
