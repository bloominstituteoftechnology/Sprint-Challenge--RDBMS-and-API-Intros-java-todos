package com.stepasha.todobackend.controllers;

import com.stepasha.todobackend.models.Todo;
import com.stepasha.todobackend.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;


    @PutMapping(value = "/todo/{todoid}", consumes = {"application/json"})
    public ResponseEntity<?> updateTodo(@RequestBody Todo todo, @PathVariable long todoid) {

        todoService.updateTodo(todo, todoid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}