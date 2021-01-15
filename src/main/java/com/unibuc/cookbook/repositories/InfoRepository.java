package com.unibuc.cookbook.repositories;

import com.unibuc.cookbook.dto.Info;
import com.unibuc.cookbook.dto.Reteta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfoRepository extends JpaRepository<Info,Long> {
    List<Info> findByReteta(Reteta reteta);
    Info findByRetetaAndLabel(Reteta reteta, String label);
}


