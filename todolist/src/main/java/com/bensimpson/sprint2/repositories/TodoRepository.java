package com.bensimpson.sprint2.repositories;

import com.bensimpson.sprint2.models.Todo;

import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo,Long>{

}
