package com.lambdaschool.authenticatedusers.controller;

import com.lambdaschool.authenticatedusers.model.ToDo;
import com.lambdaschool.authenticatedusers.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/todos")
public class ToDosController
{
    @Autowired
    ToDoService todoService;

    @GetMapping(value = "/todos", produces = {"application/json"})
    public ResponseEntity<?> listAllToDos()
    {
        List<ToDo> allToDos = todoService.findAll();
        return new ResponseEntity<>(allToDos, HttpStatus.OK);
    }


    @GetMapping(value = "/todo/{todoId}", produces = {"application/json"})
    public ResponseEntity<?> getToDo(@PathVariable Long todoId)
    {
        ToDo q = todoService.findToDoById(todoId);
        return new ResponseEntity<>(q, HttpStatus.OK);
    }


    @GetMapping(value = "/username/{userName}", produces = {"application/json"})
    public ResponseEntity<?> findToDoByUserName(@PathVariable String userName)
    {
        List<ToDo> theToDos = todoService.findByUserName(userName);
        return new ResponseEntity<>(theToDos, HttpStatus.OK);
    }



    @PostMapping(value = "/todo")
    public ResponseEntity<?> addNewToDo(@Valid @RequestBody ToDo newToDo) throws URISyntaxException
    {
        newToDo = todoService.save(newToDo);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newToDoURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{todoid}")
                .buildAndExpand(newToDo.getToDoID())
                .toUri();
        responseHeaders.setLocation(newToDoURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }


 //   PUT /todos/todoid/{todoid} - updates a todo based on todoid. Can be done by any user.
    @PutMapping(value = "/todoid/{todoid}")
    public ResponseEntity<?> updateToDo(@RequestBody
                                                ToDo updateToDo, @PathVariable long todoid)
    {
        todoService.update(updateToDo, todoid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/todo/{id}")
    public ResponseEntity<?> deleteToDoById(@PathVariable long id)
    {
        todoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
