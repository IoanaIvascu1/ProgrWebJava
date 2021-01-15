package com.unibuc.cookbook.dto;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="Informatii")
public class Info {
    @Id
    @GeneratedValue
    private Long id;

    private String text;

    private String label;

    @ManyToOne
    private Reteta reteta;

    public Info(){

    }

    public Info(@NotBlank String text, String label, Reteta reteta) {
        this.text = text;
        this.label = label;
        this.reteta = reteta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String data) {
        this.label = data;
    }

    public Reteta getReteta() {
        return reteta;
    }

    public void setReteta(Reteta reteta) {
        this.reteta = reteta;
    }
}
