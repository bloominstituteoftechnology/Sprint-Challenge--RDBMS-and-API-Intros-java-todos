package com.lambdaschool.todos.repositories;

import com.lambdaschool.todos.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value="SELECT * FROM users AS u WHERE u.username LIKE :username", nativeQuery = true)
    User findByName(@Param("username") String username);

}
