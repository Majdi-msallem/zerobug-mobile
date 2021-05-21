/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import java.util.List;
import com.mycompany.gui.entities.Article;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Hamza
 */
public class serviceArticle {
     public ArrayList<Article>Article;
    public static serviceArticle instance=null;
    private ConnectionRequest req;
    public boolean resultOK;
    ArrayList<String> domaines;
    
    public static serviceArticle getInstance(){
        if(instance==null)
            instance=new serviceArticle();
        return instance;
    }

    public serviceArticle() {
        req=new ConnectionRequest();
    }
 
    
}
