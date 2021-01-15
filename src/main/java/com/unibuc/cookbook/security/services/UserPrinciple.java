package com.unibuc.cookbook.security.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.unibuc.cookbook.dto.Utilizator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;

public class UserPrinciple implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String nume;

    private String prenume;

    private String numeUtilizator;

    private String email;

    @JsonIgnore
    private String parola;


    public UserPrinciple(Long id, String nume, String prenume,
                         String numeUtilziator, String email, String parola) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.numeUtilizator = numeUtilziator;
        this.email = email;
        this.parola = parola;
    }

    public static UserPrinciple build(Utilizator utilziator) {

        return new UserPrinciple(
                utilziator.getId(),
                utilziator.getNume(),
                utilziator.getPrenume(),
                utilziator.getNumeUtilizator(),
                utilziator.getEmail(),
                utilziator.getParola()
        );
    }

    public Long getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getUsername() {
        return numeUtilizator;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return parola;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPrinciple user = (UserPrinciple) o;
        return Objects.equals(id, user.id);
    }
}
