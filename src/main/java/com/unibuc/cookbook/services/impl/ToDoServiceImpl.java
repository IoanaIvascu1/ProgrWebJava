package com.unibuc.cookbook.services.impl;

import com.unibuc.cookbook.dto.Reteta;
import com.unibuc.cookbook.dto.ToDo;
import com.unibuc.cookbook.repositories.ToDoRepository;
import com.unibuc.cookbook.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ToDoServiceImpl implements ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    @Override
    public void save(ToDo toDo) {
        toDoRepository.save(toDo);
    }

    @Override
    public ToDo findByReteta(Reteta reteta) {
        return toDoRepository.findByReteta(reteta);
    }
}
