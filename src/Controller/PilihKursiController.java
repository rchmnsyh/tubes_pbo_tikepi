/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import View.DataTiketJFrame;
import View.MenuPenumpangJFrame;
import View.PilihKursiJFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

/**
 *
 * @author R Λ C H
 */
public class PilihKursiController extends MouseAdapter implements ActionListener{
    
    private PilihKursiJFrame view;
    private Database db;
    
    public PilihKursiController(){
        view = new PilihKursiJFrame();
        db = new Database();
        //view.addActionListener(this);
        //view.addMouseAdapter(this);
        view.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
