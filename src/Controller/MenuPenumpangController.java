/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import View.MenuPenumpangJFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

/**
 *
 * @author R Λ C H
 */
public class MenuPenumpangController extends MouseAdapter implements ActionListener{
    
    private MenuPenumpangJFrame view;
    private Database db;
    
    public MenuPenumpangController(){
        view = new MenuPenumpangJFrame();
        db = new Database();
        view.addActionListener(this);
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getPesanTiket())){
            new DataTiketController();
            view.setVisible(false);
        }
        else if(source.equals(view.getCekTiket())){
            new CekTiketController();
            view.setVisible(false);
        }
        else if(source.equals(view.getLoginAdmin())){
            new LoginController();
            view.setVisible(false);
        }
    }
}
