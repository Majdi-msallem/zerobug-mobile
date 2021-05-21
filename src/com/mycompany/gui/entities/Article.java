/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui.entities;

/**
 *
 * @author Hamza
 */
public class Article {
    private int id ; 
private int categorie_id ;
private int fabricant_id ;
private String description ;
private double prix ;
private int quantite ;
private String nom ;
private String img ;
private int nbr ;

    public Article(int id, int categorie_id, int fabricant_id, String description, double prix, int quantite, String nom, String img, int nbr) {
        this.id = id;
        this.categorie_id = categorie_id;
        this.fabricant_id = fabricant_id;
        this.description = description;
        this.prix = prix;
        this.quantite = quantite;
        this.nom = nom;
        this.img = img;
        this.nbr = nbr;
    }

    public Article(int categorie_id, int fabricant_id, String description, double prix, int quantite, String nom, String img, int nbr) {
        this.categorie_id = categorie_id;
        this.fabricant_id = fabricant_id;
        this.description = description;
        this.prix = prix;
        this.quantite = quantite;
        this.nom = nom;
        this.img = img;
        this.nbr = nbr;
    }

    public Article() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategorie_id() {
        return categorie_id;
    }

    public void setCategorie_id(int categorie_id) {
        this.categorie_id = categorie_id;
    }

    public int getFabricant_id() {
        return fabricant_id;
    }

    public void setFabricant_id(int fabricant_id) {
        this.fabricant_id = fabricant_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getNbr() {
        return nbr;
    }

    public void setNbr(int nbr) {
        this.nbr = nbr;
    }

    @Override
    public String toString() {
        return "Article{" + "id=" + id + ", categorie_id=" + categorie_id + ", fabricant_id=" + fabricant_id + ", description=" + description + ", prix=" + prix + ", quantite=" + quantite + ", nom=" + nom + ", img=" + img + ", nbr=" + nbr + '}';
    }

}
