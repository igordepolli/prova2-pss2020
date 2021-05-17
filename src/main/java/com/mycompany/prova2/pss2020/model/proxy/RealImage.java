package com.mycompany.prova2.pss2020.model.proxy;

import com.mycompany.prova2.pss2020.model.IImage;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

class RealImage implements IImage {

    private BufferedImage image;
    private byte[] imageSize;

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

    private boolean checkIfHasCacheImage(BufferedImage image) throws Exception {
        return image != null && getImageSize(image) == imageSize;
    }

    private byte[] getImageSize(BufferedImage image) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", baos);
        return baos.toByteArray();
    }

    protected void setImage(BufferedImage image) throws Exception {
        if (!checkIfHasCacheImage(image)) {
            this.image = image;
            this.imageSize = getImageSize(image);
        }
    }

}
