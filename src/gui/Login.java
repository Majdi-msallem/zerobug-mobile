/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import static com.codename1.charts.util.ColorUtil.red;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.RoundBorder;
import entities.User;

import services.ServiceUser;
import utils.Statics;
import static utils.Statics.userConncter;


/**
 *
 * @author majdi
 */
public class Login extends Form{
    Form current;
        public static ServiceUser instance;
    public boolean resultOK; 
    private ConnectionRequest req;

public Login (Form previous ) {
          ServiceUser su = new ServiceUser();

    current=this;
          setUIID("LoginForm");
         
            
           
        
         //cree l'interface d'ajout
         setLayout(BoxLayout.y());
           
                      
                       TextField tfemail =new TextField("","Useremail");
                       TextField tfpassword =new TextField("","Userpassword");
           
       
  
            Container welcome = FlowLayout.encloseCenter(
                new Label("WELCOME", "WelcomeWhite")
              
        );
        
   
         Button loginButton = new Button ("Login");
         loginButton.setUIID("LoginButton");
    
    
          loginButton.addActionListener(new ActionListener(){
                 @Override
             public void actionPerformed(ActionEvent evt) {
                      if (tfemail.getText().isEmpty() || tfpassword.getText().isEmpty())
                           Dialog.show("Alert ","Verifier vos champs",new Command ("OK"));
                 
                      else{
                          User u =new User(tfemail.getText(),tfpassword.getText());
                      
                      ServiceUser su =new  ServiceUser();
                      
                  if( su.Login(u)  ) {
                      Dialog.show("Succes","Login accepted",new Command ("ok"));
                      
                      
                  }
                       
                      }
             }
           });
           
           addAll(welcome,tfemail,tfpassword,loginButton);
    getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
                   }
}