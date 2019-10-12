package com.lambdaschool.javatodos.repos;

import com.lambdaschool.javatodos.models.Role;
import com.lambdaschool.javatodos.view.JustTheCount;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface RoleRepo extends CrudRepository<Role, Long>
{
    @Query(value = "SELECT COUNT(*) as count FROM userrole WHERE userid = :userid AND roleid = :roleid",
            nativeQuery = true)
    JustTheCount checkUserRolesCombo(long userid,
                                     long roleid);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Userrole WHERE userid = :userid AND roleid = :roleid")
    void deleteUserRoles(long userid,
                         long roleid);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Userrole(userid, roleid) VALUES (:userid, :roleid)",
            nativeQuery = true)
    void insertUserRoles(long userid,
                         long roleid);

    Role findByNameIgnoreCase(String name);

    @Transactional
    @Modifying
    // user Role instead of roles in order to use Hibernate SQL
    @Query(value = "UPDATE Role SET NAME = :name WHERE roleid = :roleid")
    void updateRoleName(long roleid,
                        String name);
}