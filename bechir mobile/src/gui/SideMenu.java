/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.util.Resources;



public abstract class SideMenu extends Form {
    public SideMenu(String title, Layout contentPaneLayout) {
        super(title, contentPaneLayout);
    }

    public SideMenu(String title) {
        super(title);
    }

    public SideMenu() {
    }

    public SideMenu(Layout contentPaneLayout) {
        super(contentPaneLayout);
    }

    public void setupSideMenu(Resources res) {
//        Container cnt1 = new Container(BoxLayout.y());
//        SpanLabel test = new SpanLabel("TEST");
//        cnt1.add(test);
//        Container sidemenuTop = BorderLayout.center(cnt1);
//        sidemenuTop.setUIID("SidemenuTop");

//        getToolbar().addComponentToSideMenu(sidemenuTop);
            getToolbar().addCommandToSideMenu("Promotion", null, e -> new Prom(res).show());
            getToolbar().addCommandToSideMenu("Article", null, e -> new Art(res).show());
            getToolbar().addCommandToSideMenu("Livraison ", null, e -> new ListLiv(res).show());

        }
        

    protected abstract void showOtherForm(Resources res);
}
