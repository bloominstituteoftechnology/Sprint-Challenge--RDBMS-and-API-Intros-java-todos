package com.lambdaschool.todos.controllers;

import com.lambdaschool.todos.models.User;
import com.lambdaschool.todos.repositories.UserRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(path={"/users"}, produces= MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    UserRepository userRepo;

//    GET /users - returns all the users *
//    GET /users/userid/{userid} - return the user based off of the user id *
//    GET /users/username/{username} - return the user based off of the user name *
//    POST /users - adds a user
//    PUT /users/userid/{userid} - updates a user based on userid
//    DELETE /users/userid/{userid} - Deletes a user based off of their userid and deletes all their associated todos

    @ApiOperation(value = "List All Users", response = List.class)
    @ApiResponses(value =
            {
                    @ApiResponse(code = 200, message = "Successfully retrieves list"),
                    @ApiResponse(code = 401, message = "You are not authorized to the view the resource"),
                    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
                    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
            })
    @GetMapping("")
    public List<User> allUsers() {
        return userRepo.findAll();
    }

    @GetMapping("userid/{userid}")
    public User getUserById(@PathVariable long userid) {
        var user = userRepo.findById(userid);

        if(user.isPresent()) {
            return user.get();
        }
        return null;
    }

    @GetMapping("username/{username}")
    public User getUserByName(@PathVariable String username) {
        return userRepo.findByName(username);
    }

    @PostMapping("")
    public User addNewUser(@RequestBody User user) throws URISyntaxException {
        return userRepo.save(user);
    }


}
