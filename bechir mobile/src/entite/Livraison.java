/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;


import java.util.Date;



/**
 *
 * @author bechi
 */
public class Livraison {
    private int id;
    private String livreur_id;
    private int commande_id;
    private String date_liv;
    private String statut;

    public Livraison(int id, String livreur_id, int commande_id, String date_liv, String statut) {
        this.id = id;
        this.livreur_id = livreur_id;
        this.commande_id = commande_id;
        this.date_liv = date_liv;
        this.statut = statut;
    }

    public Livraison(String livreur_id, int commande_id, String date_liv, String statut) {
        this.livreur_id = livreur_id;
        this.commande_id = commande_id;
        this.date_liv = date_liv;
        this.statut = statut;
    }

    public Livraison() {
    }

    public Livraison(int id, String date_liv) {
        this.id = id;
        this.date_liv = date_liv;
    }

    public Livraison(String livreur_id, String date_liv, String statut) {
        this.livreur_id = livreur_id;
        this.date_liv = date_liv;
        this.statut = statut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLivreur_id() {
        return livreur_id;
    }

    public void setLivreur_id(String livreur_id) {
        this.livreur_id = livreur_id;
    }

    public int getCommande_id() {
        return commande_id;
    }

    public void setCommande_id(int commande_id) {
        this.commande_id = commande_id;
    }

    public String getDate_liv() {
        return date_liv;
    }

    public void setDate_liv(String date_liv) {
        this.date_liv = date_liv;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        
        
        return "" + "id=" + id + ", date_liv=" +date_liv + ", statut=" + statut + '}';
    }
    
    
}
