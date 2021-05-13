package com.mycompany.prova2.pss2020.model.proxy;

import com.mycompany.prova2.pss2020.model.IImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ProxyLocalImage implements IImage {

    private final RealImage realImage;
    private final String fileName;

    public ProxyLocalImage(String fileName) throws Exception {
        this.fileName = fileName;
        realImage = new RealImage();

        loadFromDisk();
    }

    private void loadFromDisk() throws Exception {
        realImage.setImage(ImageIO.read(new File(fileName)));
    }

    @Override
    public void display(JLabel jLabel) throws Exception {
        realImage.display(jLabel);
    }

    @Override
    public void displayThumbnails(JButton jButton) throws Exception {
        realImage.displayThumbnails(jButton);
    }

}
