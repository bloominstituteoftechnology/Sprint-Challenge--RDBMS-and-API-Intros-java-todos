package com.stepasha.todobackend.repositories;

import com.stepasha.todobackend.models.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepo extends CrudRepository<Role, Long> {
}
