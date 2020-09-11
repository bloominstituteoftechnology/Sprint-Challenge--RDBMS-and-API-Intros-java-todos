package com.lambdaschool.todos.repository;

import com.lambdaschool.todos.models.Todos;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface TodosRepository extends CrudRepository<Todos, Long> {
}