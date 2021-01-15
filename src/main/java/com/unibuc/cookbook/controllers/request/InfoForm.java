package com.unibuc.cookbook.controllers.request;

public class InfoForm {

    private String text;

    private String label;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLabel() {
        return label;
    }

    public void setData(String label) {
        this.label = label;
    }
}
