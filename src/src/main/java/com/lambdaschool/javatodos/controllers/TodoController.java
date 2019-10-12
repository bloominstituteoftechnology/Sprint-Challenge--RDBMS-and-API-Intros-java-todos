package com.lambdaschool.javatodos.controllers;

import com.lambdaschool.javatodos.models.Todo;
import com.lambdaschool.javatodos.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;
    @PutMapping(value = "/todoid/{todoid}", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<?> updateTodo(@PathVariable long todoid, @RequestBody Todo todo)
    {
        return new ResponseEntity<>(todoService.update(todo, todoid), HttpStatus.OK);
    }
}
