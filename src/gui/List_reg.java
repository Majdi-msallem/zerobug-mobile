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
import static gui.Login.Userconnected;
import static services.ServiceUser.userConncter;
import utils.Statics;

/**
 * 
 * @author majdi
 */
public class List_reg extends Form {
       

    public List_reg(Form previous,User u ) {
         setTitle("Profil");
               Container c = new Container(BoxLayout.y());

  String url=Statics.BASE_URL+"/UserJSON/?id="+userConncter.getId();
       

        c.add(new Label("Nom : " + userConncter.getName()));
        c.add(new Label("email : " +userConncter.getEmail()));
        c.add(new Label("cin : " + userConncter.getCin()));
        c.add(new Label("mdp : " + userConncter.getPassword()));

        //c.add(new Label("role : " + u.getUserConncter().getRoles()));
        c.add(new Label("tel : " +userConncter.getPhone()));
        c.add(new Label("genre : " +userConncter.getGenre()));
     
        add(c);

        show();
        
         getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
        
        
        
        
        
        
        
        
    }

    List_reg(Form current) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
