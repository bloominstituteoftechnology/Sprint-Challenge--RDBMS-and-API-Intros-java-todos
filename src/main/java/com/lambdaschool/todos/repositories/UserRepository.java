package com.lambdaschool.todos.repositories;

import com.lambdaschool.todos.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
