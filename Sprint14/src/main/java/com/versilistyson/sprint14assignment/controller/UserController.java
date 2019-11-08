package com.versilistyson.sprint14assignment.controller;

import com.versilistyson.sprint14assignment.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    //(GET) http://localhost:2020/user/users -- List all users

    //(GET) http://localhost:2020/user/{id} -- Get user by id

    //(POST) http://localhost:2020/user/user -- Adds a user

    //(Post) http://localhost:2020/user/todo_item/{id} -- adds a to do to the user

    //(DELETE) http://localhost:2020/user/user_id/{user_id} -- Deletes a user and their associated todos based off of user id
}
