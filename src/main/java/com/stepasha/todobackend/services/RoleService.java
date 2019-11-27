package com.stepasha.todobackend.services;

import com.stepasha.todobackend.models.Role;

import java.util.List;

public interface RoleService {

    Role findRoleById(long id);

    Role save(Role role);
}
