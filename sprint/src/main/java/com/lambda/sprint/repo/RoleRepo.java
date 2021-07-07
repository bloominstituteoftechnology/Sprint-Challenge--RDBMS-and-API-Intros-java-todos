package com.lambda.sprint.repo;

import com.lambda.sprint.mode.Role;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface RoleRepo extends CrudRepository<Role,Long> {
    @Transactional
    @Modifying
    @Query(value = "DELETE from UserRole where userid = :userid")
    void deleteUserRolesByUserId(long userid);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO UserRole(userid, roleid) values (:userid, :roleid)", nativeQuery = true)
    void insertUserRoles(long userid, long roleid);
}
