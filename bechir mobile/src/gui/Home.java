
package gui;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;

//public class Home extends Form {
//    Form Current;
//         public Home(){
//        setTitle("Home");
//        setLayout(BoxLayout.y());
//        Button btnList = new Button("Liste des promotions");
//        Button btnArt = new Button("Liste des articles");
//       btnList.addActionListener(e-> new Prom(Current).show());
//       btnArt.addActionListener(e-> new Article(Current).show());
//        addAll(btnList,btnArt);
//         
//         }

    
public class Home extends SideMenu{

    public Home(Resources res){
            super(BoxLayout.y());
        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
//        Image profilePic = res.getImage("user-picture.png");
        Image mask = res.getImage("round-mask.png");
//        profilePic = profilePic.fill(mask.getWidth(), mask.getHeight());
//        Label profilePicLabel = new Label(profilePic, "ProfilePicTitle");
//        profilePicLabel.setMask(mask.createMask());

        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
        menuButton.addActionListener(e -> getToolbar().openSideMenu());

        Container titleCmp = BoxLayout.encloseY(
                FlowLayout.encloseIn(menuButton),
                BorderLayout.centerAbsolute(
                        BoxLayout.encloseY(
                                new Label("", "Title"),
                                new Label("", "SubTitle")
                        )
                )
        );
        tb.setTitleComponent(titleCmp);
        setupSideMenu(res);
    
//        super(BoxLayout.y());
////        Toolbar tb = getToolbar();
////        tb.setTitleCentered(false);
//////        
//////        
//////
//        Button menuButton = new Button("");
//        menuButton.setUIID("Title");
//        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
//        menuButton.addActionListener(e -> getToolbar().openSideMenu());
////////
//////        Container titleCmp = BoxLayout.encloseY(
//////                FlowLayout.encloseIn(menuButton),
//////                BorderLayout.centerAbsolute(
//////                        BoxLayout.encloseY(
//////                                new Label("", "Title"),
//////                                new Label("", "SubTitle")
//////                        )
//////                )
//////        );
//////        tb.setTitleComponent(titleCmp);
//        setupSideMenu(res);
    }

    @Override
    protected void showOtherForm(Resources res) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
