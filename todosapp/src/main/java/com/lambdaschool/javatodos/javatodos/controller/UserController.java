package com.lambdaschool.javatodos.javatodos.controller;

import com.lambdaschool.javatodos.javatodos.model.Todo;
import com.lambdaschool.javatodos.javatodos.model.User;
import com.lambdaschool.javatodos.javatodos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController
{

    @Autowired
    private UserService userService;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/viewall", produces = {"application/json"})
    public ResponseEntity<?> listAllUsers()
    {
        List<User> myUsers = userService.findAll();
        return new ResponseEntity<>(myUsers, HttpStatus.OK);
    }


    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/view/{userId}", produces = {"application/json"})
    public ResponseEntity<?> getUser(@PathVariable
                                             Long userId)
    {
        User u = userService.findUserById(userId);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }


    @GetMapping(value = "/getusername", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<?> getCurrentUserName(Authentication authentication)
    {
        return new ResponseEntity<>(userService.findUserByName(authentication.getName()), HttpStatus.OK);
        // return new ResponseEntity<>(userService.findUserByName(authentication.getName()).getUserid(), HttpStatus.OK);
    }


    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping(value = "/", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> addNewUser(@Valid @RequestBody
                                                User newuser) throws URISyntaxException
    {
        newuser =  userService.save(newuser);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newUserURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{userid}")
                .buildAndExpand(newuser.getUserid())
                .toUri();
        responseHeaders.setLocation(newUserURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }


    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> updateUser(@RequestBody
                                                User updateUser, @PathVariable
                                                long id)
    {
        userService.update(updateUser, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable
                                                    long id)
    {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/mine", produces = {"application/json"})
    public ResponseEntity<?> getMyUserName(Authentication authentication)
    {
        return new ResponseEntity<>(userService.findUserByName(authentication.getName()), HttpStatus.OK);
    }

    @PutMapping(value = "/todo/{userId}", produces = {"application/json"})
    public ResponseEntity<?> newTodoToUser(@RequestBody String todo, @PathVariable long userId)
    {
        User user = userService.findUserById(userId);
        Todo newTodo = new Todo(todo, new Date(), user);
        return new ResponseEntity<>(null, null, HttpStatus.OK);
    }

}