package com.lambdaschool.javatodos.repos;

import com.lambdaschool.javatodos.models.Useremail;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UseremailRepo extends CrudRepository<Useremail, Long>
{
    List<Useremail> findAllByUser_Username(String name);
}