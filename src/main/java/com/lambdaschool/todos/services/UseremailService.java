package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.UserEmail;

import java.util.List;

public interface UseremailService
{
    List<UserEmail> findAll();

    UserEmail findUseremailById(long id);

    List<UserEmail> findByUserName(String username,
                                   boolean isAdmin);

    void delete(long id,
                boolean isAdmin);

    UserEmail update(long useremailid,
                     String emailaddress,
                     boolean isAdmin);
}
