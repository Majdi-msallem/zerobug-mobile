/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.Entities;

import java.util.Date;




/**
 *
 *
 */
public class Reclamation {
    int id;
    String type;
    String description;
    Date date_rec;

    public Reclamation(int id, String type, String description, Date date_rec) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.date_rec = date_rec;
    }

    public Reclamation(int id, String type, String description) {
        this.id = id;
        this.type = type;
        this.description = description;
    }
    
    public Reclamation(String string, String string0, Date date) {
        //To change body of generated methods, choose Tools | Templates.
    }

    public Reclamation() {
    }

   

 

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate_rec() {
        return date_rec;
    }

    public void setDate_rec(Date date_rec) {
        this.date_rec = date_rec;
    }
    
}
