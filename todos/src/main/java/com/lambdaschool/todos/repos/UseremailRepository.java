package com.lambdaschool.todos.repos;

import com.lambdaschool.todos.models.Useremail;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UseremailRepository extends CrudRepository<Useremail, Long>
{
    //user is the table _field
    //there is a foreign key for use inside of user email
    List<Useremail> findAllByUser_Username(String name);
}
