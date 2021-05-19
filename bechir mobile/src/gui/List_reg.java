/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import entite.User;
import static gui.Login.Userconnected;
import static service.ServiceUser.userConncter;
import utilis.Statics;

/**
 * 
 * @author majdi
 */
public class List_reg extends Form {
       
Form current;

    public List_reg(Form previous,User u ) {
        // setTitle("Profil");
          setUIID("LoginForm");
               Container c = new Container(BoxLayout.y());

  String url=Statics.BASE_URL+"/UserJSON/"+userConncter.getId();
       

        c.add(new Label("Nom : " + userConncter.getName()));
        c.add(new Label("email : " +userConncter.getEmail()));
        c.add(new Label("cin : " + userConncter.getCin()));
     //   c.add(new Label("mdp : " + userConncter.getPassword()));

        //c.add(new Label("role : " + u.getUserConncter().getRoles()));
        c.add(new Label("tel : " +userConncter.getPhone()));
        c.add(new Label("genre : " +userConncter.getGenre()));
     
        add(c);

        show();
        
        
         getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
        
        
        
        
        
        
        
        
    }


    
    
}
