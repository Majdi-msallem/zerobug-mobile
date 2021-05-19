/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import entite.Livraison;
import service.ServiceLivraison;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.ContainerList;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.MyApplication;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class chercherClinique extends SideMenu{
     Resources theme;
   String chercher;
    private ContainerList listContainer;

    public chercherClinique(Resources theme, String chercher) {
        this.setLayout(BoxLayout.y());
        Toolbar tb = getToolbar();
		tb.setUIID("Toolbar");
                setUIID("LoginForm");
        this.theme = theme;
       
        this.chercher=chercher; 
        
        addGui();
        addAction();
    }
       private void addGui() {
       listContainer = new ContainerList();
        listContainer.setScrollableY(false);
        listContainer.setScrollVisible(true);
            ServiceLivraison ms = new ServiceLivraison();
ArrayList<Livraison> allclq =ms.getAllLiv();

        for (Livraison m : allclq){
       //AFFICHER Image
            
           if (m.getStatut().equals(chercher)){  
 Container c = new Container();
       c.setLayout(BoxLayout.y());
       
       
       c.add(new SpanLabel("Statut : " + m.getStatut()));
       c.add(new SpanLabel("Date de votre Livraison : " + m.getDate_liv()));
       
       
       listContainer.add(c);
       }
   
        } 
   this.add(listContainer);
   }
     private void addAction() {
     
     
  }
     protected void showOtherForm(Resources res) {
        new Prom(res).show();
    }
    
    
}
