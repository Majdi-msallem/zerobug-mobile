//

package gui;

import static com.codename1.charts.compat.Paint.Join.MITER;
import com.codename1.components.ImageViewer;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Stroke;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.util.Resources;
import entite.promotion;
import entite.Article;
import static java.util.Collections.list;
import java.util.List;
import service.ArticleService;
import service.PromotionService;

public class Art extends SideMenu{
    Art instance;
    //private List<promotion> listprom;
     private List<Article> listart;
     EncodedImage enc;
    private Form form ;
//    private Toolbar tb;
    private Container evenements;
    Form current;
    
    public Art (Resources res) {
        instance=this;
//        super(BoxLayout.y());
        Toolbar tb = getToolbar();
//		tb.setUIID("Toolbar");
        tb.addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, e-> showOtherForm(res));
//        SpanLabel sp = new SpanLabel();
        List<Article> list = ArticleService.getInstance().getAllArt();

       
        for (Article p : list){
            
        setLayout(new FlowLayout(CENTER));
        Container cnt1 = new Container(BoxLayout.y());   
        Container cnt2 = new Container(BoxLayout.x());
        //ontainer cnt = new Container();
//            System.out.println("alllooo------"+article.getNom());
        Label SLnom = new Label(p.getNom());
//        SpanLabel SLdesc = new SpanLabel(p.getDescription());
        Label SLrem = new Label(p.getPrix()+"DT");
        Button SLvoir = new Button("Voir article");
        EncodedImage enc = EncodedImage.createFromImage(Image.createImage(500, 500), true);
        String url = p.getImg();
        ImageViewer img = new ImageViewer(URLImage.createToStorage(enc, url.substring(url.lastIndexOf("/")+1, url.length()), url,URLImage.RESIZE_SCALE_TO_FILL));
        SLvoir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                        new ArtId(p, instance).show();
            }
        });
//        cnt1.getStyle().getBgColor(0x99cccc);
        
        //cnt2.getStyle().setBgColor(0x99CCCC);
        //cnt2.getStyle().setBgTransparency(255);
        //Stroke borderStroke = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);
//        cnt2.getStyle().setBorder(RoundBorder.create(). rectangle(true). color(0xffffff). strokeColor(0). strokeOpacity(10));


        cnt2.add(SLnom);
//        cnt1.add(SLdesc);
        cnt2.add(SLrem);
        cnt1.add(cnt2);
        cnt1.add(img);
        cnt1.add(SLvoir);
        
        
//        for (Article a : lista){
//         SpanLabel SLnomA = new SpanLabel(a.getNom());   
//         cnt1.add(SLnomA);
//        }
        
        
        add(cnt1);
        //search tbadel 3onwen tool bar
//prepare field
TextField searchField;
searchField = new TextField("", "rechercher...");
//searchField.getHintLabel().setUIID("Title");
//searchField.setUIID("Title");
//tb.setGlobalToolbar(true);
tb.setTitleComponent(searchField);
//if field content changed
searchField.addDataChangeListener((i1, i2) -> {
String t = searchField.getText();
if(t.length() < 1) {
for(Component cmp : getContentPane()) {
cmp.setHidden(false);
cmp.setVisible(true);
}
} else {
t = t.toLowerCase();
for(Component cmp: getContentPane()) {
//tekhou el val ta3 el champ : champ li 3malt 3lih el recherche type span label (emplacement : container->container->spanlabel )
String val = ((Label) ((Container)((Container) cmp).getComponentAt(0)).getComponentAt(0)).getText();
System.out.println( val );
boolean show = val != null && val.toLowerCase().indexOf(t) > -1;
cmp.setHidden(!show);
cmp.setVisible(show);
}
}
getContentPane().animateLayout(250);
});
            
        
        }  
    }

     @Override
    protected void showOtherForm(Resources res) {
        new Home(res).show();
    }


    
}
