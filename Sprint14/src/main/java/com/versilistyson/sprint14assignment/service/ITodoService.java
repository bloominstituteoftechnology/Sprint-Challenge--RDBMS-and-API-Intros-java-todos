package com.versilistyson.sprint14assignment.service;

import com.versilistyson.sprint14assignment.model.Todo;
import org.springframework.stereotype.Service;


public interface ITodoService {

    Todo updateTodo(Todo todo, long todoid);

}
