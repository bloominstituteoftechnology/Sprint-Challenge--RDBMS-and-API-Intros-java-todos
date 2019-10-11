package com.lambdaschool.todos.repositories;

import com.lambdaschool.todos.models.UserEmail;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserEmailRepository extends CrudRepository<UserEmail, Long>
{
    List<UserEmail> findAllByUser_Username(String name);
}
