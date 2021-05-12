package com.mycompany.prova2.pss2020.presenter;

import com.mycompany.prova2.pss2020.model.ProxyImage;
import com.mycompany.prova2.pss2020.view.ImageView;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImagePresenter {

    private static ImagePresenter instance = null;
    private final ImageView view;
    private List<ProxyImage> images;
    private List<JLabel> jLabels;

    private ImagePresenter(List<ProxyImage> images) {
        view = new ImageView();
        this.images = images;

        view.setLocationRelativeTo(null);
        view.setVisible(true);
        loadImages();
    }
    
    public static ImagePresenter getInstance(List<ProxyImage> images) {
        if (instance == null) {
            instance = new ImagePresenter(images);
        }
        
        return instance;
    }

    private void loadImages() {
        for (ProxyImage image : images) {
            ImageIcon img = new ImageIcon(image.getFileName());
            img.setImage(img.getImage().getScaledInstance(100, 100, 1));
            
            JLabel jLabel = new JLabel();
            jLabel.setSize(100, 100);
            jLabel.setIcon(img);
            
            view.getSplImages().add(jLabel, 0);
        }
    }
    
    private void loadImageFullResolution() {
        ImageIcon img = new ImageIcon(images.get(0).getFileName());
        view.getLblHighResolution().setIcon(img);
    }
}
