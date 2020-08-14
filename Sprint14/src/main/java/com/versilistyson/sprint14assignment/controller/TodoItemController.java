package com.versilistyson.sprint14assignment.controller;

import com.versilistyson.sprint14assignment.model.Todo;
import com.versilistyson.sprint14assignment.service.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoItemController {

    @Autowired
    private ITodoService todoService;


    @PutMapping(
            value = "{id}",
            consumes = "application/json"
    )
    ResponseEntity<?> updateTodo(
            @PathVariable long id,
            @RequestBody Todo todo
            ) {
        todoService.updateTodo(todo, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
