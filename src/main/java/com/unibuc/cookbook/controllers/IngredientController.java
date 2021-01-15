package com.unibuc.cookbook.controllers;

import com.unibuc.cookbook.controllers.request.IngredientForm;
import com.unibuc.cookbook.dto.Ingredient;
import com.unibuc.cookbook.dto.Reteta;
import com.unibuc.cookbook.dto.Utilizator;
import com.unibuc.cookbook.repositories.UtilizatorRepository;
import com.unibuc.cookbook.security.response.ResponseMessage;
import com.unibuc.cookbook.services.IngredientService;
import com.unibuc.cookbook.services.RetetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class IngredientController {

    @Autowired
    UtilizatorRepository utilizatorRepository;

    @Autowired
    RetetaService retetaService;

    @Autowired
    IngredientService ingredientService;

    @GetMapping("/retete/detalii/{numeReteta}/ingrediente")
    public List<Ingredient> afiseazaListaIngrediente(@RequestParam(name = "numeUtilizator") String numeUtilizator, @PathVariable("numeReteta") String numeReteta){

        Utilizator utilizator=utilizatorRepository.findByNumeUtilizator(numeUtilizator).orElseThrow(
                () -> new UsernameNotFoundException("Utilizatorul nu a fost găsit cu  -> numele de utilizator : " + numeUtilizator));
        Reteta reteta= retetaService.findByUtilizatorAndNumeReteta(utilizator, numeReteta);

        List<Ingredient> ingrediente=ingredientService.findByReteta(reteta);
        if(ingrediente==null || ingrediente.isEmpty()){
            return ingredientService.findByReteta(null);
        }
        return ingrediente;
    }

    @PostMapping("/retete/detalii/{numeReteta}/adaugaIngredient")
    public ResponseEntity<?> adaugaIngredient(@Valid @RequestBody IngredientForm ingredientForm, @RequestParam(name = "numeUtilizator") String numeUtilizator, @PathVariable("numeReteta") String numeReteta){
        Utilizator utilizator=utilizatorRepository.findByNumeUtilizator(numeUtilizator).orElseThrow(
                () -> new UsernameNotFoundException("Utilizatorul nu a fost găsit cu  -> numele de utilizator : " + numeUtilizator));
        Reteta reteta= retetaService.findByUtilizatorAndNumeReteta(utilizator, numeReteta);
        Ingredient ingredient=new Ingredient(ingredientForm.getNume(), ingredientForm.getCategorie(), false,reteta);
        ingredientService.save(ingredient);

        return new ResponseEntity<>(new ResponseMessage("Ingredient adăugat cu succes!"), HttpStatus.OK);
    }

    @PostMapping("/retete/detalii/{numeReteta}/seteazaIngrediente")
    public ResponseEntity<?> seteazaIngrediente(@Valid @RequestBody List<Ingredient> ingrediente, @RequestParam(name = "numeUtilizator") String numeUtilizator, @PathVariable("numeReteta") String numeReteta){
        Reteta reteta= retetaService.findByUtilizatorAndNumeReteta(utilizatorRepository.findByNumeUtilizator(numeUtilizator).get(), numeReteta);
        for(Ingredient ingredient: ingrediente){
            ingredientService.save(new Ingredient(ingredient.getNume(), ingredient.getCategorie(), true, reteta));
        }
        return new ResponseEntity<>(new ResponseMessage("Ingrediente setate cu succes!"), HttpStatus.OK);
    }
}
