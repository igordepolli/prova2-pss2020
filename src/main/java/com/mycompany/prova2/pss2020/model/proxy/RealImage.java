package com.mycompany.prova2.pss2020.model.proxy;

import com.mycompany.prova2.pss2020.model.IImage;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

class RealImage implements IImage {

    private BufferedImage image;

    public RealImage() {
    }
     
    @Override
    public void display(JLabel jLabel) {
        jLabel.setIcon(new ImageIcon(image));
    }
    
    @Override
    public void displayThumbnails(JButton jButton) throws Exception {
        jButton.setIcon(new ImageIcon(image));
    }
    
    protected void setImage(BufferedImage image) {
        this.image = image;
    }
   
}
