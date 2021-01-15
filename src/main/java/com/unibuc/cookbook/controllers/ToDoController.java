package com.unibuc.cookbook.controllers;

import com.unibuc.cookbook.dto.Reteta;
import com.unibuc.cookbook.dto.ToDo;
import com.unibuc.cookbook.dto.Utilizator;
import com.unibuc.cookbook.repositories.UtilizatorRepository;
import com.unibuc.cookbook.security.response.ResponseMessage;
import com.unibuc.cookbook.services.RetetaService;
import com.unibuc.cookbook.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ToDoController {
    @Autowired
    RetetaService retetaService;

    @Autowired
    UtilizatorRepository utilizatorRepository;

    @Autowired
    ToDoService toDoService;

    @GetMapping("/retete/detalii/{numeReteta}/ToDo")
    public ToDo afiseazaToDo(@RequestParam(name = "numeUtilizator") String numeUtilizator, @PathVariable("numeReteta") String numeReteta){
        Utilizator utilizator=utilizatorRepository.findByNumeUtilizator(numeUtilizator).orElseThrow(
                () -> new UsernameNotFoundException("Utilizatorul nu a fost găsit cu  -> numele de utilizator : " + numeUtilizator));
        Reteta reteta= retetaService.findByUtilizatorAndNumeReteta(utilizator, numeReteta);
        ToDo toDo=toDoService.findByReteta(reteta);
        return toDo;
    }

    @PostMapping("/retete/detalii/{numeReteta}/ToDo")
    public ResponseEntity<?> updateToDo(@Valid @RequestBody ToDo toDo, @RequestParam(name = "numeUtilizator") String numeUtilizator, @PathVariable("numeReteta") String numeReteta){
        Utilizator utilizator=utilizatorRepository.findByNumeUtilizator(numeUtilizator).orElseThrow(
                () -> new UsernameNotFoundException("Utilizatorul nu a fost găsit cu  -> numele de utilizator : " + numeUtilizator));
        Reteta reteta= retetaService.findByUtilizatorAndNumeReteta(utilizator, numeReteta);
        ToDo toDoUpdate=toDoService.findByReteta(reteta);
        toDoUpdate.setText(toDo.getText());
        toDoService.save(toDoUpdate);

        return new ResponseEntity<>(new ResponseMessage("Listă ToDo modificată cu succes!"), HttpStatus.OK);
    }


}
