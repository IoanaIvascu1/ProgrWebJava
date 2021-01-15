package com.unibuc.cookbook.controllers;

import com.unibuc.cookbook.controllers.request.CreeazaRetetaForm;
import com.unibuc.cookbook.dto.*;
import com.unibuc.cookbook.repositories.UtilizatorRepository;
import com.unibuc.cookbook.security.response.ResponseMessage;
import com.unibuc.cookbook.services.InfoService;
import com.unibuc.cookbook.services.IngredientService;
import com.unibuc.cookbook.services.RetetaService;
import com.unibuc.cookbook.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RetetaController {

    @Autowired
    RetetaService retetaService;

    @Autowired
    UtilizatorRepository utilizatorRepository;

    @Autowired
    InfoService infoService;

    @Autowired
    IngredientService ingredientService;

    @Autowired
    ToDoService toDoService;

    @GetMapping("/retete")
    public List<Reteta> afiseazaListaRetete(@RequestParam(name = "numeUtilizator") String numeUtilizator){

        Utilizator utilizator=utilizatorRepository.findByNumeUtilizator(numeUtilizator).orElseThrow(
                () -> new UsernameNotFoundException("Utilizatorul nu a fost găsit cu  -> numele de utilizator : " + numeUtilizator));
        return retetaService.findByUtilizator(utilizator);
    }

    @GetMapping("/retete/detalii/{numeReteta}")
    public Reteta afiseazaReteta(@RequestParam(name = "numeUtilizator") String numeUtilizator, @PathVariable("numeReteta") String numeReteta){
        Utilizator utilizator=utilizatorRepository.findByNumeUtilizator(numeUtilizator).orElseThrow(
                () -> new UsernameNotFoundException("Utilizatorul nu a fost găsit cu  -> numele de utilizator : " + numeUtilizator));
        Reteta reteta= retetaService.findByUtilizatorAndNumeReteta(utilizator, numeReteta);
        return reteta;
    }

    @PostMapping("/retete/creeazaReteta")
    public ResponseEntity<?> creeazaReteta(@Valid @RequestBody CreeazaRetetaForm retetaForm, @RequestParam(name = "numeUtilizator") String numeUtilizator) {

        if (retetaService.existsByNumeReteta(retetaForm.getNumeReteta())) {
            return new ResponseEntity<>(new ResponseMessage("Nume reteta existent în baza de date!"),
                    HttpStatus.BAD_REQUEST);
        }


        Reteta retetaNoua = new Reteta(retetaForm.getNumeReteta(), retetaForm.getTimpPreparare(), retetaForm.getCategorie());

        Utilizator utilizator=utilizatorRepository.findByNumeUtilizator(numeUtilizator).orElseThrow(
                () -> new UsernameNotFoundException("Utilizatorul nu a fost găsit cu  -> numele de utilizator : " + numeUtilizator));;
        retetaNoua.setUtilizator(utilizator);
        retetaService.save(retetaNoua);
        creeazaToDo(retetaNoua);
        creeazaInfo(retetaNoua);

        return new ResponseEntity<>(new ResponseMessage("Rețetă înregistrată cu succes!"), HttpStatus.OK);
    }

    public void creeazaInfo(Reteta reteta){
        Info info1 = new Info("","Kilocalorii", reteta);
        Info info2 = new Info("","Nutrienți", reteta);
        infoService.save(info1);
        infoService.save(info2);
    }

    public void creeazaToDo(Reteta reteta){
        ToDo toDo=new ToDo("", reteta);
        toDoService.save(toDo);
    }

}
