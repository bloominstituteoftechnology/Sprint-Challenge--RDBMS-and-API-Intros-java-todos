package com.versilistyson.sprint14assignment.controller;

import com.versilistyson.sprint14assignment.model.Todo;
import com.versilistyson.sprint14assignment.model.User;
import com.versilistyson.sprint14assignment.service.IUserService;
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
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private IUserService userService;

    //(GET) http://localhost:2020/user/users -- List all users
    @GetMapping(produces = {"application/json"})
    public ResponseEntity<?> listAllUsers() {
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //(GET) http://localhost:2020/user/{id} -- Get user by id
    @GetMapping(
            value = "/{id}",
            produces = {"application/json"}
    )
    public ResponseEntity<?> findUserById(@PathVariable long userId) {
        User user = userService.findById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //(POST) http://localhost:2020/users -- Adds a user
    @PostMapping(
            consumes = {"application/json"}
    )
    public ResponseEntity<?> addUser(
            @Valid
            @RequestBody
            User newUser
    ) {
        newUser = userService.save(newUser);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newUserURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.getId())
                .toUri();

        responseHeaders.setLocation(newUserURI);

        return new ResponseEntity<>(
                null,
                responseHeaders,
                HttpStatus.CREATED
        );

    }

    //(Post) http://localhost:2020/user/{id}/todos/to do -- adds a to do to the user
    @PostMapping(
            value = "/{id}/todos",
            consumes = {"application/json"}
    )
    public ResponseEntity<?> addTodoByUserId(
            @Valid
            @RequestBody
                    Todo newTodoItem
    ) {
        newTodoItem = userService.saveTodo(newTodoItem);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newTodoItemURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newTodoItem.getId())
                .toUri();

        responseHeaders.setLocation(newTodoItemURI);

        return new ResponseEntity<>(
                null,
                responseHeaders,
                HttpStatus.CREATED
        );
    }

    //(DELETE) http://localhost:2020/user/user_id/{user_id} -- Deletes a user and their associated todos based off of user id
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable long userId) {
        userService.delete(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
