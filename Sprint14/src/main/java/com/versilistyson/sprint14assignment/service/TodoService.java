package com.versilistyson.sprint14assignment.service;

import com.versilistyson.sprint14assignment.model.Todo;
import com.versilistyson.sprint14assignment.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "todoService")
public class TodoService implements ITodoService {

    @Autowired
    private TodoRepository todoRepo;

    @Override
    public Todo updateTodo(Todo todo, long todoid) {
        Todo currentTodo = todoRepo.getTodoById(todoid);

        if(todo.getDatetime() != null) {
            currentTodo.setDatetime(todo.getDatetime());
        }

        if (todo.getDescription() != null) {
            currentTodo.setDescription(todo.getDescription());
        }

        if(todo.wasBooleanValueChanged) {
            currentTodo.setCompleted(todo.isCompleted());
        }

       return todoRepo.save(currentTodo);
    }
}
