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
import entities.User;
import utils.Statics;

/**
 * 
 * @author majdi
 */
public class List_reg extends Form {
       

    public List_reg(Form previous,User u ) {
         setTitle("Profil");
               Container c = new Container(BoxLayout.y());

  String url=Statics.BASE_URL+"/UserJSON/?id="+u.getId();
       

        c.add(new Label("Nom : " + u.getName()));
        c.add(new Label("email : " + u.getEmail()));
        c.add(new Label("cin : " + u.getCin()));
        c.add(new Label("mdp : " + u.getPassword()));

        //c.add(new Label("role : " + u.getUserConncter().getRoles()));
        c.add(new Label("tel : " +u.getPhone()));
        c.add(new Label("genre : " +u.getGenre()));
     
        add(c);

        show();
        
         getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
        
        
        
        
        
        
        
        
    }
    
    
}
