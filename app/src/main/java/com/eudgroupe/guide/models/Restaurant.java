package com.eudgroupe.guide.models;

import java.io.Serializable;

/**
 * Created by Stagiaire on 11/10/2017.
 */

public class Restaurant implements Serializable {
    private String nom;
    private String category;
    private String email;
    private String phone;
    private String url;
    private String image;

    public Restaurant(String nom, String category, String email, String phone, String url, String image) {
        this.nom = nom;
        this.category = category;
        this.email = email;
        this.phone = phone;
        this.url = url;
        this.image = image;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
