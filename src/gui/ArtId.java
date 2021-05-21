/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.ShareButton;
import com.codename1.components.SpanLabel;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RGBImage;
import com.codename1.ui.Slider;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.ImageIO;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import entite.Article;
import entite.promotion;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author GOOGLE_WAS_MY_IDEA
 */
public class ArtId extends Form{

    public ArtId(Article article,Form previous) {
                Form hi = new Form();

        //Article article = new entite.Article();
        EncodedImage enc = EncodedImage.createFromImage(Image.createImage(800, 800), true);
        String url = article.getImg();
        ImageViewer imgg = new ImageViewer(URLImage.createToStorage(enc, url.substring(url.lastIndexOf("/")+1, url.length()), url,URLImage.RESIZE_FAIL));
        
        
        setTitle(article.getNom()+"     "+article.getPrix()+"DT");
        setLayout(new FlowLayout(CENTER));
        Container c= new Container(BoxLayout.y());
        c.add(imgg);
        System.out.println("nchalah-------"+article.getNom());
        //c.add(new Label(article.getPrix()+"DT"));
        Container cx= new Container(BoxLayout.x());
        cx.add(new Label(article.getNomcat()));
        cx.add(new Label("         Fabricant:"+article.getNomfab()));
        c.add(cx);
        Container cdes= new Container(BoxLayout.x());
        cdes.add(new Label("Description:"));
        c.add(cdes);
        Container cntdes= new Container(BoxLayout.x());
        
        cntdes.add(new SpanLabel(article.getDescription()));
        ShareButton sb = new ShareButton();
        c.add(cntdes);

        
        Slider s = new Slider();
        s.setEditable(true);
        s.setMinValue(0);
        s.setMaxValue(5);
        s.setIncrements(1);
      // s.setProgress(5);
      
      /////////rating///////////
   
    Font fnt = Font.createTrueTypeFont("native:MainLight", "native:MainLight").
            derive(Display.getInstance().convertToPixels(5, true), Font.STYLE_PLAIN);
    Style style = new Style(0xffff33, 0, fnt, (byte)0);
    Image fullStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, style).toImage();
    style.setOpacity(100);
    style.setFgColor(0);
    Image emptyStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, style).toImage();
    initStarRankStyle(s.getSliderEmptySelectedStyle(), emptyStar);
    initStarRankStyle(s.getSliderEmptyUnselectedStyle(), emptyStar);
    initStarRankStyle(s.getSliderFullSelectedStyle(), fullStar);
    initStarRankStyle(s.getSliderFullUnselectedStyle(), fullStar);
    s.setPreferredSize(new Dimension(fullStar.getWidth() * 5, fullStar.getHeight()));
     Button btnE = new Button("Noter");
    // Label l1 = new Label ("Vous pouvez noter cette formation");
      Font mediumBoldSystemFont = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM);
      
     Label l = new Label ("Note");
       l.getUnselectedStyle().setFont(mediumBoldSystemFont);
     s.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                    l.setText(Integer.toString(s.getProgress(evt)));
              
            }

             
        });
          
     
      btnE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //FormationService fs = new FormationService();
                // FormationService.getInstance().AjouterRating(s.getProgress(evt), f);
//              if(  FormationService.getInstance().isRated(1, f)==0)     {

// FormationService.getInstance().AjouterRating(s.getProgress(evt), f,UserService.getCurrentUser().getUser_id());

//System.out.println(f.getFormation_id());

Dialog.show("success", "Notation est Bien ajoutée", new Command("OK"));
               
            } 
      } );
     
     Container cn = new Container(BoxLayout.x());
     cn.add(s);
     cn.add(l);
    cn.add(btnE);
c.add(cn);
/////////////////partager///////////////////////

sb.setText("Partager");
hi.add(sb);

Image screenshot = Image.createImage(hi.getWidth(), hi.getHeight());
//hi.revalidate();
//hi.setVisible(true);
//hi.paintComponent(screenshot.getGraphics(), true);

String imageFile = FileSystemStorage.getInstance().getAppHomePath() + "screenshot.png";
try(OutputStream os = FileSystemStorage.getInstance().openOutputStream(imageFile)) {
    ImageIO.getImageIO().save(screenshot, os, ImageIO.FORMAT_PNG, 1);
} catch(IOException err) {
    Log.e(err);
}
sb.setImageToShare(url, "image/png");
        c.add(hi);
        ///////////////////////////////////////QRCode////////////////
        BitMatrix matrix=null;
        try
      {
        matrix = new QRCodeWriter().encode(article.getNom(), BarcodeFormat.QR_CODE, 400, 400);
        }
        catch (Exception e)
      {
        e.printStackTrace();
      }
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        int[] image = new int[width*height];
        int i=0;
        for (int x = 0; x < width; x++) {
          for (int y = 0; y < height; y++) {
            image[i++] = !matrix.get(x, y) ? 0xffffffff : 0xff000000;
          }
        }
       RGBImage rim= new RGBImage(image, width, height);
       c.add(rim);
        
        
        
        
        
        
//        c.add(p.getArticles().toString());
        
        this.add(c);

        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                previous.showBack();
            }
        });
    }
     public void initStarRankStyle(Style s, Image star) {
    s.setBackgroundType(Style.BACKGROUND_IMAGE_TILE_BOTH);
    s.setBorder(Border.createEmpty());
    s.setBgImage(star);
    s.setBgTransparency(0);
    
}
      
}
