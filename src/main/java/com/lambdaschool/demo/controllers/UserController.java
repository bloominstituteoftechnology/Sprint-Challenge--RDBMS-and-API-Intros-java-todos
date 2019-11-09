package com.lambdaschool.demo.controllers;

import com.lambdaschool.demo.models.User;
import com.lambdaschool.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    //Get http://localhost:2019/users/users return all of the users and their todos
    @GetMapping(value = "users", produces = {"application/json"})
    public ResponseEntity<?> listAllUsers(){
        List<User> myUsers = userService.getAllUsers();
        return new ResponseEntity<>(myUsers, HttpStatus.OK);
    }

    //Get http://localhost:2019/users/user/{userid} return the user and their todos based off of id
    @GetMapping(value = "/user/{userid}", produces = {"application/json"})
    public ResponseEntity<?> findUserById(@PathVariable long userid){//join table to find user tod0?
        User myUser = userService.getUserById(userid);
        return new ResponseEntity<>(myUser, HttpStatus.OK);
    }

    //Post http://localhost:2019/users/user adds a user
    @PostMapping (value = "/user", consumes = {"application/json"})
    public ResponseEntity<?> addNewUser(@Valid @RequestBody User newUser){
        newUser = userService.save(newUser);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newRestaurantURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("userid")
                .buildAndExpand(newUser.getUserid()).toUri();
        responseHeaders.setLocation(newRestaurantURI);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    //DELETE http://localhost:2019/users/userid/{userid} - Deletes a user based off of their userid and deletes all their associated todos.
    @DeleteMapping(value = "/userid/{userid}")
    public ResponseEntity<?> deleteUser(@PathVariable long userid){
        userService.delete(userid);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}