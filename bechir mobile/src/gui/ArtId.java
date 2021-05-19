/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.components.ImageViewer;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import entite.Article;
import entite.promotion;

/**
 *
 * @author GOOGLE_WAS_MY_IDEA
 */
public class ArtId extends Form{

    public ArtId(Article article,Form previous) {
        //Article article = new entite.Article();
        EncodedImage enc = EncodedImage.createFromImage(Image.createImage(400, 400), true);
        String url = article.getImg();
        ImageViewer img = new ImageViewer(URLImage.createToStorage(enc, url.substring(url.lastIndexOf("/")+1, url.length()), url,URLImage.RESIZE_SCALE_TO_FILL));
        
        setTitle(article.getNom());
        setLayout(new FlowLayout(CENTER));
        Container c= new Container(BoxLayout.y());
        c.add(img);
        System.out.println("nchalah-------"+article.getNom());
        c.add(new Label(article.getNomcat()));
        c.add(new Label(article.getNomfab()));
        c.add(new Label(article.getDescription()));
        
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
