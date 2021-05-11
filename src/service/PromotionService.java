package service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import entite.promotion;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import utilis.statics;


public class PromotionService {
    
    ArrayList<promotion> listpromo = new ArrayList<>();
    public static PromotionService instance;
    String[] tableauChaine;
    List<String> listaTest = new ArrayList<String>();
    
    
    public static PromotionService getInstance(){
    if(instance==null){
        instance = new PromotionService();
    }
    return instance;
    }
    
    public ArrayList<promotion> liste(String json){
        ArrayList<promotion> lista = new ArrayList<>();
        
        try {
            
            JSONParser j = new JSONParser();
            Map<String, Object> promotions = j.parseJSON(new CharArrayReader(json.toCharArray()));
            System.out.println("bechir"+json);
            System.out.println("Lista"+promotions);
            List<Map<String, Object>> list = (List<Map<String, Object>>) promotions.get("root");

            for (Map<String, Object> obj : list) {
                promotion p = new promotion();

                float id = Float.parseFloat(obj.get("id").toString());
                p.setId((int) id);
                p.setNompromotion(obj.get("nompromotion").toString());
                float remise = Float.parseFloat(obj.get("remise").toString());
                p.setRemise((int) remise);
                p.setDescription(obj.get("description").toString());
                p.setImg(obj.get("img").toString());
                
                
                List<Map<String, Object>> art = (List<Map<String, Object>>) obj.get("articles");
                if(art.isEmpty() ){
                        System.out.println("vide");
//                                        nomC = objt.get("nom").toString();
//                               listaTest.add(nomC);         
                }else
                {
                for (Map<String, Object> objt : art) {
                String nomC = objt.get("nom").toString();
                listaTest.add(nomC);
                System.out.println("test"+listaTest.size());}
                
                p.setArt(listaTest);
                }
//                List<Map<String, Object>> art = (Map<String, Object>) obj.get("articles");
                
                
//                System.out.println("ZEBI "+nomC);
//                for(int i=0 ; i<tableauChaine.length;i++){
//                
//                
//                }
               
//                art.add(objt);
//                System.out.println("AASBA "+listaTest);
//                p.setArt((ArrayList<String>) listaTest);
//                     System.out.println("For Loop");
//                p.setArt(listaTest);
//                p.setArt(listaTest);
                
                 
//               p.setArt(listaTest);  
                
//                Map<String, Object> nom = (Map<String, Object>) obj.get("nom");
//                String nomT =nom.get("nom").toString();
//                System.out.println("skan "+cat);
                
//                System.out.println("test"+nomT);
//                System.out.println("mehdi "+(int)id_c);
                    
                
//                p.setImg(obj.get("img").toString());
//                p.setDateP((Date) obj.get("date"));
//                Map<String, Object> datep = (Map<String, Object>) obj.get("date");
//                float date = Float.parseFloat(datep.get("timestamp").toString());
//                Date l2Date = new Date((long) date * 1000);
//                p.setDateP(l2Date);
                lista.add(p);
            }
     
        } catch (IOException ex) {
            System.out.println("test1");
        }
        
        System.out.println(lista);
    return lista;
    }
    
    
    
    public ArrayList<promotion> getAllpromo(){
        ConnectionRequest con = new ConnectionRequest();
    String url = statics.BASE_URL+"allPromoJSON";

        System.out.println("mouch normal"+url);
        
    con.setUrl(url);
    con.addResponseListener(new ActionListener<NetworkEvent>() {
        @Override
        public void actionPerformed(NetworkEvent evt) {
//        promo = liste(new String(req.getResponseData()));
//        req.removeResponseListener(this);
PromotionService ps = new PromotionService();
listpromo = ps.liste(new String(con.getResponseData()));
        }
    });
    NetworkManager.getInstance().addToQueueAndWait(con);
    return listpromo;
    }
      
}
