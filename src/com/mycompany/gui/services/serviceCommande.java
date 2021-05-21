/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui.services;

import com.codename1.components.InfiniteProgress;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import com.mycompany.gui.entities.Commande;
import com.mycompany.gui.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Hamza
 */
public class serviceCommande {
     public ArrayList<Commande> commande;

    public static serviceCommande instance = null;

    public boolean resultOk;
    private ConnectionRequest req;

    public serviceCommande() {req = new ConnectionRequest();}

    public static serviceCommande getInstance(){
        if(instance == null){
            instance = new serviceCommande();
        }
        return instance;
    }
    public HashMap<Integer,ArrayList<Integer>>commade_article;

    /*public serviceCommande() {
        ArrayList<Integer> L1 =new ArrayList<>();
        L1.add(2);
        L1.add(3);
        commade_article.put(103, L1);
         ArrayList<Integer> L2 =new ArrayList<>();
        L2.add(1);
        L2.add(2);
        commade_article.put(105, L2);
         ArrayList<Integer> L3 =new ArrayList<>();
        L3.add(2);
        L3.add(3);
        L3.add(4);
        commade_article.put(106, L3);
        
    }*/
    
    public boolean ajouterCommande(Commande c ){
        String url = Statics.BASE_URL+"/AjoutercommandeJson";
        InfiniteProgress prog = new InfiniteProgress();
        Dialog d = prog.showInfiniteBlocking();
        req.setDisposeOnCompletion(d);
        req.setUrl(url);
        
        req.addArgument("adresse",c.getAdresse());
        req.addArgument("descriptionAdresse", c.getDescription_adresse());
        req.addArgument("gouvernorat", c.getGouvernorat());
        req.addArgument("code_postal",String.valueOf(c.getCodepostale()));
        req.addArgument("numero_telephone",String.valueOf(c.getNumero_telephone()));
        req.addArgument("nom", c.getNom());
        req.addArgument("prenom", c.getPrenom());
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOk = req.getResponseCode() == 200;
                req.removeResponseListener(this);
            }
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOk;
        
    }
    
    
    public ArrayList<Commande> parseDemandes(String jsonText){
        try {
            commande=new ArrayList<>();
            JSONParser j=new JSONParser();
            Map<String,Object> demandeListJson=j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List <Map<String,Object>> list=(List <Map<String,Object>>) demandeListJson.get("root");
            for(Map<String,Object> obj : list){
                Commande C=new Commande();
                float idc=Float.parseFloat(obj.get("id").toString());
                C.setId((int)idc);
                Double m=Double.parseDouble(obj.get("prixTotal").toString());
                C.setPrix_total((Double)m);
                String emailu=obj.get("emailuser").toString().substring(obj.get("emailuser").toString().indexOf("email")+7,obj.get("emailuser").toString().length()-1);
                C.setEmail(emailu);
                System.out.println(obj.get("emailuser").toString());
                C.setAdresse(obj.get("adresse").toString());
                C.setNom(obj.get("nom").toString());
                C.setPrenom(obj.get("prenom").toString());
                C.setDescription_adresse(obj.get("descriptionAdresse").toString());
                C.setGouvernorat(obj.get("gouvernorat").toString());
                float cd=Float.parseFloat(obj.get("codePostal").toString());
                C.setCodepostale((int)cd);
                float nt=Float.parseFloat(obj.get("numeroTelephone").toString());
                C.setNumero_telephone((int)nt);
                commande.add(C);
               
                
                
               
                
            }
        } catch (IOException ex) {
            
        }
        return commande;
    }
    public ArrayList<Commande> afficher(){
        String url=Statics.BASE_URL+"/readCommandejason/";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>(){
            @Override
            public void actionPerformed(NetworkEvent evt) {
                commande=parseDemandes(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        
    });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return commande;
    }
    public void supprimer(int id) {
        String url = Statics.BASE_URL + "/deleteComJson/" +id; //création de l'URL
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
             
                req.removeResponseListener(this); //Supprimer cet actionListener
                /* une fois que nous avons terminé de l'utiliser.
                La ConnectionRequest req est unique pour tous les appels de 
                n'importe quelle méthode du Service task, donc si on ne supprime
                pas l'ActionListener il sera enregistré et donc éxécuté même si 
                la réponse reçue correspond à une autre URL(get par exemple)*/
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
    }
    
}
