package com.versilistyson.sprint14assignment.service;

import com.versilistyson.sprint14assignment.model.Todo;
import org.springframework.stereotype.Service;

@Service(value = "todoService")
public interface ITodoService {

    Todo updateTodoItem(long id);
}
