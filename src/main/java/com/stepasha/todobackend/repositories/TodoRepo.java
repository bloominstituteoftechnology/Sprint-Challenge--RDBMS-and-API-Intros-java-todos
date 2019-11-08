package com.stepasha.todobackend.repositories;

import com.stepasha.todobackend.models.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<Todo, Long> {
}
