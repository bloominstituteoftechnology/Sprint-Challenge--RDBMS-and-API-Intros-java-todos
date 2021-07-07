package com.sprint.todo.repository;

import com.sprint.todo.models.Todo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TodoRepository extends CrudRepository<Todo, Long> {

    @Query(value = "SELECT * FROM todo WHERE todos = :userid", nativeQuery = true)
    List<Todo> getAllByID(long userid);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM todo WHERE userid = :userid", nativeQuery = true)
    void deleteAllByUserId(long userid);
}