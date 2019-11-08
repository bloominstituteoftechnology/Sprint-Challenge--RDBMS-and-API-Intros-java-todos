package com.lambdaschool.demo.controllers;

import com.lambdaschool.demo.models.User;
import com.lambdaschool.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping(value = "users", produces = {"application/json"})
    public ResponseEntity<?> listAllUsers(){
        List<User> myUsers = userService.getAllUsers();
        return new ResponseEntity<>(myUsers, HttpStatus.OK);
    }
}
