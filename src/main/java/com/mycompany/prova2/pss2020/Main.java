package com.mycompany.prova2.pss2020;

import com.mycompany.prova2.pss2020.presenter.ImagePresenter;

public class Main {

    public static void main(String[] args) {
        try {
            new ImagePresenter();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
