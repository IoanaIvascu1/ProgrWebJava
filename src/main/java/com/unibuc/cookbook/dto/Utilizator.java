package com.unibuc.cookbook.dto;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="Utilizatori",uniqueConstraints = { @UniqueConstraint(columnNames = {"numeUtilizator"}), @UniqueConstraint(columnNames = {"email"})})
public class Utilizator {

    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    @Size(min=3, max = 50)
    private String nume;
    @NotBlank
    @Size(min=3, max = 50)
    private String prenume;
    @NotBlank
    @Size(min=3, max = 50)
    private String numeUtilizator;
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    @NotBlank
    @Size(min=6, max = 100)
    private String parola;

    public Utilizator(){

    }

    public Utilizator(String nume, String prenume, String numeUtilizator, String email, String parola) {
        this.nume = nume;
        this.prenume = prenume;
        this.numeUtilizator=numeUtilizator;
        this.email = email;
        this.parola = parola;
    }

    public Utilizator(Long id, String nume, String prenume, String numeUtilizator, String email, String parola) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.numeUtilizator=numeUtilizator;
        this.email = email;
        this.parola = parola;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getNumeUtilizator() {
        return numeUtilizator;
    }

    public void setNumeUtilizator(String numeUtilizator) {
        this.numeUtilizator = numeUtilizator;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

}
