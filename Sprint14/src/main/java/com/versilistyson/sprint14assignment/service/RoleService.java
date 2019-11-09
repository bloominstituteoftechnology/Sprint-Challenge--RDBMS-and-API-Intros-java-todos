package com.versilistyson.sprint14assignment.service;

import com.versilistyson.sprint14assignment.model.Role;
import com.versilistyson.sprint14assignment.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "roleService")
public class RoleService implements IRoleService{

    @Autowired
    private RoleRepository repository;
    @Override
    public Role saveRole(Role role) {
        return repository.save(role);
    }
}
