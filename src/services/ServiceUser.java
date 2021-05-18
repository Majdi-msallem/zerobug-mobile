/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

//import com.codename1.io.CharArrayReader;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
//import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.io.Storage;
import com.codename1.ui.TextField;
//import com.codename1.ui.List;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import entities.User;
import java.io.IOException;
//import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

//import java.util.Map;
import utils.Statics;

/**
 *
 * @author majdi
 */
public class ServiceUser {
    public static ServiceUser instance;
    public boolean resultOK; 
    private ConnectionRequest req;
    ArrayList<User> tasks = new ArrayList<>();
        public static User userConncter;
 String json;
    
    public ServiceUser (){
        req = new ConnectionRequest ();
    }
    
    public static ServiceUser getInstance(){
        if (instance == null )
             instance = new ServiceUser();
     
        return instance;
    }
    
    public boolean addregForm(User u){ 
        
        String url=Statics.BASE_URL+"/RegisterJSON/new?email="+u.getEmail()+"&roles="+u.getRoles()+"&password="+u.getPassword()+"&cin="+u.getCin()+"&phone="+u.getPhone()+"&name="+u.getName()+"&genre="+u.getGenre();
        req.setUrl(url);
       req.addResponseListener(new ActionListener<NetworkEvent>(){
       
            

            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK=req.getResponseCode ()==200;
                req.removeResponseListener(this);
            }
    });
       NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    
    public boolean Login (User u){
        
                                    String url=Statics.BASE_URL+"/serviceLogin/"+u.getEmail()+"/"+u.getPassword();
                                           req.setUrl(url);
                                           req.addResponseListener(new ActionListener<NetworkEvent>(){
                                        @Override
                                        public void actionPerformed(NetworkEvent evt) {
                                            resultOK=req.getResponseCode ()==200;
                              
                req.removeResponseListener(this);}
    });
       NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
 
             }
             
    
    
    
       public User UserConnecter(User uc) {
        User u = new User();
    String url=Statics.BASE_URL+"/serviceLogin/"+uc.getEmail()+"/"+uc.getPassword();
      req.setUrl(url);
       NetworkManager.getInstance().addToQueueAndWait(req);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
           @Override
        public void actionPerformed(NetworkEvent evt) {
               User users = parseTasks(new String(req.getResponseData()));
               System.out.println("fycgvuhbijnkl"+users);
              req.removeResponseListener(this);
              u.setId(users.getId());
              u.setEmail(users.getEmail());
              u.setPassword(users.getPassword());
              u.setName(users.getName());
              u.setPhone(users.getPhone());
              u.setGenre(users.getGenre());
              u.setCin(users.getCin());
              System.out.println(u);
                 }
        });
        return u;
             }
       
       public User parseTasks(String jsonText) {
             try {
                userConncter= new User();
                 JSONParser j = new JSONParser();
                 String [ ] monTableau;
                 Map<String,Object> UserJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));                             
                float id = Float.parseFloat(UserJson.get("id").toString());
                userConncter.setId((int)id);
                 userConncter.setEmail(UserJson.get("email").toString());
               userConncter.setPassword(UserJson.get("password").toString());
                float  cin = Float.parseFloat(UserJson.get("cin").toString());
         userConncter.setCin((int)cin);
         float phone = Float.parseFloat(UserJson.get("phone").toString());
         userConncter.setPhone((int)phone);
               userConncter.setName(UserJson.get("name").toString());
                userConncter.setGenre(UserJson.get("genre").toString());
              


                 return userConncter;
             } catch (IOException ex) {
             }
             return userConncter;
  }

    
//    public boolean afficherProfile (User u){
//        String url=Statics.BASE_URL+"/UserJSON/?id="+u.getId();
//        req.setUrl(url);
//               req.addResponseListener(new ActionListener<NetworkEvent>(){
//   @Override
//            public void actionPerformed(NetworkEvent evt) {
//                resultOK=req.getResponseCode ()==200;
//                req.removeResponseListener(this);
//            }
//    });
//       NetworkManager.getInstance().addToQueueAndWait(req);
//        return resultOK;
//    }
    
    
//    public ArrayList<User> getAllLiv(){
//        ConnectionRequest con = new ConnectionRequest();
//    String url = "http://127.0.0.1:8000/AllUser";
//
//      //  System.out.println("mouch normal"+url);
//        
//    con.setUrl(url);
//    con.addResponseListener(new ActionListener<NetworkEvent>() {
//        @Override
//        public void actionPerformed(NetworkEvent evt) {
////        promo = liste(new String(req.getResponseData()));
////        req.removeResponseListener(this);
//ServiceUser su = new ServiceUser();
//tasks = su.liste(new String(con.getResponseData()));
//        }
//    });
//    NetworkManager.getInstance().addToQueueAndWait(con);
//    return tasks;
//    }
//    
//    
//    
//    public ArrayList<User> liste(String json){
//        ArrayList<User> lista = new ArrayList<>();
//        try {
//            
//            JSONParser j = new JSONParser();
//            Map<String, Object> users = j.parseJSON(new CharArrayReader(json.toCharArray()));
//          
//            List<Map<String, Object>> list = (List<Map<String, Object>>)users.get("root");
//
//            for (Map<String, Object> obj : list) {
//                User u = new User();
//                 float id = Float.parseFloat(obj.get("id").toString());
//                u.setId((int) id);
//                 
//                lista.add(u);
//            }
//     
//        } catch (IOException ex) {
//            System.out.println("test1");
//        }
//        System.out.println("test2");
//        System.out.println(lista);
//    return lista;
//    }
    
  //heki 5dmtha taw nhabtha ala description
    public String getPasswordByEmail(String email, Resources rs ) {
        
        
        String url = Statics.BASE_URL+"/getPasswordByEmail?email="+email;
        req = new ConnectionRequest(url, false); //false ya3ni url mazlt matba3thtich lel server
        req.setUrl(url);
        
        req.addResponseListener((e) ->{
            
            JSONParser j = new JSONParser();
            
             json = new String(req.getResponseData()) + "";
            
            
            try {
            
          
                System.out.println("data =="+json);
                
                Map<String,Object> password = j.parseJSON(new CharArrayReader(json.toCharArray()));
                
                
            
            
            }catch(Exception ex) {
                ex.printStackTrace();
            }
            
            
            
        });
    
         //ba3d execution ta3 requete ely heya url nestanaw response ta3 server.
        NetworkManager.getInstance().addToQueueAndWait(req);
    return json;
    }

}
