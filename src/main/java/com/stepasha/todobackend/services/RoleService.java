package com.stepasha.todobackend.services;

import com.stepasha.todobackend.models.Role;

public interface RoleService {

    Role findRoleById(long id);
    Role save(Role role);
}
