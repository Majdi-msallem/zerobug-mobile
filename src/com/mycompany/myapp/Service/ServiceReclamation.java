/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.Service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.Entities.Reclamation;
import com.mycompany.myapp.Utils.DataSource;
import com.mycompany.myapp.Utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.codename1.messaging.Message;
import com.codename1.ui.Display;
import java.util.Date;

/**
 *
 * @author user
 */
public class ServiceReclamation {
    private ConnectionRequest request;
	public boolean resultOK;

    private boolean responseResult;
    public ArrayList<Reclamation> reclamations;
    
    public ServiceReclamation() {
		request = DataSource.getInstance().getRequest();
	}
    
    public ArrayList<Reclamation> parseEntreprise(String jsonText) throws ParseException  {
        try {
            reclamations = new ArrayList<>();
            Reclamation p = new Reclamation();
            JSONParser jp = new JSONParser();
            
           //String s = "["+jsonText+"]";
            System.out.println(jsonText);
            Map<String, Object> ProjectListJson = jp.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) ProjectListJson.get("root");
            for (Map<String, Object> obj : list) {
              
		int id = (int)Float.parseFloat(obj.get("id").toString());
                String type=obj.get("type").toString();
            String des = obj.get("description").toString();
   
               
               
              

                reclamations.add(new Reclamation(id, type, des));
            }


        } catch (IOException ex) {
			
        }

        return reclamations;
    }
    
    public ArrayList<Reclamation> getAllReclamations() {
        String url = Statics.BASE_URL + "/AllReclamation";

        request.setUrl(url);
        request.setPost(false);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    reclamations = parseEntreprise(new String(request.getResponseData()));
                    request.removeResponseListener(this);
                } catch (ParseException ex) {
                   // Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);
        
        return reclamations;
    }
    
    public String  find_(String a){
			if(!a.substring(0,1).equals("[")){
                a = "["+a+"]";
			}
        return a;
    }
    
    public void addReclamation(Reclamation p) {
       //try {
            
            MultipartRequest cr = new MultipartRequest();
            cr.setUrl(Statics.BASE_URL+"/addReclamationJSON/new");
            cr.setPost(false);
            cr.addArgument("description", p.getDescription());
            cr.addArgument("type", p.getType());
			
			
            cr.addResponseListener(e -> {
             

                if(cr.getResponseCode() == 200)
                    Dialog.show("Ajouter","Reclamation ajouté " , "OK",null);

                  //  envoyerMail("wassim.benafia@esprit.tn", "New Reclamtion ", p.getType()+" "+p.getDescription());
            });
            NetworkManager.getInstance().addToQueueAndWait(cr);
            
        /*   }
        catch (ParseException e1) {
         e1.printStackTrace();
         }*/
    }
    
    public boolean deleteReclamation(int id) {
       //try {
            
            MultipartRequest cr = new MultipartRequest();
            cr.setUrl(Statics.BASE_URL+"/deleteReclamationJSON/"+id);
            cr.setPost(false);
           
			
			
            cr.addResponseListener(e -> {
             

                if(cr.getResponseCode() == 200)
                    Dialog.show("Supprimer","Reclamation Supprimer " , "OK",null);

                  //  envoyerMail("wassim.benafia@esprit.tn", "New Reclamtion ", p.getType()+" "+p.getDescription());
            });
            NetworkManager.getInstance().addToQueueAndWait(cr);
            return true;
        /*   }
        catch (ParseException e1) {
         e1.printStackTrace();
         }*/
    }
    
    
     public ArrayList<Reclamation> search(String input) {
        String url = Statics.BASE_URL + "/AllReclamationSearch/"+input;

        request.setUrl(url);
        request.setPost(false);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    reclamations = parseEntreprise(new String(request.getResponseData()));
                } catch (ParseException ex) {
                  //  Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return reclamations;
    }
     
     public  void envoyerMail(String email,String Subject,String Object) {

        Message m = new Message(Object);
        Display.getInstance().sendMessage(new String[] {email}, Subject, m);
    
}
}
