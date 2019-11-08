package com.stepasha.todobackend.controllers;

import com.stepasha.todobackend.models.Todo;
import com.stepasha.todobackend.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;


    // http://localhost:2020/todos/todo/2
    @PutMapping(value = "/todo/{todoId}",
            produces = {"application/json"})
    public ResponseEntity<?> updateTodo (@RequestBody Todo updateTodo, @PathVariable long todoId) {
        todoService.updateTodo(todoId, updateTodo);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}