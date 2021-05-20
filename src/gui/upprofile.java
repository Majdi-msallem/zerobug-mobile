/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import entities.User;
import static gui.Login.userConncter;
import services.ServiceUser;


/**
 *
 * @author majdi
 */
public  class upprofile extends Form {
    Form current;
    public upprofile (Resources res ){
        System.out.println("UserConnecter"+userConncter);
        
         setUIID("LoginForm");
    
            TextField tfemail =new TextField(userConncter.getEmail());
                           addStringValue("Email", tfemail);
         TextField tfcin =new TextField(String.valueOf(userConncter.getCin()));
         addStringValue("cin", tfcin);
         TextField tfphone =new TextField(String.valueOf(userConncter.getPhone()));
         addStringValue("phone", tfphone);
         TextField tfname =new TextField(userConncter.getName());
         addStringValue("name", tfname);
     
        ComboBox Cg = new ComboBox<>();
        String[] lesTYpes = {"Homme", "Femme"};
        for (int i = 0; i < 2; i++) {
            Cg.addItem(lesTYpes[i]);}
     
        
         Button btnVal = new Button ("valider");
       btnVal.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent evt) {
                   User u =new User();
                   u.setId(userConncter.getId());
        u.setEmail(tfemail.getText());
        u.setCin(Integer.valueOf(tfcin.getText()));
        u.setPhone(Integer.valueOf(tfphone.getText()));
        u.setName(tfname.getText());
        u.setGenre(Cg.getSelectedItem().toString());
        if(ServiceUser.getInstance().EditProfil(u)==false){
             Dialog.show("","Error",new Command("OK"));
        }else{
                      userConncter.setEmail(tfemail.getText());
      userConncter.setCin(Integer.valueOf(tfcin.getText()));
        userConncter.setPhone(Integer.valueOf(tfphone.getText()));
       userConncter.setName(tfname.getText());
       userConncter.setGenre(Cg.getSelectedItem().toString());
                   
                 Dialog.show("update valider","Succees",new Command("OK"));
                 new List_reg(current).show();
        }
           
             }
       });
     
       
 

     add(Cg);
        add(btnVal);


//        addAll(tfemail,tfcin,tfphone,tfname);
        // indiquer la destination du boutton back
         //getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    }
           private void addStringValue(String s, Component v) {
        add(BorderLayout.west(new Label(s, "PaddedLabel")).
                add(BorderLayout.CENTER, v));
        //add(createLineSeparator(0xeeeeee));
    }
}
