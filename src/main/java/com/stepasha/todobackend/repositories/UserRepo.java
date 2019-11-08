package com.stepasha.todobackend.repositories;

import com.stepasha.todobackend.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo  extends CrudRepository<User, Long> {
}
