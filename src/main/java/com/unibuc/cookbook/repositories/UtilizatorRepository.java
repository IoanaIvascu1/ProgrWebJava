package com.unibuc.cookbook.repositories;

import com.unibuc.cookbook.dto.Utilizator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilizatorRepository extends JpaRepository<Utilizator,Long> {
    Optional<Utilizator> findByNumeUtilizator(String numeUtilizator);
    Boolean existsByNumeUtilizator(String numeUtilizator);
    Boolean existsByEmail(String email);
}
