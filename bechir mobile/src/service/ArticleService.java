
package service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import entite.Article;
import entite.Categorie;
import entite.promotion;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import utilis.Statics;


public class ArticleService {
 
    ArrayList<Article> listArt = new ArrayList<>();
    public static ArticleService instance;
    
    
    
    
    public static ArticleService getInstance(){
    if(instance==null){
        instance = new ArticleService();
    }
    return instance;
    }
    
    public ArrayList<Article> liste(String json){
        ArrayList<Article> lista = new ArrayList<>();
        try {
            
            JSONParser j = new JSONParser();
            Map<String, Object> articles = j.parseJSON(new CharArrayReader(json.toCharArray()));
            System.out.println("bechir"+json);
            System.out.println("Lista"+articles);
            List<Map<String, Object>> list = (List<Map<String, Object>>) articles.get("root");

            for (Map<String, Object> obj : list) {
                Article a = new Article();
                Categorie c = new Categorie();
                float id = Float.parseFloat(obj.get("id").toString());
                a.setId((int) id);
                a.setNom(obj.get("nom").toString());
                float quantite = Float.parseFloat(obj.get("quantite").toString());
                a.setQuantite((int) quantite);
                float prix = Float.parseFloat(obj.get("prix").toString());
                a.setPrix((int) prix);
                a.setDescription(obj.get("description").toString());
//                float cat_id = Integer.parseInt(obj.get("categorie").toString());
//                a.setId_categorie((int)cat_id);
                a.setImg(obj.get("img").toString());

                Map<String, Object> cat = (Map<String, Object>) obj.get("categorie");
//                System.out.println("skan "+cat);
                String nomC =cat.get("nom").toString();
//                System.out.println("mehdi "+(int)id_c);
                a.setNomcat(nomC);
//                c.setNom(cat.get("nom").toString());
                
                Map<String, Object> fab = (Map<String, Object>) obj.get("fabricant");
//                System.out.println("skan "+cat);
                String nomF = fab.get("nom").toString();
//                System.out.println("mehdi "+(int)id_c);
                a.setNomfab(nomF);
                
                
//                c.setNom(cat.get("nom").toString());
//                Map<String, Object> cat = (Map<String, Object>) obj.get("nomcat");
//                float id_c = Float.parseFloat(cat.get("id").toString());
//                c.setId((int) id_c);
//                c.setNom(cat.get("nom").toString());
//                a.setId_categorie(c.getId());
                
                
//                float cat_id = Float.parseFloat(obj.get("categorie_id").toString());
//                a.setId_categorie((int) cat_id);
//                float fab_id = Float.parseFloat(obj.get("fabricant_id").toString());
//                a.setId_fabricant((int) fab_id);
//                a.setNomcat(obj.get("categorie").toString());
                
                
                lista.add(a);
            }
     
        } catch (IOException ex) {
            System.out.println("test1");
        }
        System.out.println("test2");
        System.out.println(lista);
    return lista;
    }
    
    
    
    public ArrayList<Article> getAllArt(){
        ConnectionRequest con = new ConnectionRequest();
    String url = Statics.BASE_URL+"/allArtJSON";

        System.out.println("mouch normal"+url);
        
    con.setUrl(url);
    con.addResponseListener(new ActionListener<NetworkEvent>() {
        @Override
        public void actionPerformed(NetworkEvent evt) {
//        promo = liste(new String(req.getResponseData()));
//        req.removeResponseListener(this);
ArticleService as = new ArticleService();
listArt = as.liste(new String(con.getResponseData()));
        }
    });
    NetworkManager.getInstance().addToQueueAndWait(con);
    return listArt;
    }
      
}