//

package gui;

import static com.codename1.charts.compat.Paint.Join.MITER;
import com.codename1.components.ImageViewer;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Stroke;
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
    
//    public Prom(Form prev){
//        setTitle("Liste promotions");
//        
//        SpanLabel sp = new SpanLabel();
//        sp.setText("test");
//        sp.setText(PromotionService.getInstance().getAllpromo().toString());
//        
//        getToolbar().addMaterialCommandToLeftBar("Retour",FontImage.MATERIAL_ARROW_BACK, e->prev.showBack());
//    public void addToolBar(Toolbar tb){
//        tb.addMaterialCommandToOverflowMenu("Promotions Liste", FontImage.MATERIAL_HOME, (e)->{
//
//            Prom ev = new Prom(); 
//            ev.getForm().show();
//        });
//
//    }
//     public Form getForm(){
//        return form;
//    } 
//
//
//public void setForm(){    
//        form.setTitle("Promotions");
//        form.setLayout(new BorderLayout());
//        form.setScrollable(false);
//        tb = form.getToolbar();
//        addToolBar(tb);
//        evenements = new Container(BoxLayout.y());
//    }
    
    
    Form current;
    
    public Art (Resources res) {
        instance=this;
//        super(BoxLayout.y());
        Toolbar tb = getToolbar();
//		tb.setUIID("Toolbar");
                
           //setTitle("Promotions de Para'dise");             
        
//        setTitle("Liste des promotions");
        
        
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
//        img.getAllStyles().setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FIT);
//			Style s = img.getAllStyles();
//			s.setPaddingUnit(Style.UNIT_TYPE_DIPS);
//			s.setPadding(6, 6, 6, 6);
//        SLvoir.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent o) {
//
//                PromId P_Id = new PromId(res);
//                P_Id.show();  
//                }
//            });
//        for (Article art : list){
//            Container cnta = new Container(BoxLayout.y());
//            Label SLart = new Label(art.getNom());
//            Label SLprix = new Label(Float.toString(art.getPrix()));
//        }
        SLvoir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                        new ArtId(p, instance).show();
            }
        });
        
        
//         Button b = new Button();
//        b.addActionListener(
//            
//                new AfficheDetailsForm(p, instance).show();
//            }
//        });
//Button btnModif = new Button("Modifier");
//            btnModif.addActionListener((evt) -> {
//                EditerConcours passe = new EditerConcours(c.getId());
//                passe.getHi().show();
//            });
        
        
        
        //IMAGE
//        EncodedImage enc = EncodedImage.createFromImage(Image.createImage(200, 100), true);
//        String url = p.getImg();
//        ImageViewer img = new ImageViewer(URLImage.createToStorage(enc, url.substring(url.lastIndexOf("/")+1, url.length()), url,URLImage.RESIZE_SCALE_TO_FILL));
        
//        String url = p.getImg();
//        enc = EncodedImage.create(p.getImg());
//        
//        imgs=URLImage.createToStorage(enc, url.substring(url.lastIndexOf("/")+1), url,URLImage.RESIZE_SCALE_TO_FILL);
//        ImageViewer img = new ImageViewer(imgs);
        
        
        
//        for (Article a : list){
//            
//        }
//        img.getAllStyles().setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FIT);
//        SpanLabel SLnom = new SpanLabel(p.getNompromotion());
//        SpanLabel SLnom = new SpanLabel(p.getNompromotion());
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
            
        
        }
//        sp.setText(PromotionService.getInstance().getAllpromo().toString());
//        add(sp);
//        getToolbar().addMaterialCommandToLeftBar("Retour", FontImage.MATERIAL_ARROW_BACK, e-> res.showBack());
       
    
    }

     @Override
    protected void showOtherForm(Resources res) {
        new Home(res).show();
    }


    
}
