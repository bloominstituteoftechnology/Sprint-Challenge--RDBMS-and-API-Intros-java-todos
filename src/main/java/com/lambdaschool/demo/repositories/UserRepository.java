package com.lambdaschool.demo.repositories;

import com.lambdaschool.demo.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
