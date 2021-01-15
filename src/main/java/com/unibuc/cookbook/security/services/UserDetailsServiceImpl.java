package com.unibuc.cookbook.security.services;

import com.unibuc.cookbook.dto.Utilizator;
import com.unibuc.cookbook.repositories.UtilizatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UtilizatorRepository utilizatorRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String numeUtilizator) throws UsernameNotFoundException {

        Utilizator utilizator = utilizatorRepository.findByNumeUtilizator(numeUtilizator).orElseThrow(
                () -> new UsernameNotFoundException("Utilizatorul nu a fost gasit cu  -> numele de utilizator : " + numeUtilizator));

        return UserPrinciple.build(utilizator);
    }
}