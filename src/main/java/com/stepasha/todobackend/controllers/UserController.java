package com.stepasha.todobackend.controllers;


import com.stepasha.todobackend.models.User;
import com.stepasha.todobackend.services.UserService;
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
    // http://localhost:2020/users/users
    @PostMapping(value = "/users",
    consumes = {"application/json"})
    public ResponseEntity<?> addNewUser(
            @Valid
            @RequestBody User newUser){
        newUser = userService.save(newUser);
        HttpHeaders responseHeader = new HttpHeaders();
        URI newUserUri = ServletUriComponentsBuilder.fromCurrentRequest()
              .path("/{userid}")
              .buildAndExpand(newUser.getUserid())
              .toUri();
        responseHeader.setLocation(newUserUri);
        return new ResponseEntity<>(null, responseHeader, HttpStatus.CREATED);
    }
    // http://localhost:2020/users/users/1
    @PutMapping(value = "/users/{userid}",
    consumes = {"application/json"})
    public ResponseEntity<?> updateUser(@RequestBody User updateUSer,
                                        @PathVariable long userid){
        userService.update(updateUSer, userid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    // http://localhost:2020/users/users/1
    @DeleteMapping(value = "/users/{userid}")
    public ResponseEntity<?> deleteUser(@PathVariable long userid){
        userService.delete(userid);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
