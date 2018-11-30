/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import Model.Jadwal;
import Model.Stasiun;
import Model.Tiket;
import View.DataTiketJFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
        DefaultTableModel model = new DefaultTableModel(new String[]{"Kode Jadwal", "Nama Kereta", "Tanggal Berangkat", "Jam Berangkat", "Jam Tiba"}, 0)
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ArrayList<Jadwal> jadwal = db.getJadwal();
        for( Jadwal j : jadwal){
            model.addRow(new Object[]{j.getKodeJadwal(), db.GetNamaKereta(j.getIdKereta()), j.getTglBerangkat(), j.getJamBerangkat(), j.getJamTiba()});
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
    
    public void loadSearch(String tglBerangkat, String stasiunAsal, String stasiunTujuan){
        DefaultTableModel model = new DefaultTableModel(new String[]{"Kode Jadwal", "Nama Kereta", "Tanggal Berangkat", "Jam Berangkat", "Jam Tiba"}, 0)
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        stasiunAsal = db.GetKodeStasiun(stasiunAsal);
        stasiunTujuan = db.GetKodeStasiun(stasiunTujuan);
        db.loadJadwalSearch(tglBerangkat, stasiunAsal, stasiunTujuan);
        ArrayList<Jadwal> jadwal = db.getJadwalSearch();
        for(Jadwal j : jadwal){
            model.addRow(new Object[]{j.getKodeJadwal(), db.GetNamaKereta(j.getIdKereta()), j.getTglBerangkat(), j.getJamBerangkat(), j.getJamTiba()});
        }
        view.setTbJadwal(model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnCari())){
            loadSearch(view.getTglBerangkat(), view.getStasiunAsal(), view.getStasiunTujuan());
        }
        else if(source.equals(view.getBtnLanjut())){
            String kodeJadwal = view.getKodeJadwal();
            String tanggal = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
            String idKereta = db.GetIDKeretaFromKodeJadwal(view.getKodeJadwal());
            int harga = db.GetHarga(db.GetIDKeretaFromKodeJadwal(view.getKodeJadwal()));
            Tiket baru = new Tiket(null, null, kodeJadwal, tanggal, null, idKereta, Integer.toString(harga));
            new PilihKursiController();
            view.setVisible(false);
        }
    }
}
