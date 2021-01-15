package com.unibuc.cookbook.services.impl;

import com.unibuc.cookbook.dto.Reteta;
import com.unibuc.cookbook.dto.Utilizator;
import com.unibuc.cookbook.repositories.RetetaRepository;
import com.unibuc.cookbook.services.RetetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetetaServiceImpl implements RetetaService {

    @Autowired
    RetetaRepository retetaRepository;

    @Override
    public List<Reteta> findByUtilizator(Utilizator utilizator) {
        return retetaRepository.findByUtilizator(utilizator);
    }

    @Override
    public Reteta findByUtilizatorAndNumeReteta(Utilizator utilizator, String numeReteta) {
        return retetaRepository.findByUtilizatorAndNumeReteta(utilizator, numeReteta);
    }

    @Override
    public void save(Reteta reteta) {
        retetaRepository.save(reteta);
    }

    @Override
    public Boolean existsByNumeReteta(String numeReteta) {
        return retetaRepository.existsByNumeReteta(numeReteta);
    }
}
