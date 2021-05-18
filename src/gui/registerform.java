/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;

/**
 *
 * @author majdi
 */
public class registerform extends Form {
    Form current;
      public registerform (Resources res){
          current=this;
          setTitle("home");
          
          setLayout(BoxLayout.y());
          
          add(new Label (" choose an option"));
          Button btninscription =new Button ("Signup");
          Button btnListreg = new Button ("afficher");
          Button btnlog =new Button ("Login");
          
          
          btninscription.addActionListener( e->new  AddregForm(current).show());
       //    btnListreg.addActionListener( e->new  List_reg(current).show());
           btnlog.addActionListener( e->new  Login(res,current).show());
             addAll(btninscription,btnListreg,btnlog);

      }
}
