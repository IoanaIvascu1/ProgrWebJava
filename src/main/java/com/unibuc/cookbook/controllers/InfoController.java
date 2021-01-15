package com.unibuc.cookbook.controllers;

import com.unibuc.cookbook.controllers.request.InfoForm;
import com.unibuc.cookbook.dto.Info;
import com.unibuc.cookbook.dto.Reteta;
import com.unibuc.cookbook.dto.Utilizator;
import com.unibuc.cookbook.repositories.UtilizatorRepository;
import com.unibuc.cookbook.security.response.ResponseMessage;
import com.unibuc.cookbook.services.InfoService;
import com.unibuc.cookbook.services.RetetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class InfoController {

    @Autowired
    UtilizatorRepository utilizatorRepository;

    @Autowired
    RetetaService retetaService;

    @Autowired
    InfoService infoService;

    @GetMapping("/retete/detalii/{numeReteta}/info")
    public List<Info> afiseazaInfos(@RequestParam(name = "numeUtilizator") String numeUtilizator, @PathVariable("numeReteta") String numeReteta){
        Utilizator utilizator=utilizatorRepository.findByNumeUtilizator(numeUtilizator).orElseThrow(
                () -> new UsernameNotFoundException("Utilizatorul nu a fost găsit cu  -> numele de utilizator : " + numeUtilizator));
        Reteta reteta= retetaService.findByUtilizatorAndNumeReteta(utilizator, numeReteta);
        List<Info> infos=infoService.findByReteta(reteta);
        return infos;
    }

    @PostMapping("/retete/detalii/{numeReteta}/info")
    public ResponseEntity<?> updateInfo(@Valid @RequestBody InfoForm infoForm, @RequestParam(name = "numeUtilizator") String numeUtilizator, @PathVariable("numeReteta") String numeReteta){
        Utilizator utilizator=utilizatorRepository.findByNumeUtilizator(numeUtilizator).orElseThrow(
                () -> new UsernameNotFoundException("Utilizatorul nu a fost găsit cu  -> numele de utilizator : " + numeUtilizator));
        Reteta reteta= retetaService.findByUtilizatorAndNumeReteta(utilizator, numeReteta);
        Info info=infoService.findByRetetaAndLabel(reteta, infoForm.getLabel());
        info.setText(infoForm.getText());
        infoService.save(info);

        return new ResponseEntity<>(new ResponseMessage("Info modificată cu succes!"), HttpStatus.OK);
    }
}
