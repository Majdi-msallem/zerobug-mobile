/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */

package com.mycompany.gui;

import com.codename1.components.ScaleImageLabel;
import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Component;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.gui.entities.Commande;
import com.mycompany.gui.services.serviceCommande;
/**
 * The user profile form
 *
 * @author Shai Almog
 */
public class ProfileForm extends BaseForm {

    public ProfileForm(Resources res) {
        super("Newsfeed", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Add Commande");
        getContentPane().setScrollVisible(false);
        
        super.addSideMenu(res);
        
        tb.addSearchCommand(e -> {});
        
        
        Image img = res.getImage("profile-background.jpg");
        if(img.getHeight() > Display.getInstance().getDisplayHeight() / 3) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 3);
        }
        ScaleImageLabel sl = new ScaleImageLabel(img);
        sl.setUIID("BottomPad");
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);

        Label facebook = new Label("786 followers", res.getImage("facebook-logo.png"), "BottomPad");
        Label twitter = new Label("486 followers", res.getImage("twitter-logo.png"), "BottomPad");
        facebook.setTextPosition(BOTTOM);
        twitter.setTextPosition(BOTTOM);
        
        add(LayeredLayout.encloseIn(
                sl,
                BorderLayout.south(
                    GridLayout.encloseIn(3, 
                            facebook,
                            FlowLayout.encloseCenter(
                                new Label(res.getImage("profile-pic.jpg"), "PictureWhiteBackgrond")),
                            twitter
                    )
                )
        ));
          TextField nom = new TextField("","nom ");
        nom.setUIID("TextFieldBlack");
        addStringValue("nom ", nom);
        
        TextField prenom = new TextField("","prenom ");
        prenom.setUIID("TextFieldBlack");
        addStringValue("prenom ", prenom);
         
        TextField tel = new TextField("", "telephone", 12, TextField.NUMERIC);
        tel.setUIID("TextFieldBlack");
        addStringValue("telephone", tel);
        
        TextField adressse = new TextField("","adresse");
        adressse.setUIID("TextFieldBlack");
        addStringValue("adresse", adressse);
        
        TextField descriptionAd = new TextField("","description adresse");
        descriptionAd.setUIID("TextFieldBlack");
        addStringValue("description adresse", descriptionAd);
        
        TextField gouvernorat = new TextField("","gouvernorat");
        gouvernorat.setUIID("TextFieldBlack");
        addStringValue("gouvernorat", gouvernorat);
        
        TextField cdp = new TextField("", "Code postale", 12, TextField.NUMERIC);
        cdp.setUIID("TextFieldBlack");
        addStringValue("Code postale", cdp);
        
        TextField prixtotal = new TextField("", "prixtotal", 12, TextField.NUMERIC);
        prixtotal.setUIID("TextFieldBlack");
        addStringValue("prixtotal", prixtotal);
        
        Button supp = new Button("Ajouter Commande");
        supp.setUIID("Label");
        
        supp.addActionListener(e->{
            
                Commande c = new Commande(2,3,Double.valueOf(prixtotal.getText()), adressse.getText(), nom.getText(), prenom.getText(),descriptionAd.getText(), gouvernorat.getText(),Integer.valueOf(cdp.getText()),Integer.valueOf(tel.getText()));
                serviceCommande.getInstance().ajouterCommande(c);
            try {
                mailUtil.sendMail("mahdilaouity@gmail.com", "hamza.krid@esprit.tn", "203JMT0168", "Notification", "Votre commande est bien enregistre");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
             new NewsfeedForm(res).show();
            
        });
         addStringValue("",FlowLayout.encloseCenterMiddle(supp));

        
        
        
    }
    
    private void addStringValue(String s, Component v) {
        add(BorderLayout.west(new Label(s, "PaddedLabel")).
                add(BorderLayout.CENTER, v));
        add(createLineSeparator(0xeeeeee));
    }
}
