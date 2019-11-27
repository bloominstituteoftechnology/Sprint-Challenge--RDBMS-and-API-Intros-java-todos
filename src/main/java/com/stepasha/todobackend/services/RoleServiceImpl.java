package com.stepasha.todobackend.services;

import com.stepasha.todobackend.models.Role;
import com.stepasha.todobackend.repositories.RoleRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {
@Autowired
    private RoleRepo roleRepository;




@Transactional
    @Override
    public Role findRoleById(long id) {
        //return null;
        return roleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Role with ID " + id + " not found"));
    }



    @Transactional
    @Override
    public Role save(Role role) {
        if (role.getUsers().size() > 0) {
            throw new EntityNotFoundException("Users not added through roles");
        }

        Role newRole = new Role();
        newRole.setUsers(new ArrayList<>());
        newRole.setUsers(role.getUsers());
        return roleRepository.save(newRole);
    }
}