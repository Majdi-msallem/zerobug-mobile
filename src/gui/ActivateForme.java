/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.components.FloatingHint;
import com.codename1.components.InfiniteProgress;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import static com.codename1.ui.TextArea.ANY;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.sun.mail.smtp.SMTPSSLTransport;
import com.sun.mail.smtp.SMTPTransport;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import service.ServiceUser;


/**
 *
 * @author majdi
 */
public class ActivateForme extends Form{
    Form current;
    TextField  email;
    
      public ActivateForme (Resources res, Form previous){
          current=this;
          setUIID("LoginForm");
          setTitle("");
          
          
        setLayout(BoxLayout.y());
          
//                        add (new Label("Awsome Thanks!"));
//                        add (  new Label("                        "));
//                        add (new Label("                       "));
//                        add  (new Label("We've sent"));
                     Button renv = new Button("Renouveler Votre mot de passe ? ");
    email = new TextField ("","saisir votre email ",20,TextField .ANY);
   email.setSingleLineTextArea(false);
   
   Button Validate = new Button("Validate");
  Validate.setUIID("LoginButton");
   
      
      
                    add  (new Label("                        ")) ;
                         add(new Label("                       ")) ;
                         add (new Label("                        ")) ;
                         add(new Label("                       ")) ;
Button retlog = new Button("Return to Login? ");
//    retlog.addActionListener((e) -> previous.showBack());
//      renv.setUIID("CenterLink");
//                
      
      
        
        Validate.requestFocus();
        
        Validate.addActionListener(e ->{
            InfiniteProgress ip = new InfiniteProgress ();
            final Dialog ipDialog = ip.showInfiniteBlocking();
              
            //email 
            System.out.println("***"+email.getText());
            sendMail(res);
            Dialog.show ("Mot de pass","mdp envoye.Veuillez verifier votre boite email",new Command ("OK"));
            
          new AddregForm(current).show ();
                   refreshTheme();
        });
          addAll(renv,email,Validate,retlog);
      }
      
      
  
    public void sendMail(Resources res) {
        try {
            
            Properties props = new Properties();
                props.put("mail.transport.protocol", "smtp"); //SMTP protocol
		props.put("mail.smtps.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtps.auth", "true"); //enable authentication
             
            Session session = Session.getInstance(props,null); // aleh 9rahach 5ater mazlna masabinach javax.mail .jar
            
            
            MimeMessage msg = new MimeMessage(session);
            
            msg.setFrom(new InternetAddress("Reintialisation mot de passe <monEmail@domaine.com>"));
            msg.setRecipients(Message.RecipientType.TO, email.getText().toString());
            msg.setSubject("Application nom  : Confirmation du ");
            msg.setSentDate(new Date(System.currentTimeMillis()));
            
           String mp = ServiceUser.getInstance().getPasswordByEmail(email.getText().toString(), res);//mp taw narj3lo
           String txt = "Bienvenue sur AppNom : Tapez ce mot de passe : "+mp+" dans le champs requis et appuiez sur confirmer";
           
           
           msg.setText(txt);
           
          SMTPTransport  st = (SMTPTransport)session.getTransport("smtps") ;
            
          st.connect("smtp.gmail.com",465,"chadi.troudi@esprit.tn","193JMT4487");
           
          st.sendMessage(msg, msg.getAllRecipients());
            
          System.out.println("server response : "+st.getLastServerResponse());
          
        }catch(Exception e ) {
            e.printStackTrace();
        }
    }
    
}

    

      // send Mail


      
//      public void sendMail(Resources res){
//          try {
//              
//              Properties props = new Properties();
//              props.put("mail.transport.protocol", "smtp"); //SMTP protocol
//		props.put("mail.smtps.host", "smtp.gmail.com"); //SMTP Host	
//		props.put("mail.smtps.auth", "true"); //enable authentication
//                
//                Session session = Session.getInstance(props,null) ;
//              
//                MimeMessage msg = new MimeMessage (session);
//                msg.setFrom(new InternetAddress("Reintialisation mot de passe <my_email@myDomain.com>"));
//                msg.setRecipients(Message.RecipientType.TO, email.getText().toString());
//                 msg.setSubject("Paradise :Confirmation du ");
//                 msg.setSentDate(new Date(System.currentTimeMillis()));
//                 
//                  String mp =ServiceUser.getInstance().getPasswordByEmail(email.getText().toString(), res);//
//                  
//                  
//                  
//                  String txt ="Bienvenue sur Paradise^: Tapez ce mot de passe:"+mp+"dans le champs requis  et pui appuiez sur Valider";
//                
//                  msg.setText(txt);
//                  
//                  SMTPTransport st= (SMTPSSLTransport)session.getTransport("smtps");
//                  st.connect("smtp.gmail",465,"para.diseesprit@gmail.com","zerobug2021");
//                  
//                  st.sendMessage(msg, msg.getAllRecipients());
//                  System.out.println("Server response:"+st.getLastServerResponse());
//                  
//          }catch(Exception e){
//              e.printStackTrace();
//          }
//                  
//      }}
