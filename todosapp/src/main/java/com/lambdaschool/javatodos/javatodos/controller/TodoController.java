package com.lambdaschool.javatodos.javatodos.controller;

import com.lambdaschool.javatodos.javatodos.model.Todo;
import com.lambdaschool.javatodos.javatodos.service.TodoService;
import com.lambdaschool.javatodos.javatodos.view.CountTodos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController
{
    @Autowired
    TodoService todoService;

    @GetMapping(value = "/todos",
            produces = {"application/json"})
    public ResponseEntity<?> listAllQuotes()
    {
        List<Todo> allTodo = todoService.findAll();
        return new ResponseEntity<>(allTodo, HttpStatus.OK);
    }


    @GetMapping(value = "/todo/{todoId}",
            produces = {"application/json"})
    public ResponseEntity<?> getQuote(
            @PathVariable
                    Long todoId)
    {
        Todo t = todoService.findById(todoId);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }


    @GetMapping(value = "/username/{userName}",
            produces = {"application/json"})
    public ResponseEntity<?> findTodoByUserName(
            @PathVariable
                    String userName)
    {
        List<Todo> theTodos = todoService.findByUserName(userName);
        return new ResponseEntity<>(theTodos, HttpStatus.OK);
    }


    @PostMapping(value = "/todo")
    public ResponseEntity<?> addNewQuote(@Valid
                                         @RequestBody
                                                 Todo newTodo) throws URISyntaxException
    {
        newTodo = todoService.save(newTodo);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newQuoteURI =
                ServletUriComponentsBuilder.fromCurrentRequest().path("/{quoteid}").buildAndExpand(newTodo.getTodoId()).toUri();
        responseHeaders.setLocation(newQuoteURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @PutMapping(value = "/todo/{todoid}")
    public ResponseEntity<?> updateQuote(
            @RequestBody
                    Todo updateTodo,
            @PathVariable
                    long todoid)
    {
        todoService.update(updateTodo, todoid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/todo/{id}")
    public ResponseEntity<?> deleteTodoById(
            @PathVariable
                    long id)
    {
        todoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}