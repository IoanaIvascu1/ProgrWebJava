package com.unibuc.cookbook.services.impl;

import com.unibuc.cookbook.dto.Info;
import com.unibuc.cookbook.dto.Reteta;
import com.unibuc.cookbook.repositories.InfoRepository;
import com.unibuc.cookbook.services.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    private InfoRepository infoRepository;

    @Override
    public void save(Info info) {
        infoRepository.save(info);
    }

    @Override
    public List<Info> findByReteta(Reteta reteta) {
        return infoRepository.findByReteta(reteta);
    }

    @Override
    public Info findByRetetaAndLabel(Reteta reteta, String label) {
        return infoRepository.findByRetetaAndLabel(reteta, label);
    }
}
