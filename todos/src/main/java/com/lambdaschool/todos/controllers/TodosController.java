package com.lambdaschool.todos.controllers;

import com.lambdaschool.todos.services.TodosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
public class TodosController
{
    @Autowired
    TodosService todosService;

    @PatchMapping(value = "/todo/{todoid}")
    public ResponseEntity<?> completeTodo(@PathVariable long todoid)
    {
        todosService.markComplete(todoid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
