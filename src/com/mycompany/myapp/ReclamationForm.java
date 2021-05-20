/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.components.ScaleImageLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;

import com.codename1.messaging.Message;
import com.codename1.ui.Display;
import com.mycompany.myapp.Entities.Reclamation;
import com.mycompany.myapp.Service.ServiceReclamation;
/**
 *
 * @author rania
 */
public class ReclamationForm extends BaseForm {
     public ReclamationForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
     
     ServiceReclamation rs = new ServiceReclamation();

    ReclamationForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
         gui_separator1.setShowEvenIfBlank(true);
        gui_Label_1_1_1.setShowEvenIfBlank(true);
        
        ScaleImageLabel sl = new ScaleImageLabel(resourceObjectInstance.getImage("skate-park.jpg"));
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        gui_imageContainer1.add(BorderLayout.CENTER, sl);
        sl = new ScaleImageLabel(resourceObjectInstance.getImage("bridge.jpg"));
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        gui_imageContainer2.add(BorderLayout.CENTER, sl);
        
        installSidemenu(resourceObjectInstance);
        getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {});
        
        FontImage.setMaterialIcon(gui_LA, FontImage.MATERIAL_LOCATION_ON);
        gui_LA.setIconPosition(BorderLayout.EAST);

        FontImage.setMaterialIcon(gui_newYork, FontImage.MATERIAL_LOCATION_ON);
        gui_newYork.setIconPosition(BorderLayout.EAST);
        
        gui_Text_Area_2.setRows(2);
        gui_Text_Area_2.setColumns(100);
        gui_Text_Area_2.setGrowByContent(false);
        gui_Text_Area_2.setEditable(false);
        gui_Text_Area_1.setRows(2);
        gui_Text_Area_1.setColumns(100);
        gui_Text_Area_1.setGrowByContent(false);
        gui_Text_Area_1.setEditable(false);
    }
    
    
    //-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.components.MultiButton gui_Multi_Button_1 = new com.codename1.components.MultiButton();
    private com.codename1.components.MultiButton gui_LA = new com.codename1.components.MultiButton();
    private com.codename1.ui.Container gui_imageContainer1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.ui.TextArea gui_Text_Area_1 = new com.codename1.ui.TextArea();
    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
    private com.codename1.ui.Label gui_separator1 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_null_1_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.components.MultiButton gui_null_1_1_1 = new com.codename1.components.MultiButton();
    private com.codename1.components.MultiButton gui_newYork = new com.codename1.components.MultiButton();
    private com.codename1.ui.Container gui_imageContainer2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.ui.TextArea gui_Text_Area_2 = new com.codename1.ui.TextArea();
    private com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
    private com.codename1.ui.Label gui_Label_1_1_1 = new com.codename1.ui.Label();
   private com.codename1.ui.Button gui_Button_b = new com.codename1.ui.Button(); 

// <editor-fold defaultstate="collapsed" desc="Generated Code">  

  private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
       setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));

 
    getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Reclamation", "Title")
                )
        );
        
        for(Reclamation r : rs.getAllReclamations()){
              com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
             com.codename1.components.MultiButton gui_Multi_Button_1 = new com.codename1.components.MultiButton();
            com.codename1.components.MultiButton gui_LA = new com.codename1.components.MultiButton();
     com.codename1.ui.Container gui_imageContainer1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
     com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    com.codename1.ui.TextArea gui_Text_Area_1 = new com.codename1.ui.TextArea();
    com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
     com.codename1.ui.Label gui_separator1 = new com.codename1.ui.Label();
     com.codename1.ui.Container gui_null_1_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
     com.codename1.components.MultiButton gui_null_1_1_1 = new com.codename1.components.MultiButton();
     com.codename1.components.MultiButton gui_newYork = new com.codename1.components.MultiButton();
     com.codename1.ui.Container gui_imageContainer2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
     com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    com.codename1.ui.TextArea gui_Text_Area_2 = new com.codename1.ui.TextArea();
     com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
     com.codename1.ui.Label gui_Label_1_1_1 = new com.codename1.ui.Label();
     


            
         addComponent(gui_Container_1);
        gui_Container_1.setName("Container_1");
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Multi_Button_1);
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_LA);
        gui_Multi_Button_1.setUIID("Label");
        gui_Multi_Button_1.setName("Multi_Button_1");
       
        gui_Multi_Button_1.setPropertyValue("line1", "Type");
        gui_Multi_Button_1.setPropertyValue("line2", "Description");
        gui_Multi_Button_1.setPropertyValue("uiid1", "Label");
        gui_Multi_Button_1.setPropertyValue("uiid2", "RedLabel");
        gui_LA.setUIID("Label");
        gui_LA.setName("LA");
        gui_LA.setPropertyValue("line1", r.getType());
        gui_LA.setPropertyValue("line2",r.getDescription()+"");
        gui_LA.setPropertyValue("uiid1", "SlightlySmallerFontLabel");
        gui_LA.setPropertyValue("uiid2", "RedLabelRight");
        addComponent(gui_imageContainer1);
        gui_imageContainer1.setName("imageContainer1");
        gui_imageContainer1.addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Container_2);
        gui_Container_2.setName("Container_2");
        gui_Container_2.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Text_Area_1);
        gui_Container_2.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_Button_1);
        gui_Text_Area_1.setUIID("SlightlySmallerFontLabelLeft");
        gui_Text_Area_1.setName("Text_Area_1");
        gui_Button_1.setText("");
        gui_Button_1.setUIID("Label");
        gui_Button_1.setName("Button_1");
        gui_Button_1.addActionListener(e->{
            Dialog dig=new Dialog("Suppression");
            if(dig.show("Suppression","êtes vous sûr de supprimer cette Reclamation?","Annuler","oui")){
                dig.dispose();
            }else{
                dig.dispose();
                if(rs.deleteReclamation(r.getId())){
                    new ReclamationForm(resourceObjectInstance).show(); 
                }
            }
            
           
          
        });
         
        com.codename1.ui.FontImage.setMaterialIcon(gui_Button_1,com.codename1.ui.FontImage.MATERIAL_DELETE);
        
      
        }
       Button vider = new Button("Ajouter Reclamation");
        addStringValue("", vider); 
      vider.addActionListener(e->{
		  new ReclamationAddForm(resourceObjectInstance).show();
      });
       Button checkout = new Button("Send Via Email");
        addStringValue("", checkout); 
      checkout.addActionListener(e->{
		   Message m = new Message("Reclamation");
			Display.getInstance().sendMessage(new String[] {"admin@gamil.com"}, "Reclamation", m);
      });
      
  }
 private void addStringValue(String s, Component v) {
        add(BorderLayout.west(new Label(s, "PaddedLabel")).
                add(BorderLayout.CENTER, v));
        
    }
  
   /*   @Override
    protected boolean isCurrentPanier() {
        return true;
    }*/
}
