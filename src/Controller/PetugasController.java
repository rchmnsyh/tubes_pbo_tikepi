/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import Model.Tiket;
import View.PetugasJFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author R Λ C H
 */
public class PetugasController extends MouseAdapter implements ActionListener{
    String username;
    private PetugasJFrame view;
    private Database db;
    
    public PetugasController(String username){
        this.username = username;
        view = new PetugasJFrame();
        db = new Database();
        view.addActionListener(this);
        view.addMouseAdapter(this);
        view.setVisible(true);
        loadTable();
    }
    
    public void loadTable(){
        DefaultTableModel model = new DefaultTableModel(new String[]{"Kode Tiket", "Nama Penumpang", "Nama Kereta", "Tanggal Pesan"}, 0)
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ArrayList<Tiket> tiket = db.getTiket();
        System.out.println(tiket.size());
        for( Tiket t : tiket){
            System.out.println(t.getKodeTiket());
            System.out.println(db.GetNamaPenumpang(t.getIdPenumpang()));
            System.out.println(db.GetNamaKereta(t.getIdKereta()));
            System.out.println(t.getTglPesanan());
            model.addRow(new Object[]{t.getKodeTiket(), db.GetNamaPenumpang(t.getIdPenumpang()), db.GetNamaKereta(t.getIdKereta()), t.getTglPesanan()});
        }
        view.setTbTiket(model);
        loadTable();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(view.getBtVerifikasi())){
            if(db.updateTiket(view.getKodeTiket(), username)) JOptionPane.showMessageDialog(view, "Tiket telah diverifikasi");
        }
    }
}
