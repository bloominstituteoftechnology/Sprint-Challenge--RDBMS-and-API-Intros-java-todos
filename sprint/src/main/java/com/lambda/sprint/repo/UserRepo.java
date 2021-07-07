package com.lambda.sprint.repo;

import com.lambda.sprint.mode.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User,Long> {
    User findByUsername(String username);
}
