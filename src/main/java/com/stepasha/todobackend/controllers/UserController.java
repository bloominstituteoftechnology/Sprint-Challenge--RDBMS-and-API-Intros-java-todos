package com.stepasha.todobackend.controllers;


import com.stepasha.todobackend.models.User;
import com.stepasha.todobackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // http://localhost:2020/users/users
    @GetMapping(value = "/users",
    produces = {"application/json"})
    public ResponseEntity<?> listAllUsers(){
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    // http://localhost:2020/users/users/1
    @GetMapping(value = "/users/{id}",
    produces = {"application/json"})
    public ResponseEntity<?> findUsersById(@PathVariable long id){
        User idUser = userService.findUserById(id);
        return new ResponseEntity<>(idUser, HttpStatus.OK);
    }

}
