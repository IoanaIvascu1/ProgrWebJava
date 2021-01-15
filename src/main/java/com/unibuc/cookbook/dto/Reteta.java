package com.unibuc.cookbook.dto;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="Retete")
public class Reteta {


        @Id
        @GeneratedValue
        private Long id;
        @NotBlank
        @Size(min=3, max = 20)
        private String numeReteta;

        private Integer timpPreparare;

        private String categorie;

        @ManyToOne
        private Utilizator utilizator;

        public Reteta(){

        }

    public Reteta( String numeReteta, Integer timpPreparare, String categorie ) {
        this.numeReteta = numeReteta;
        this.timpPreparare = timpPreparare;
        this.categorie = categorie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Utilizator getUtilizator() {
        return utilizator;
    }

    public void setUtilizator(Utilizator utilizator) {
        this.utilizator = utilizator;
    }
}
