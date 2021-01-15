package com.unibuc.cookbook.services;

import com.unibuc.cookbook.dto.Info;
import com.unibuc.cookbook.dto.Reteta;

import java.util.List;

public interface InfoService {
    void save(Info info);
    List<Info> findByReteta(Reteta reteta);
    Info findByRetetaAndLabel(Reteta reteta, String label);
}
