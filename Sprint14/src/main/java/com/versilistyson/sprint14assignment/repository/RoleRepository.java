package com.versilistyson.sprint14assignment.repository;

import com.versilistyson.sprint14assignment.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role save(Role role);
    Role getRoleById(long roleid);
}
