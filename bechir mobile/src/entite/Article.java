/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

/**
 *
 * @author MSI
 */
public class Article {
    private int id;
    private String nom;
    private String description;
    private float prix;
    private int quantite;
    private String img;
    private int id_categorie;
    private int id_fabricant;
    private String nomcat;
    private String nomfab;
   

    public Article( String nom, String description, float prix, int quantite, String img,int id_categorie,int id_fabricant,String nomcat,String nomfab) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.quantite = quantite;
        this.img = img;
        this.id_categorie=id_categorie;
        this.id_fabricant=id_fabricant;
        this.nomcat=nomcat;
        this.nomfab=nomfab;
    }
    public Article( String nom, String description, float prix, int quantite, String img) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.quantite = quantite;
        this.img = img;
        
    }

    public Article() {
    }

    

    public Article(String nom, String description, float prix, int quantite, String img, String nomcat, String nomfab) {
        this.id=id;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.quantite = quantite;
        this.img = img;
        this.nomcat=nomcat;
        this.nomfab=nomfab;
    }
    public Article(int id,String nom, String description, float prix, int quantite, String img, String nomcat, String nomfab) {
        this.id=id;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.quantite = quantite;
        this.img = img;
        this.nomcat=nomcat;
        this.nomfab=nomfab;
    }



    public String getNomcat() {
        return nomcat;
    }

    public void setNomcat(String nomcat) {
        this.nomcat = nomcat;
    }

    public String getNomfab() {
        return nomfab;
    }

    public void setNomfab(String nomfab) {
        this.nomfab = nomfab;
    }
    
    

    public int getId_fabricant() {
        return id_fabricant;
    }

    public void setId_fabricant(int id_fabricant) {
        this.id_fabricant = id_fabricant;
    }
    

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

//    @Override
//    public String toString() {
//        return "Article{" + "id=" + id + ", nom=" + nom + ", description=" + description + ", prix=" + prix + ", quantite=" + quantite + ", img=" + img + '}';
//    }  

    @Override
    public String toString() {
        return "Article{" + "id=" + id + ", nom=" + nom + ", description=" + description + ", prix=" + prix + ", quantite=" + quantite + ", img=" + img + ", nomcat=" + nomcat + ", nomfab=" + nomfab + '}'+'\n'+'\n';
    }
    
}
