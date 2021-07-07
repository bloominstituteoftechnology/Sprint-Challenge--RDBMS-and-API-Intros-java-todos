package com.lambda.sprint.repo;

import com.lambda.sprint.mode.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<Todo,Long> {
}
