/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import service.ServiceLivraison;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.ContainerList;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.MyApplication;
import entite.Livraison;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author bechi
 */
public class ListLiv extends SideMenu {
    private TextField chercher;
     private Button chercherbutton;
    
    private List<Livraison> listEvenements;
    private Form form ;
    private Toolbar tb;
    private Container evenements;
    private ContainerList listContainer;
    Resources theme;

//    public ListLiv(Form previous) {
//        setTitle("List of associations");
////        Container c = new Container(BoxLayout.y());
//        
//        
//        SpanLabel sp = new SpanLabel();
//        sp.setText(ServiceLivraison.getInstance().getAllLiv().toString());
//        add(sp);
////        c.add(new Label("id:"+u.getId()));
////        c.add(new Label("Date:"+u.getDate_liv()));
////        c.add(new Label("Statut:"+u.getStatut()));
////        add(c);
//        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
//        
//        
//        
//      //  public void addToolBar(Toolbar tb){
////        tb.addMaterialCommandToOverflowMenu("Promotions Liste", FontImage.MATERIAL_HOME, (e)->{
////
////            Prom ev = new Prom(); 
////            ev.getForm().show();
////        });
////
////    }
////     public Form getForm(){
////        return form;
////    } 
////
////
////public void setForm(){    
////        form.setTitle("Promotions");
////        form.setLayout(new BorderLayout());
////        form.setScrollable(false);
////        tb = form.getToolbar();
////        addToolBar(tb);
////        evenements = new Container(BoxLayout.y());
//    }
    
    
    Form current;
    
    public ListLiv(Resources res) {
        this.setLayout(BoxLayout.y());
        Toolbar tb = getToolbar();
		tb.setUIID("Toolbar");
                setUIID("LoginForm");
                 
        

         addGui();
        addAction();
        }
//        sp.setText(PromotionService.getInstance().getAllpromo().toString());
//        add(sp);
//        getToolbar().addMaterialCommandToLeftBar("Retour", FontImage.MATERIAL_ARROW_BACK, e-> res.showBack());
       
    
    

    protected void showOtherForm(Resources res) {
        new Prom(res).show();
    }
    private void addGui() {
        chercher = new TextField("","Veuillez entrer un nom pour chercher une clinique");
        chercherbutton = new Button("chercher");
        Container chercherContianer = new Container();
        chercherContianer.setLayout(BoxLayout.y());
        chercherContianer.addAll(chercher,chercherbutton);
        this.add(chercherContianer);     
        listContainer = new ContainerList();
        listContainer.setScrollableY(false);
        listContainer.setScrollVisible(true);
            ServiceLivraison ms = new ServiceLivraison();
ArrayList<Livraison> allclq = ms.getAllLiv();
        for (Livraison m : allclq){
       //AFFICHER Image
            
 Container c = new Container();
       c.setLayout(BoxLayout.y());
      
       c.add(new SpanLabel("Statut : " + m.getStatut()));
       c.add(new SpanLabel("Date de votre Livraison  : " + m.getDate_liv()));
       
       listContainer.add(c);
       
   
   }
   this.add(listContainer);
   }
     private void addAction() {
     chercherbutton.addActionListener((evt)->{
         Form f= new  chercherClinique(theme,chercher.getText());
         f.show();
     });
     
    
    }
}


    

       
    
      


