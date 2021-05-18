/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import static com.codename1.charts.util.ColorUtil.red;
import com.codename1.components.FloatingHint;
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
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.util.Resources;
import entities.User;
import com.codename1.ui.Form;
import com.codename1.ui.plaf.Style;


import services.ServiceUser;
import static services.ServiceUser.userConncter;
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
                     static User Userconnected = new User();
        public static User userConncter;

public Login ( Resources res,Form previous  ) {
   
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
         
         Button signUp = new Button("Sign Up");
         
         Button mp  = new Button ("forget password ?","CenterLabel");
           Style s = new Style(mp.getUnselectedStyle());
         s.setFgColor(0xf21f1f);
        signUp.addActionListener(e -> new AddregForm(current).show());
        signUp.setUIID("Link");
        Label doneHaveAnAccount = new Label("Don't have an account?");
        
      
                
      
      
    
    
    
          loginButton.addActionListener(new ActionListener(){
                 @Override
             public void actionPerformed(ActionEvent evt) {

                 
        User u =new User(tfemail.getText(),tfpassword.getText());
 Userconnected= ServiceUser.getInstance().UserConnecter( u);
     if (ServiceUser.getInstance().Login(u)==false){
               Dialog.show("","Check Eamil And Password",new Command("OK"));
              // new SignInForm(res,current).show();
           }else{
                       // System.out.println(userConncter);
                 //Userconnected= ServiceUser.getInstance().UserConnecter(username.getText(), password.getText());
                //VarGlobales.setusername(username.getText());
         new List_reg(current).show();
            }
            }
    });
    
                 
                 
//                 if (tfemail.getText().isEmpty() || tfpassword.getText().isEmpty())
//                           Dialog.show("Alert ","Verifier vos champs",new Command ("OK"));
//                 
//                      else{
//                          User u =new User(tfemail.getText(),tfpassword.getText());
//                      
//                      ServiceUser su =new  ServiceUser();
//                      
//                
//                  if( su.Login(u) ) {
//                      Dialog.show("Succes","Login accepted",new Command ("ok"));
//                       Userconnected= ServiceUser.getInstance().UserConnecter(u);
//                       System.out.println(Userconnected);
//                  }
//                           
//                      }
//             }
//           });
//          

             mp.addActionListener( e->new  ActivateForme(res,current).show());
           
             Container cnt = BoxLayout.encloseX(doneHaveAnAccount, signUp);
           addAll(welcome,tfemail,tfpassword,loginButton,cnt, mp);
    getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
                   }
}