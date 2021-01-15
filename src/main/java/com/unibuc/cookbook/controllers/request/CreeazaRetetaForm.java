package com.unibuc.cookbook.controllers.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreeazaRetetaForm {

    @NotBlank
    @Size(min=3, max = 20)
    private String numeReteta;

    private Integer timpPreparare;
    @NotBlank
    private String categorie;

    public String getNumeReteta() {
        return numeReteta;
    }

    public void setNumeReteta(String numeReteta) {
        this.numeReteta = numeReteta;
    }

    public Integer getTimpPreparare() {
        return timpPreparare;
    }

    public void setTimpPreparare(Integer timpPreparare) {
        this.timpPreparare = timpPreparare;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
}
