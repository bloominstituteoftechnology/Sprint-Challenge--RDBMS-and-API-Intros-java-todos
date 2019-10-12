package com.lambdaschool.javatodos.repos;

import com.lambdaschool.javatodos.models.User;
import com.lambdaschool.javatodos.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Long>
{
    User findByUsername(String username);

    List<User> findByUsernameContainingIgnoreCase(String name);
}