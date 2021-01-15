package com.unibuc.cookbook.services.impl;

import com.unibuc.cookbook.dto.Ingredient;
import com.unibuc.cookbook.dto.Reteta;
import com.unibuc.cookbook.repositories.IngredientRepository;
import com.unibuc.cookbook.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public void save(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }

    @Override
    public List<Ingredient> findByReteta(Reteta reteta) {
        return ingredientRepository.findByReteta(reteta);
    }

    @Override
    public Ingredient findById(Long id) {
        return ingredientRepository.findById(id).get();
    }

    @Override
    public void deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }

    @Override
    public void saveAll(List<Ingredient> ingrediente) {
        ingredientRepository.saveAll(ingrediente);
    }
}
