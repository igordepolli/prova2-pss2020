package com.mycompany.prova2.pss2020;

import com.mycompany.prova2.pss2020.model.ProxyImage;
import com.mycompany.prova2.pss2020.presenter.ImagePresenter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        
        List<ProxyImage> images = new ArrayList<>();
        
        images.add(new ProxyImage("Imagem1_10Mb.jpg"));
        images.add(new ProxyImage("Imagem2_10Mb.jpg"));
        images.add(new ProxyImage("Imagem3_10Mb.jpg"));
        images.add(new ProxyImage("Imagem4_10Mb.jpg"));
        images.add(new ProxyImage("Imagem5_10Mb.jpg"));
        images.add(new ProxyImage("Imagem1_10Mb.jpg"));
        images.add(new ProxyImage("Imagem2_10Mb.jpg"));
        images.add(new ProxyImage("Imagem3_10Mb.jpg"));
        images.add(new ProxyImage("Imagem4_10Mb.jpg"));
        images.add(new ProxyImage("Imagem5_10Mb.jpg"));
        
        /*
        images.get(0).display();
        images.get(1).display();
        images.get(0).display();
        images.get(2).display();
        images.get(1).display();
        */
        
        ImagePresenter.getInstance(images);
    }
    
}
