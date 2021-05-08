/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import static com.codename1.io.Log.e;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import entities.User;
import services.ServiceUser;

/**
 *
 * @author majdi
 */
public class AddregForm  extends Form{
Form current;
        public static User userConncter;

    public AddregForm(Form previous ) {
        current=this;
        setUIID("LoginForm");
           Container welcome = FlowLayout.encloseCenter(
                new Label("CREATE NEW ACCOUNT", "WelcomeWhite")
              
        );
         //cree l'interface d'ajout
         setLayout(BoxLayout.y());
         
         TextField tfemail =new TextField("","Useremail");
         TextField tfpassword =new TextField("","Userpassword");
         TextField tfcin =new TextField("","Usercin");
         TextField tfphone =new TextField("","Userphone");
         TextField tfname =new TextField("","Userename");
        // TextField tfgenre =new TextField("","Usergenre");
           Label g = new Label("g");
        ComboBox Cg = new ComboBox<>();
        String[] lesTYpes = {"Homme", "Femme"};
        for (int i = 0; i < 2; i++) {
            Cg.addItem(lesTYpes[i]);}
        
        
       
        
         Button btnValider = new Button ("Inscription");
        btnValider.setUIID("LoginButton");
         
           btnValider.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent evt) {
                 if (tfemail.getText().isEmpty() || tfpassword.getText().isEmpty() ||
                         tfcin.getText().isEmpty() || tfphone.getText().isEmpty() ||
             tfname.getText().isEmpty() ||  Cg.getSelectedItem().toString().isEmpty()  )
                     
                     Dialog.show("Alert ","Verifier vos champs",new Command ("OK"));
                 
                 else{
                     try{ 
                         User u =new User(tfemail.getText(),"ROLE_USER",tfpassword.getText(),
                 Integer.parseInt(tfcin.getText()),Integer.parseInt(tfphone.getText()),
                 tfname.getText(),Cg.getSelectedItem().toString());
                         //System.out.println(u);
                         if (new ServiceUser().addregForm(u))  {
                            Dialog.show("Succes","Connection accepted",new Command ("ok"));
                         
//      userConncter.setId(u.getId());
//       userConncter.setEmail(u.getEmail());
//      userConncter.setRoles(u.getRoles());
//        userConncter.setPassword(u.getPassword());
//       userConncter.setCin(u.getCin());
//       userConncter.setPhone(u.getPhone());
//       userConncter.setName(u.getName());
//       userConncter.setGenre(u.getGenre());
//System.out.println(userConncter);
                                          new List_reg(current,u).show();
                                    

                         }  else {
                   Dialog.show("ERROR","Server error",new Command ("ok"));

                         }
                     }catch (NumberFormatException e){
                         Dialog.show("ERROR","Status must be a number",new Command ("OK"));
                     }
                  
                 }
                
             }
                
           } );

         
         
         addAll(welcome,tfemail,tfpassword,tfcin,tfphone,tfname,Cg,btnValider );
         //indiquer la destination du boutton back
         getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    }
    
}
