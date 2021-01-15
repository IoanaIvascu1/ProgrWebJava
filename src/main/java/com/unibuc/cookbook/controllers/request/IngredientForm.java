package com.unibuc.cookbook.controllers.request;

public class IngredientForm {

    private Long id;

    private String nume;

    private String categorie;

    private Boolean adaugat;

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
}
