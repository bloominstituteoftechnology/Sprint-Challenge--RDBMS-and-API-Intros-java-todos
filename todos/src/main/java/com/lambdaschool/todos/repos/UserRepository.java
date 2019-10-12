package com.lambdaschool.todos.repos;

import com.lambdaschool.todos.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long>
{
	//you can do a findBy by of any field in your model
	User findByUsername(String username);


	List<User> findByUsernameContainingIgnoreCase(String name);
}
