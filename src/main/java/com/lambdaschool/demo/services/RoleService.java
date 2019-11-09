package com.lambdaschool.demo.services;

import com.lambdaschool.demo.models.Role;

public interface RoleService {

    Role getRoleById(long id);
    Role save(Role role);
}
