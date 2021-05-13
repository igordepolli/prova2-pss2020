package com.mycompany.prova2.pss2020.presenter;

import com.mycompany.prova2.pss2020.model.IImage;
import com.mycompany.prova2.pss2020.model.proxy.ProxyLocalImage;
import com.mycompany.prova2.pss2020.model.proxy.ProxyWebImage;
import com.mycompany.prova2.pss2020.view.ImageView;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class ImagePresenter {

    private static ImagePresenter instance = null;
    private final ImageView view;
    private final List<IImage> images;
    private final List<JButton> jButtons;

    private ImagePresenter() throws Exception {
        view = new ImageView();

        images = new ArrayList<>();
        jButtons = new ArrayList<>();

        view.setExtendedState(JFrame.MAXIMIZED_BOTH);
        view.setVisible(true);
 
        loadImages();
        loadButtonsInPanel();
        loadPanelAndScrollPane();
        initListeners();
    }

    public static ImagePresenter getInstance() throws Exception {
        if (instance == null) {
            instance = new ImagePresenter();
        }

        return instance;
    }

    private void initListeners() {
        view.getBtnLoadWeb().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    loadImage();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(view, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void setImagesInButtons() throws Exception {
        for (IImage image : images) {

            JButton button = new JButton();
            button.setSize(120, 90);
            image.displayThumbnails(button);

            jButtons.add(button);
        }
    }

    private void loadPanelAndScrollPane() {
        JScrollPane scrollPane = new JScrollPane(view.getPnlImages(),
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );

        scrollPane.setBounds(0, 180, 220, 800);
        view.getPnlImages().setBounds(0, 180, 183, 900);
        view.getPnlImages().setPreferredSize(new Dimension(183, 900));
        view.getContentPane().add(scrollPane);
    }

    private void loadImages() throws Exception {
        images.add(new ProxyLocalImage("Imagem1_10Mb.jpg"));
        images.add(new ProxyLocalImage("Imagem2_10Mb.jpg"));
        images.add(new ProxyLocalImage("Imagem3_10Mb.jpg"));
        images.add(new ProxyLocalImage("Imagem4_10Mb.jpg"));
        images.add(new ProxyLocalImage("Imagem5_10Mb.jpg"));
    }

    private void loadImage() throws Exception {
        String url = JOptionPane.showInputDialog(view, "Digite a URL:");

        if (url != null) {
            images.add(new ProxyWebImage(url));

            cleanPanel();
            loadButtonsInPanel();
        }
    }

    private void createListenersOfButtons() {
        for (int i = 0; i < jButtons.size(); i++) {
            final int index = i;

            jButtons.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    try {
                        images.get(index).display(view.getLblHighResolution());
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(view, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

        }
    }

    private void loadButtonsInPanel() throws Exception {
        setImagesInButtons();
        int location0 = 20;

        for (JButton button : jButtons) {
            button.setLocation(35, location0);
            view.getPnlImages().add(button);
            location0 += 100;
        }

        createListenersOfButtons();
    }

    private void cleanPanel() {
        view.getPnlImages().removeAll();
        view.getPnlImages().revalidate();
        view.getPnlImages().repaint();

        jButtons.removeAll(jButtons);
    }

    public ImageView getView() {
        return view;
    }

}
