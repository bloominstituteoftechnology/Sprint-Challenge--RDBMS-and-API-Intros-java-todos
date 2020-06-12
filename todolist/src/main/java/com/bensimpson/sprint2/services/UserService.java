package com.bensimpson.sprint2.services;

import com.bensimpson.sprint2.models.User;

import java.util.List;

public interface UserService {
    List<User> FindAllUsers();

    User FindUserById(long id);


}
