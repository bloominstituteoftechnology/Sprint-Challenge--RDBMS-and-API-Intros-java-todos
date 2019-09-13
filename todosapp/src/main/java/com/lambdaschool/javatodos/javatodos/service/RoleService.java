package com.lambdaschool.javatodos.javatodos.service;




import com.lambdaschool.javatodos.javatodos.model.Role;

import java.util.List;

public interface RoleService
{
    List<Role> findAll();

    Role findRoleById(long id);

    void delete(long id);

    Role save(Role role);
}