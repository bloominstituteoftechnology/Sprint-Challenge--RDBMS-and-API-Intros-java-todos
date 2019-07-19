package com.sprint.todo.repository;

import com.sprint.todo.models.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDo, Long>
{
}