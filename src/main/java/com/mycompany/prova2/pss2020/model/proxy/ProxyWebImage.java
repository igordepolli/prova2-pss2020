package com.mycompany.prova2.pss2020.model.proxy;

import com.mycompany.prova2.pss2020.model.IImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ProxyWebImage implements IImage {

    private final RealImage realImage;
    private final String path;

    public ProxyWebImage(String path) throws Exception {
        this.path = path;
        realImage = new RealImage();

        loadFromWeb();
    }

    private void loadFromWeb() throws Exception {
        realImage.setImage(ImageIO.read(new URL(path)));
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
