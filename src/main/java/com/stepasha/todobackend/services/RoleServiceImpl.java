package com.stepasha.todobackend.services;

import com.stepasha.todobackend.models.Role;
import com.stepasha.todobackend.repositories.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {

   @Autowired
    RoleRepo roleRepo;

    @Override
    public Role findRoleById(long id) {
        return roleRepo.findById(id)
                .orElseThrow( ()->  new EntityNotFoundException("Role not found"));
    }

    @Override
    public Role save(Role role) {
        if (role.getUsers().size() >0){
            throw new EntityNotFoundException("users and roles are not connecting");
        }
        Role newRole = new Role();
        newRole.setUsers(new ArrayList<>());
        newRole.setRolename(role.getRolename());
        return roleRepo.save(newRole);
    }
}
