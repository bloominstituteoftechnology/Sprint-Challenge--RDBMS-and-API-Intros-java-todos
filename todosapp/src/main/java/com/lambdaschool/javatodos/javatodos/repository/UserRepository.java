package com.lambdaschool.javatodos.javatodos.repository;


import com.lambdaschool.javatodos.javatodos.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}
