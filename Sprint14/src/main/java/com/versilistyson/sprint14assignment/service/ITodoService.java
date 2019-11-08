package com.versilistyson.sprint14assignment.service;

import com.versilistyson.sprint14assignment.model.TodoItem;
import org.springframework.stereotype.Service;

@Service(value = "todoService")
public interface ITodoService {

    TodoItem updateTodoItem(long id);
}
