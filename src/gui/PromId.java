package gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import entite.promotion;
import service.PromotionService;
import entite.Article;

//public class PromId extends SideMenu {
//
//              
//
//  
//   
//
//   
//
//    public PromId(int id,Resources res) {
//      Toolbar tb = getToolbar();
////		tb.setUIID("Toolbar");
//        tb.addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, e-> showOtherForm(res));  
//
//        PromotionService PS = new PromotionService();
//        prom(PS.getID(id));
//        
//    }
//    
//    
//    
//    
//    
//    
//    @Override
//    protected void showOtherForm(Resources res) {
//        new Prom(res).show();
//    }
//
//    private void prom(promotion p) {
//        Container TypeContainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
//        Label nom = new Label("Nom de la promotion");
//        nom.setText(p.getDescription());
//        TypeContainer.add(nom);
//
//        //pour le type du concours
//        Label desc = new Label("Description");
//        desc.setText(p.getDescription());
//        TypeContainer.add(desc);
//        
//
//
//
//    }
//
//
//    }
public class PromId extends Form{

    public PromId(promotion p, Form previous) {
        Article article = new entite.Article();
        EncodedImage enc = EncodedImage.createFromImage(Image.createImage(800, 800), true);
        String url = p.getImg();
        ImageViewer img = new ImageViewer(URLImage.createToStorage(enc, url.substring(url.lastIndexOf("/")+1, url.length()), url,URLImage.RESIZE_SCALE_TO_FILL));
        setTitle(p.getNompromotion());
        setLayout(new FlowLayout(CENTER));
        Container c= new Container(BoxLayout.y());
        System.out.println("nchalah-------"+article.getNom());
        c.add(new Label("Remise="+Integer.toString(p.getRemise())+"%"));
        c.add(img);
//        c.add(p.getArticles().toString());
        
        this.add(c);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                previous.showBack();
            }
        });
    }
    
    
    
}
    
    

