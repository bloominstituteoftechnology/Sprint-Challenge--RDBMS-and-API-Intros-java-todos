package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.models.User;
import com.lambdaschool.todos.repository.TodosRepository;
import com.lambdaschool.todos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.swing.text.html.Option;
import java.util.Optional;

@Transactional
@Service(value = "todosService")
public class TodosServiceImplementation implements TodosService{

    @Autowired
    TodosRepository todosrepo;

    @Autowired
    UserRepository userrepos;

    public Todos findTodosByTodoid(long id)

    {
        return todosrepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User id " + id + " not found!"));
    }


     public void markComplete(long id)
     {
        Todos todo = findTodosByTodoid(id);
        if(todo.isCompleted() == false) {
            todo.setCompleted(true);
            todosrepo.save(todo);
        }






     }


}
