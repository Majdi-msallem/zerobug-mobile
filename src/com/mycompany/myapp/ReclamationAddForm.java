/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.io.Storage;
import com.codename1.social.FacebookConnect;
import com.codename1.social.Login;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.Entities.Reclamation;
import com.mycompany.myapp.Service.ServiceReclamation;

/**
 *
 * @author Houcem
 */
public class ReclamationAddForm extends Form {
    
    private Resources resT;
    
    public ReclamationAddForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public ReclamationAddForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        resourceObjectInstance = UIManager.initNamedTheme("/theme", "Theme");
        initGuiBuilderComponents(resourceObjectInstance);
        
       
        FontImage mat = FontImage.createMaterial(FontImage.MATERIAL_CLOSE, "SigninTitle", 3.5f);
       // getToolbar().addCommandToLeftBar("", mat, e -> new SplashForm().show());
        getContentPane().setUIID("ReclamationForm");
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    private com.codename1.ui.ComponentGroup gui_Component_Group_1 = new com.codename1.ui.ComponentGroup();
    private com.codename1.ui.TextField gui_Text_Field_2 = new com.codename1.ui.TextField("","Type");
    private com.codename1.ui.TextField gui_Text_Field_1 = new com.codename1.ui.TextField("","Description");
    private com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_Button_3 = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_Button_2.addActionListener(callback);
    }

    class EventCallbackClass implements com.codename1.ui.events.ActionListener, com.codename1.ui.events.DataChangedListener {
        private com.codename1.ui.Component cmp;
        public EventCallbackClass(com.codename1.ui.Component cmp) {
            this.cmp = cmp;
        }

        public EventCallbackClass() {
        }

        public void actionPerformed(com.codename1.ui.events.ActionEvent ev) {
            com.codename1.ui.Component sourceComponent = ev.getComponent();
            if(sourceComponent.getParent().getLeadParent() != null) {
                sourceComponent = sourceComponent.getParent().getLeadParent();
            }

            if(sourceComponent == gui_Button_2) {
               // onButton_2ActionEvent(ev);
			             ServiceReclamation rs = new ServiceReclamation();
                                     Reclamation r = new Reclamation(0, gui_Text_Field_2.getText(), gui_Text_Field_1.getText());
			   rs.addReclamation(r);
			   new ReclamationForm().show();
            }
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.BorderLayout());
        setTitle("Ajouter Reclamation");
        setName("AddRecForm");
        addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_1);
        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");
        gui_Container_1.addComponent(gui_Label_1);
        gui_Container_1.addComponent(gui_Component_Group_1);
        gui_Component_Group_1.setName("Component_Group_1");
        
        
        gui_Component_Group_1.addComponent(gui_Text_Field_2);
        gui_Component_Group_1.addComponent(gui_Text_Field_1);
        
        
       
        gui_Text_Field_2.setName("Text_Field_2");
        
        
        
      
        gui_Text_Field_1.setName("Text_Field_1");
        
        
        gui_Container_1.addComponent(gui_Button_2);
        gui_Container_1.addComponent(gui_Button_3);
        gui_Label_1.setUIID("CenterLabel");
        gui_Label_1.setName("Label_1");
        gui_Component_Group_1.setName("Component_Group_1");
        gui_Button_2.setText("Ajouter");
        gui_Button_2.setName("Button_2");
        gui_Button_3.setUIID("CenterLabelSmall");
        gui_Button_3.setName("Button_3");
        addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Button_1);
        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");
        gui_Button_1.setText("Back");
        gui_Button_1.setUIID("CenterLabel");
        gui_Button_1.setName("Button_1");
        
        
        
        gui_Button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                //resT = UIManager.initNamedTheme("/theme", "Theme1");
              new ReclamationForm().show();
              
            }
        });
    }// </editor-fold>

    
    
   
//-- DON'T EDIT ABOVE THIS LINE!!!
    
    

    
}
