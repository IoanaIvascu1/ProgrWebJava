package com.unibuc.cookbook.services;

import com.unibuc.cookbook.dto.Ingredient;
import com.unibuc.cookbook.dto.Reteta;

import java.util.List;

public interface IngredientService {
    void save(Ingredient ingredient);
    List<Ingredient> findByReteta(Reteta reteta);
    public Ingredient findById(Long id);
    void deleteIngredient(Long id);
    void saveAll(List<Ingredient> ingrediente);
}
