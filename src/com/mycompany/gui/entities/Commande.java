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
public class Commande {
    private int id ; 
private int emailuser_id ;
private int article_id ;
private double prix_total ;
private String adresse ;
private String nom ;
private String email ;
private String prenom ;
private String description_adresse ;
private String gouvernorat ;
private int codepostale ;
private int numero_telephone ;

    public Commande(int id, int emailuser_id, int article_id, double prix_total, String adresse, String nom, String prenom, String description_adresse, String gouvernorat, int codepostale, int numero_telephone) {
        this.id = id;
        this.emailuser_id = emailuser_id;
        this.article_id = article_id;
        this.prix_total = prix_total;
        this.adresse = adresse;
        this.nom = nom;
        this.prenom = prenom;
        this.description_adresse = description_adresse;
        this.gouvernorat = gouvernorat;
        this.codepostale = codepostale;
        this.numero_telephone = numero_telephone;
    }

    public Commande(int emailuser_id, int article_id, double prix_total, String adresse, String nom, String prenom, String description_adresse, String gouvernorat, int codepostale, int numero_telephone) {
        this.emailuser_id = emailuser_id;
        this.article_id = article_id;
        this.prix_total = prix_total;
        this.adresse = adresse;
        this.nom = nom;
        this.prenom = prenom;
        this.description_adresse = description_adresse;
        this.gouvernorat = gouvernorat;
        this.codepostale = codepostale;
        this.numero_telephone = numero_telephone;
    }

    public Commande() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmailuser_id() {
        return emailuser_id;
    }

    public void setEmailuser_id(int emailuser_id) {
        this.emailuser_id = emailuser_id;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    
    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public double getPrix_total() {
        return prix_total;
    }

    public void setPrix_total(double prix_total) {
        this.prix_total = prix_total;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDescription_adresse() {
        return description_adresse;
    }

    public void setDescription_adresse(String description_adresse) {
        this.description_adresse = description_adresse;
    }

    public String getGouvernorat() {
        return gouvernorat;
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    public int getCodepostale() {
        return codepostale;
    }

    public void setCodepostale(int codepostale) {
        this.codepostale = codepostale;
    }

    public int getNumero_telephone() {
        return numero_telephone;
    }

    public void setNumero_telephone(int numero_telephone) {
        this.numero_telephone = numero_telephone;
    }

    @Override
    public String toString() {
        return "ce commande pour Mr/Madame "+nom+" "+prenom+" pour un prix total de "+prix_total+" DNT et ayant l adresse: "+codepostale+","+adresse+","+gouvernorat;
    }

}
