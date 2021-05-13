package com.mycompany.prova2.pss2020.model.proxy;

import com.mycompany.prova2.pss2020.model.IImage;
import java.awt.Image;
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
        ImageIcon imageIcon = new ImageIcon(image);
        Image img = imageIcon.getImage();
        Image newImg = img.getScaledInstance(jLabel.getWidth(), jLabel.getHeight(), Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newImg);

        jLabel.setIcon(imageIcon);
    }

    @Override
    public void displayThumbnails(JButton jButton) throws Exception {
        ImageIcon imageIcon = new ImageIcon(image);
        Image img = imageIcon.getImage();
        Image newImg = img.getScaledInstance(jButton.getWidth(), jButton.getHeight(), Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newImg);

        jButton.setIcon(imageIcon);
    }

    protected void setImage(BufferedImage image) {
        this.image = image;
    }

}
