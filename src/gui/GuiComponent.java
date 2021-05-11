package gui;

import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.util.Resources;


public class GuiComponent extends Form  {
    public GuiComponent(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Grid_Layout = new com.codename1.ui.Container(new com.codename1.ui.layouts.GridLayout(1, 3));
    protected com.codename1.ui.Button gui_Button = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_Button_3 = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_Button_4 = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(false);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("GuiComponent");
        setName("GuiComponent");
        gui_Grid_Layout.setPreferredSizeStr("86.1558mm 73.03133mm");
                gui_Grid_Layout.setInlineStylesTheme(resourceObjectInstance);
        gui_Grid_Layout.setName("Grid_Layout");
        addComponent(gui_Grid_Layout);
        gui_Button.setText("iOS");
                gui_Button.setInlineStylesTheme(resourceObjectInstance);
        gui_Button.setName("Button");
        gui_Button_1.setText("Android");
                gui_Button_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Button_1.setName("Button_1");
        gui_Button_2.setText("Windows");
                gui_Button_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Button_2.setName("Button_2");
        gui_Button_3.setText("Linux");
                gui_Button_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Button_3.setName("Button_3");
        gui_Button_4.setText("Mac");
                gui_Button_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Button_4.setName("Button_4");
        gui_Grid_Layout.addComponent(gui_Button);
        gui_Grid_Layout.addComponent(gui_Button_1);
        gui_Grid_Layout.addComponent(gui_Button_2);
        gui_Grid_Layout.addComponent(gui_Button_3);
        gui_Grid_Layout.addComponent(gui_Button_4);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Grid_Layout.getParent().getLayout()).setInsets(gui_Grid_Layout, "33.162613% auto auto 35.728348%").setReferenceComponents(gui_Grid_Layout, "-1 -1 -1 -1").setReferencePositions(gui_Grid_Layout, "0.0 0.0 0.0 0.0");
    }// </editor-fold>
//-- DON'T EDIT ABOVE THIS LINE!!!
}
