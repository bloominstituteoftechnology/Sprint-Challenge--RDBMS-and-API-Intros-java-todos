package com.jakeesveld.todo.repo;

import com.jakeesveld.todo.model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
}
