package com.versilistyson.sprint14assignment.controller;

import com.versilistyson.sprint14assignment.service.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo_item")
public class TodoItemController {

    @Autowired
    private ITodoService todoService;

    //(PUT) /todos/todo/{todoid} -- updates a todo based on todo id

}
