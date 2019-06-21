package com.shoon.javatodos.controller;


import com.shoon.javatodos.model.ToDo;
import com.shoon.javatodos.model.User;
import com.shoon.javatodos.repository.UserRepository;

import com.shoon.javatodos.service.ToDoService;
import com.shoon.javatodos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class UserController
{

    @Autowired
    private ToDoService todoService;

    @Autowired
    UserService userService;

    @Autowired
    private UserRepository userrepos;

    @GetMapping(value = "/users/mine", produces = {"application/json"})
    public ResponseEntity<?> getCurrentUser()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userrepos.findByUsername(authentication.getName());
        long userId = currentUser.getUserid();
        return new ResponseEntity<>(userService.findUserById(userId), HttpStatus.OK);
    }

    @PostMapping(value = "/users",
    consumes = {"application/json"},
    produces = {"application/json"})
    public ResponseEntity<?> addNewUser(@Valid
                                        @RequestBody
                                        User newUser) throws URISyntaxException
    {
        newUser = userService.save(newUser);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newRestaurantURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userid}").buildAndExpand(newUser.getUserid()).toUri();
        responseHeaders.setLocation(newRestaurantURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @PostMapping(value = "users/todo/{userid}",
    consumes = {"application/json"},
    produces = {"application/json"})
    public ResponseEntity<?> addUserToDo(@PathVariable long userid,
                                         @Valid
                                         @RequestBody
                                                 ToDo newToDo) throws URISyntaxException
    {
        newToDo = userService.addToDo(newToDo, userid);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newRestaurantURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{todoid}").buildAndExpand(newToDo.getlIDtoDo()).toUri();
        responseHeaders.setLocation(newRestaurantURI);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.OK);
    }

    @PutMapping(value = "todos/todoid/{todoid}")
    public ResponseEntity<?> updateToDo(@RequestBody ToDo updateToDo,
                                        @PathVariable long todoid)
    {
        todoService.update(updateToDo, todoid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("users/userid/{userid}")
    public ResponseEntity<?> deleteUserById(@PathVariable long userid)
    {
        userService.delete(userid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
