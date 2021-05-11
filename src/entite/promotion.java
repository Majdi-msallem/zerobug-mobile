package entite;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class promotion {
    
    private int id,remise;
   private String nompromotion,description,img;
   private Date dateP;
   private List<String> art=new ArrayList<String>();
   private String nom; 
 

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<String> getArt() {
        return art;
    }

    public void setArt(List<String> art) {
        this.art = art;
    }

    public promotion() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRemise() {
        return remise;
    }

    public void setRemise(int remise) {
        this.remise = remise;
    }

    public String getNompromotion() {
        return nompromotion;
    }

    public void setNompromotion(String nompromotion) {
        this.nompromotion = nompromotion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getDateP() {
        return dateP;
    }

    public void setDateP(Date dateP) {
        this.dateP = dateP;
    }

    public promotion(int remise, String nompromotion, String description, String img, Date dateP) {
        this.remise = remise;
        this.nompromotion = nompromotion;
        this.description = description;
        this.img = img;
        this.dateP = dateP;
    }

    public promotion(int id, int remise, String nompromotion, String description, String img, Date dateP) {
        this.id = id;
        this.remise = remise;
        this.nompromotion = nompromotion;
        this.description = description;
        this.img = img;
        this.dateP = dateP;
    }

//    @Override
//    public String toString() {
//        return "promotion{" + "id=" + id + ", remise=" + remise + ", nompromotion=" + nompromotion + ", description=" + description + ", img=" + img + ", dateP=" + dateP + '}';
//    }

//    @Override
//    public String toString() {
//        return "promotion{" + "id=" + id + ", remise=" + remise + ", nompromotion=" + nompromotion + ", description=" + description + ", img=" + img + ", dateP=" + dateP + ", art=" + art + '}';
//    }

    @Override
    public String toString() {
        return "promotion{" + "id=" + id + ", remise=" + remise + ", nompromotion=" + nompromotion + ", description=" + description + ", img=" + img + ", dateP=" + dateP + ", art=" + art + '}'+'\n'+'\n';
    }




    
}
