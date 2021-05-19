/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;

import entite.Livraison;
import java.io.IOException;


import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



/**
 *
 * @author bechi
 */
public class ServiceLivraison {
    ArrayList<Livraison> tasks = new ArrayList<>();
    public static ServiceLivraison instance;
    public boolean resultOK;
    private ConnectionRequest req;
    private String path ;
    public ServiceLivraison(){
        req= new ConnectionRequest();
    }
    public static ServiceLivraison getInstance(){
        if (instance == null){
            instance = new ServiceLivraison();
        }
        return instance;
        }
//    public ArrayList<Livraison> parseTasks(String jsonText){
//        try {
//            tasks = new ArrayList<>();
//            JSONParser j = new JSONParser();
//            Map<String,Object> tasksListJson= j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
//            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
//                    for( Map<String,Object> obj : list){
//                        Livraison t = new Livraison();
//                        float id = Float.parseFloat(obj.get("id").toString());
//                        float commande_id = Float.parseFloat(obj.get("commande_id").toString());
//                        
//                        t.setId((int)id);
//                        t.setLivreur_id(obj.get("livreur_id").toString());
//                        t.setCommande_id((int)commande_id);
//                        t.setDate_liv((Date) obj.get("date_liv"));
//                        
//                        
//                    }
//                    
//                    
//                    
//                    
//        } catch (IOException ex) {
//            Logger.getLogger(ServiceLivraison.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return tasks;
//        
//    }
//    private  List<Livraison> parseElements(String data){
//      List<Livraison> events = new ArrayList();
//     JSONParser j = new JSONParser();
//        try {
////            Map<String,Object> tasksListJson= (List)j.parseJSON(new CharArrayReader(data.toCharArray())).get("root");
////            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
//            List<Map> items = (List) j.parseJSON(new CharArrayReader(data.toCharArray())).get("root");
//            //System.out.println(j.parseJSON(data.toCharArray()));
//            System.out.println(data.toCharArray());
//            System.out.println( "bechir"+data);
//            System.out.println("Services.ServiceLivraison.parseElements()");
//            for (Map element : items){
//                Livraison e = new Livraison();
//                System.out.println(element+"bechir");
//                System.out.println(items);
//               
//                        
//                        e.setId((int)Float.parseFloat(element.get("id").toString()));
////                        e.setLivreur_id(element.get("livreur_id").toString());
////                        e.setCommande_id((int)commande_id);
//                        e.setDate_liv((Date) element.get("date_liv"));
////                        e.setStatut(element.get("statut").toString());
//                
//                
//                events.add(e);
//            }
//        } catch (IOException ex) {
//            
//        }
//        System.out.println(events);
//     return  events;
//     
//     
//    }
//     private  List<Livraison> parseElementse(String json) throws IOException{
//    JSONParser j = new JSONParser();
//            Map<String, Object> promotions = j.parseJSON(new CharArrayReader(json.toCharArray()));
//            System.out.println("bechir"+json);
//            System.out.println("Lista"+promotions);
//            List<Map<String, Object>> list = (List<Map<String, Object>>) promotions.get("root");
//
//            for (Map<String, Object> obj : list) {
//                Livraison e = new Livraison();
//
//                e.setId((int)Float.parseFloat(obj.get("id").toString()));
//                        e.setLivreur_id(obj.get("livreur_id").toString());
//                       e.setCommande_id((int)Float.parseFloat(obj.get("id").toString()));
//                        e.setDate_liv((Date) obj.get("date_liv"));
//                        e.setStatut(obj.get("statut").toString());     
//                lista.add(p);
//            }
//     
//         catch (IOException ex) {
//            System.out.println("test1");
//        }
//        System.out.println("test2");
//        System.out.println(lista);
//    return lista;
    public ArrayList<Livraison> liste(String json){
        ArrayList<Livraison> lista = new ArrayList<>();
       
        
        try {
            
            JSONParser j = new JSONParser();
            Map<String, Object> promotions = j.parseJSON(new CharArrayReader(json.toCharArray()));
            System.out.println("bechir"+json);
            System.out.println("Lista"+promotions);
            List<Map<String, Object>> list = (List<Map<String, Object>>) promotions.get("root");

            for (Map<String, Object> obj : list) {
                Livraison e = new Livraison();
                 float id = Float.parseFloat(obj.get("id").toString());
                e.setId((int) id);

                 //e.setId((int)Float.parseFloat(obj.get("id").toString()));
                        //e.setLivreur_id(obj.get("livreur_id").toString());
                       //e.setCommande_id((int)Float.parseFloat(obj.get("commande_id").toString()));
                       String date=(obj.get("DateLiv").toString());
                       e.setDate_liv(date);
                        String statut=obj.get("Statut").toString();
                        e.setStatut(statut);
                lista.add(e);
            }
     
        } catch (IOException ex) {
            System.out.println("test1");
        }
        System.out.println("test2");
        System.out.println(lista);
    return lista;
    }
    
    
    
    
    
    
    
    
    
    
//    public java.util.List<Livraison> getLivraison(){
//                Livraison Livraison ;
//
//     req.setUrl("http://127.0.0.1:8000/afficheJSON");
//        NetworkManager.getInstance().addToQueueAndWait(req);
//        String data = new String(req.getResponseData());
//       List<Livraison> Livraisons = parseElements(data);
//         
//
//        return Livraisons ;
    //}
    
    
    
   public ArrayList<Livraison> getAllLiv(){
        ConnectionRequest con = new ConnectionRequest();
    String url = "http://127.0.0.1:8000/afficheJSON";

        System.out.println("mouch normal"+url);
        
    con.setUrl(url);
    con.addResponseListener(new ActionListener<NetworkEvent>() {
        @Override
        public void actionPerformed(NetworkEvent evt) {
//        promo = liste(new String(req.getResponseData()));
//        req.removeResponseListener(this);
ServiceLivraison ps = new ServiceLivraison();
tasks = ps.liste(new String(con.getResponseData()));
        }
    });
    NetworkManager.getInstance().addToQueueAndWait(con);
    return tasks;
    }
   
   public ArrayList<Livraison> getAllLiv(String chercher){
        ConnectionRequest con = new ConnectionRequest();
    String url = "http://127.0.0.1:8000/afficheJSON/"+chercher;

        System.out.println("mouch normal"+url);
        
    con.setUrl(url);
    con.addResponseListener(new ActionListener<NetworkEvent>() {
        @Override
        public void actionPerformed(NetworkEvent evt) {
//        promo = liste(new String(req.getResponseData()));
//        req.removeResponseListener(this);
ServiceLivraison ps = new ServiceLivraison();
tasks = ps.liste(new String(con.getResponseData()));
        }
    });
    NetworkManager.getInstance().addToQueueAndWait(con);
    return tasks;
    }
}
    
    
    
    

    

