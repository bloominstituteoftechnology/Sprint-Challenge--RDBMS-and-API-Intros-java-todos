package com.lambdaschool.demo.repositories;

import com.lambdaschool.demo.models.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
