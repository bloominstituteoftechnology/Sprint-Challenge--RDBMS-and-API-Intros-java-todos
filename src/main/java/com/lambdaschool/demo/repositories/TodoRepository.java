package com.lambdaschool.demo.repositories;


import com.lambdaschool.demo.models.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
}
