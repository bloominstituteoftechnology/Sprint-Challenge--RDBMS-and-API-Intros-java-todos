package com.lambdaschool.todos.services;

import org.springframework.transaction.annotation.Transactional;

public class TodoServiceImpl implements TodosService
{

    @Transactional
    @Override
    public void markComplete(long todoid)
    {

    }
}
