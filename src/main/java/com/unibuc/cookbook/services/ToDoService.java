package com.unibuc.cookbook.services;

import com.unibuc.cookbook.dto.Reteta;
import com.unibuc.cookbook.dto.ToDo;

public interface ToDoService {
    void save(ToDo toDo);
    ToDo findByReteta(Reteta reteta);
}
