
package gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import entite.promotion;
import java.util.List;
import service.ArticleService;
import service.PromotionService;


public class Article extends Form {
        private List<Article> listArt;
    private Form form ;
    private Toolbar tb;
    private Container evenements;
   
    
    Form current;
    
    public Article(Form previous) {
        current=this;
           setTitle("Liste des articles");
        
        SpanLabel sp = new SpanLabel();
        sp.setText(ArticleService.getInstance().getAllArt().toString());
        add(sp);
        getToolbar().addMaterialCommandToLeftBar("Retour", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
       
    
    }
}
