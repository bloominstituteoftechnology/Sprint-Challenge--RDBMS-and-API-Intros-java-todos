package com.lambdaschool.authenticatedusers.repository;

import com.lambdaschool.authenticatedusers.model.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDo, Long>
{

}
