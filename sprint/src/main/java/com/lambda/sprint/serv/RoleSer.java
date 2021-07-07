package com.lambda.sprint.serv;


import com.lambda.sprint.mode.Role;

import java.util.List;

public interface RoleSer
{
    List<Role> findAll();

    Role findRoleById(long id);

    void delete(long id);

    Role save(Role role);
}