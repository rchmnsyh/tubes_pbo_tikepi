/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import Model.Petugas;
import View.LoginJFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author R Λ C H
 */
public class LoginController extends MouseAdapter implements ActionListener{
    private LoginJFrame view;
    private Database db;
    
    public LoginController() {
        view = new LoginJFrame();
        db = new Database();
        view.addActionListener(this);
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(view.getLogin())){
            boolean login = false;
            String username = view.getTfUsername();
            String password = view.getTfPassword();
            if(username.equals("admin") && password.equals("hiyahiyahiya")){
                new AdminController();
                view.setVisible(false);
                login = true;
            }
            else{
                if(db.cekAkun(username, password)){
                    new PetugasController(username);
                    view.setVisible(false);
                    login = true;
                }
            }
            if(!login){
                JOptionPane.showMessageDialog(view, "Username atau password salah!");
            }
        }
    }
}
