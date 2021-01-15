package com.unibuc.cookbook.repositories;

import com.unibuc.cookbook.dto.Ingredient;
import com.unibuc.cookbook.dto.Reteta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findByReteta(Reteta reteta);
}
