package com.bensimpson.sprint2.repositories;


import org.springframework.data.repository.CrudRepository;
import com.bensimpson.sprint2.models.User;

public interface UserRepository
        extends CrudRepository<User,Long> {

}
