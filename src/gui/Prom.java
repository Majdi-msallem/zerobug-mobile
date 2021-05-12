
package gui;

import static com.codename1.charts.compat.Paint.Join.MITER;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Stroke;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.util.Resources;
import entite.promotion;
import static java.util.Collections.list;
import java.util.List;
import service.PromotionService;

public class Prom extends SideMenu{
    private List<promotion> listprom;
    private Form form ;
    private Toolbar tb;
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
    
    public Prom(Resources res) {
        super(BoxLayout.y());
        Toolbar tb = getToolbar();
		tb.setUIID("Toolbar");
        
//        setTitle("Liste des promotions");
        
        
        tb.addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, e-> showOtherForm(res));
//        SpanLabel sp = new SpanLabel();
        List<promotion> list = PromotionService.getInstance().getAllpromo();
        
        for (promotion p : list){
        
        Container cnt1 = new Container(BoxLayout.y());   
        Container cnt2 = new Container(BoxLayout.x());
        
        SpanLabel SLnom = new SpanLabel(p.getNompromotion());
        SpanLabel SLdesc = new SpanLabel(p.getDescription());
        SpanLabel SLrem = new SpanLabel(Integer.toString(p.getRemise())+"%");
        EncodedImage enc = EncodedImage.createFromImage(Image.createImage(100,100), true);
        String url = p.getImg();
        ImageViewer img = new ImageViewer(URLImage.createToStorage(enc, url.substring(url.lastIndexOf("/")+1, url.length()), url));
//        for (Article a : list){
//            
//        }
//        img.getAllStyles().setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FIT);
//        SpanLabel SLnom = new SpanLabel(p.getNompromotion());
//        SpanLabel SLnom = new SpanLabel(p.getNompromotion());
//        cnt1.getStyle().getBgColor(0x99cccc);
        
//        cnt2.getStyle().setBgColor(0x99CCCC);
//        cnt2.getStyle().setBgTransparency(255);
//        Stroke borderStroke = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN MITER, 1);
//        cnt2.getStyle().setBorder(RoundBorder.create(). rectangle(true). color(0xffffff). strokeColor(0). strokeOpacity(50));


        cnt1.add(SLnom);
        cnt1.add(SLdesc);
        cnt1.add(SLrem);
        cnt1.add(img);
        cnt1.add(cnt2);
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
