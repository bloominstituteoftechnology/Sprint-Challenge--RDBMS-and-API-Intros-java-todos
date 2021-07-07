package com.sprint.todo.repository;

import com.sprint.todo.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String name);
}