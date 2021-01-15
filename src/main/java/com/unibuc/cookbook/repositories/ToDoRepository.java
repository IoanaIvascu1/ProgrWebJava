package com.unibuc.cookbook.repositories;

import com.unibuc.cookbook.dto.Reteta;
import com.unibuc.cookbook.dto.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    ToDo findByReteta(Reteta reteta);
}

