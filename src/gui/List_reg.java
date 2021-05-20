/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.components.FloatingActionButton;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import entities.User;

import static services.ServiceUser.userConncter;
import utils.Statics;

/**
 * 
 * @author majdi
 */
public class List_reg extends  Form {
     Resources res;  
Form current;

    public List_reg(Form previous ) {
        // setTitle("Profil");
       
          setUIID("LoginForm");
               Container c = new Container(BoxLayout.y());

 // String url=Statics.BASE_URL+"/UserJSON/"+userConncter.getId();
       

        c.add(new Label("Nom : " + userConncter.getName()));
        c.add(new Label("email : " +userConncter.getEmail()));
        c.add(new Label("cin : " + userConncter.getCin()));
     //   c.add(new Label("mdp : " + userConncter.getPassword()));

        //c.add(new Label("role : " + u.getUserConncter().getRoles()));
        c.add(new Label("tel : " +userConncter.getPhone()));
        c.add(new Label("genre : " +userConncter.getGenre()));
        
       Button btnup = new Button ("update");
    
        addAll(c,btnup);
        
        btnup.addActionListener( e->new  upprofile(res).show());
     //getToolbar().addCommandToSideMenu("Promotion", null, e -> new Login(res,current));
     getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
         
         
         

        
        
        
        
        
        
    }


   

    
     
}
