package com.stepasha.todobackend.repositories;

import com.stepasha.todobackend.models.Role;
import com.stepasha.todobackend.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepo extends CrudRepository<Role, Long> {


}
