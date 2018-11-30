/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import Model.Jadwal;
import Model.Stasiun;
import View.DataTiketJFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author R Λ C H
 */
public class DataTiketController extends MouseAdapter implements ActionListener{
    private DataTiketJFrame view;
    private Database db;

    public DataTiketController() {
        view = new DataTiketJFrame();
        db = new Database();
        view.addActionListener(this);
        view.addMouseAdapter(this);
        view.setVisible(true);
        loadTable();
        loadComboBox();
    }   
    
    public void loadTable(){
        DefaultTableModel model = new DefaultTableModel(new String[]{"Kode Jadwal", "Nama Kereta", "Jam Berangkat", "Jam Tiba"}, 0);
        ArrayList<Jadwal> jadwal = db.getJadwal();
        for( Jadwal j : jadwal){
            model.addRow(new Object[]{j.getKodeJadwal(), j.getIdKereta(), j.getJamBerangkat(), j.getJamTiba()});
        }
        view.setTbJadwal(model);
    }
    
    public void loadComboBox(){
        ArrayList<Stasiun> stasiun = db.getStasiun();
        for( Stasiun s : stasiun){
            view.setStasiunAsal(s.getNamaStasiun());
            view.setStasiunTujuan(s.getNamaStasiun());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
