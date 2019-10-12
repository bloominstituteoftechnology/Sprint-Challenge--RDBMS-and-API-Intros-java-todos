package com.lambdaschool.javatodos.services;

import com.lambdaschool.javatodos.models.Role;
import com.lambdaschool.javatodos.repos.RoleRepo;
import com.lambdaschool.javatodos.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepo roleRepo;
    @Autowired
    UserRepo userRepo;

    @Override
    public List<Role> findAll(){
        List<Role> list = new ArrayList<>(  );
        roleRepo.findAll().iterator().forEachRemaining( list::add );
        return list;
    }

    @Override
    public Role findRoleById(long id){
        return roleRepo.findById( id ).orElseThrow(()-> new EntityNotFoundException( "Role id " + id + " is not found." ) );
    }

    @Override
    public Role findByName(String name)
    {
        Role r = roleRepo.findByNameIgnoreCase( name );
        if (r != null){
            return r;
        }else {
            throw new EntityNotFoundException( name + " not valid name" );
        }
    }

    @Transactional
    @Override
    public void delete(long id)
    {
        roleRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Role id " + id + " not found!"));
        roleRepo.deleteById(id);
    }


    @Transactional
    @Override
    public Role update(long id,
                        Role role)
    {
        if (role.getRolename() == null)
        {
            throw new EntityNotFoundException("No role name found to update!");
        }

        if (role.getUserroles()
                .size() > 0)
        {
            throw new EntityNotFoundException("User Roles are not updated through Role. See endpoint POST: users/user/{userid}/role/{roleid}");
        }

        Role newRoles = findRoleById(id); // see if id exists

        roleRepo.updateRoleName(id,
                role.getRolename());
        return findRoleById(id);
    }


    @Transactional
    @Override
    public Role save(Role role)
    {
        Role newRoles = new Role();
        newRoles.setRolename(role.getRolename());
        if (role.getUserroles()
                .size() > 0)
        {
            throw new EntityNotFoundException("User Roles are not updated through Role. See endpoint POST: users/user/{userid}/role/{roleid}");
        }

        return roleRepo.save(role);
    }

}
