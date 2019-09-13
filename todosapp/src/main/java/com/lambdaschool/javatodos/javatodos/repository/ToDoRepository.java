package com.lambdaschool.javatodos.javatodos.repository;

import com.lambdaschool.javatodos.javatodos.model.Todo;
import com.lambdaschool.javatodos.javatodos.view.CountTodos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ToDoRepository extends CrudRepository<Todo, Long>
{
    @Query(value = "SELECT u.username, count(q.quotesid) as countquotes FROM quotes q JOIN users u on q.userid = u.userid GROUP BY u.username", nativeQuery = true)
    ArrayList<CountTodos> getTodoCount();
}
