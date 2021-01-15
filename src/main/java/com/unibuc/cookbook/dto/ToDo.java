package com.unibuc.cookbook.dto;

import javax.persistence.*;

@Entity
@Table(name="ToDo")
public class ToDo {

    @Id
    @GeneratedValue
    private Long id;

    private String text;

    @ManyToOne
    private Reteta reteta;

    public ToDo() {

    }

    public ToDo(String text, Reteta reteta) {
        this.text = text;
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

    public Reteta getReteta() {
        return reteta;
    }

    public void setReteta(Reteta reteta) {
        this.reteta = reteta;
    }
}