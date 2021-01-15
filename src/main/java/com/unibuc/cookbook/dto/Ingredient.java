package com.unibuc.cookbook.dto;

import javax.persistence.*;

@Entity
@Table(name="Ingrediente")
public class Ingredient {
    @Id
    @GeneratedValue
    private Long id;

    private String nume;

    private String categorie;

    private Boolean adaugat;

    @ManyToOne
    private Reteta reteta;

    public Ingredient(){

    }

    public Ingredient(String nume, String categorie, Boolean adaugat, Reteta reteta) {
        this.nume = nume;
        this.categorie = categorie;
        this.adaugat = adaugat;
        this.reteta = reteta;
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

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Boolean getAdaugat() {
        return adaugat;
    }

    public void setAdaugat(Boolean adaugat) {
        this.adaugat = adaugat;
    }

    public Reteta getReteta() {
        return reteta;
    }

    public void setReteta(Reteta reteta) {
        this.reteta = reteta;
    }
}
