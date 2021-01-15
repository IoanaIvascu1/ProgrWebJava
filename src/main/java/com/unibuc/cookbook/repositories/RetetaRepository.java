package com.unibuc.cookbook.repositories;

import com.unibuc.cookbook.dto.Reteta;
import com.unibuc.cookbook.dto.Utilizator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RetetaRepository extends JpaRepository<Reteta, Long> {

    List<Reteta> findByUtilizator(Utilizator utilizator);
    Reteta findByUtilizatorAndNumeReteta(Utilizator utilizator, String numeReteta);
    Boolean existsByNumeReteta(String numeReteta);
}
