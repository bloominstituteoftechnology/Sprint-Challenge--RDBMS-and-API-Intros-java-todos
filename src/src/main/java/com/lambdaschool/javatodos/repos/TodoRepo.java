package com.lambdaschool.javatodos.repos;

import com.lambdaschool.javatodos.models.Todo;
import com.lambdaschool.javatodos.view.JustTheCount;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface TodoRepo extends CrudRepository<Todo, Long>
{
//    @Query(value = "SELECT COUNT(*) as count FROM todos WHERE userid = :userid AND todoid = :todoid", nativeQuery = true)
//    JustTheCount checkUserRolesCombo(long userid, long todoid);
//
//    @Transactional
//    @Modifying
//    @Query(value = "DELETE FROM Todos WHERE userid = :userid AND todoid = :todoid")
//    void deleteUserRoles(long userid, long todoid);
//
//    @Transactional
//    @Modifying
//    @Query(value = "INSERT INTO Todos(userid, todoid) VALUES (:userid, :todoid)", nativeQuery = true)
//    void insertUserRoles(long userid, long todoid);
//    Todo findByNameIgnoreCase(String name);
//
//    @Transactional
//    @Modifying
//    @Query(value = "UPDATE Todo SET NAME = :name WHERE todoid = :todoid")
//    void updateRoleName(long todoid, String name);
    }