package com.mycompany.prova2.pss2020.presenter;

import com.mycompany.prova2.pss2020.model.ProxyImage;
import com.mycompany.prova2.pss2020.view.ImageView;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class ImagePresenter {

    private static ImagePresenter instance = null;
    private final ImageView view;
    private List<ProxyImage> images;
    private List<JButton> jButtons;

    private ImagePresenter(List<ProxyImage> images) {
        view = new ImageView();
        jButtons = new ArrayList<>();
        this.images = images;

        view.setExtendedState(JFrame.MAXIMIZED_BOTH);
        view.setVisible(true);

        loadButtonsInPanel();
        loadPanelAndScrollPane();
    }

    public static ImagePresenter getInstance(List<ProxyImage> images) {
        if (instance == null) {
            instance = new ImagePresenter(images);
        }

        return instance;
    }

    private void loadImagesAndSetInButtons() {
        for (ProxyImage image : images) {
            ImageIcon img = new ImageIcon(image.getFileName());
            img.setImage(img.getImage().getScaledInstance(100, 70, 1));

            JButton button = new JButton();
            button.setSize(100, 70);
            button.setIcon(img);

            jButtons.add(button);
        }
    }

    private void loadPanelAndScrollPane() {
        JScrollPane scrollPane = new JScrollPane(view.getPnlImages(),
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );

        scrollPane.setBounds(0, 140, 183, 400);
        view.getPnlImages().setBounds(0, 140, 183, 900);
        view.getPnlImages().setPreferredSize(new Dimension(183, 900));
        view.getContentPane().add(scrollPane);
    }

    private void createListenersOfButtons() {
        for (int i = 0; i < jButtons.size(); i++) {
            final int index = i;
            
            jButtons.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    images.get(index).display();
                }
            });
            
        }
    }

    private void loadButtonsInPanel() {
        loadImagesAndSetInButtons();
        int location0 = 20;

        for (JButton button : jButtons) {
            button.setLocation(35, location0);
            view.getPnlImages().add(button, 0);
            location0 += 100;
        }
        
        createListenersOfButtons();
    }

}
