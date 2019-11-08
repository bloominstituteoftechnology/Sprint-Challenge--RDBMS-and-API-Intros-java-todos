package com.versilistyson.sprint14assignment.repository;

import com.versilistyson.sprint14assignment.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface UserRepository extends CrudRepository<User, Long> {

    Set<User> findAll();
    User findById(long id);
    User save();
    User deleteById(long id);
}
