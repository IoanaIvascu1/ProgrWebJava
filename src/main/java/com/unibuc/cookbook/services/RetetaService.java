package com.unibuc.cookbook.services;

import com.unibuc.cookbook.dto.Reteta;
import com.unibuc.cookbook.dto.Utilizator;

import java.util.List;

public interface RetetaService {
    List<Reteta> findByUtilizator(Utilizator utilizator);
    Reteta findByUtilizatorAndNumeReteta(Utilizator utilizator, String numeReteta);
    void save(Reteta reteta);
    Boolean existsByNumeReteta(String numeReteta);
}
