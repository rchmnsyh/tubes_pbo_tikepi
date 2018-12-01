/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import Model.Gerbong;
import Model.Jadwal;
import Model.Kereta;
import Model.Kursi;
import Model.Petugas;
import Model.Stasiun;
import View.AdminJFrame;
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
public class AdminController extends MouseAdapter implements ActionListener{
    private AdminJFrame view;
    private Database db;
    
    public AdminController() {
        view = new AdminJFrame();
        db = new Database();
        view.addActionListener(this);
        view.addMouseAdapter(this);
        view.setVisible(true);
        loadTableGerbong();
        loadTableJadwal();
        loadTableKereta();
        loadTableKursi();
        loadTablePetugas();
        loadTableStasiun();
        loadComboBox();
    } 
    
    public void loadTableGerbong(){
        //Gerbong
        DefaultTableModel modelGerbong = new DefaultTableModel(new String[]{"ID Gerbong", "ID Kereta", "No. Gerbong", "Kapasitas", "Status"}, 0)
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ArrayList<Gerbong> gerbong = db.getGerbong();
        for( Gerbong g : gerbong){
            modelGerbong.addRow(new Object[]{g.getIdGerbong(), g.getIdKereta(), g.getNoGerbong(), g.getKapasitasGerbong(), g.getStatusGerbong()});
        }
        view.setTbGerbong(modelGerbong);
    }
    
    public void loadTableJadwal(){
        //Jadwal
        DefaultTableModel modelJadwal = new DefaultTableModel(new String[]{"Kode Jadwal", "ID Kereta", "Stasiun Asal", "Stasiun Tujuan", "Tanggal Berangkat", "Jam Berangkat", "Jam Tiba"}, 0)
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ArrayList<Jadwal> jadwal = db.getJadwal();
        for( Jadwal j : jadwal){
            modelJadwal.addRow(new Object[]{j.getKodeJadwal(), j.getIdKereta(), j.getStasiunAsal(), j.getStasiunTujuan(), j.getTglBerangkat(), j.getJamBerangkat(), j.getJamTiba()});
        }
        view.setTbJadwal(modelJadwal);
    } 
    
    public void loadTableKereta(){
        //Kereta
        DefaultTableModel modelKereta = new DefaultTableModel(new String[]{"ID Kereta", "Nama Kereta", "Kapasitas Kereta", "Kelas Kereta"}, 0)
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ArrayList<Kereta> Kereta = db.getKereta();
        for( Kereta k : Kereta){
            modelKereta.addRow(new Object[]{k.getIdKereta(), k.getNamaKereta(), k.getKapasitasKereta(), k.getKelasKereta()});
        }
        view.setTbKereta(modelKereta);
    }
    
    public void loadTableKursi(){
        //Kursi
        DefaultTableModel modelKursi = new DefaultTableModel(new String[]{"ID Kursi", "ID Gerbong", "Kolom Kursi", "Baris Kursi", "Status"}, 0)
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ArrayList<Kursi> Kursi = db.getKursi();
        for( Kursi k : Kursi){
            modelKursi.addRow(new Object[]{k.getIdKursi(), k.getIdGerbong(), k.getKolomKursi(), k.getBarisKursi(), k.getStatus()});
        }
        view.setTbKursi(modelKursi);
    }
    
    public void loadTablePetugas(){
        //Petugas
        DefaultTableModel modelPetugas = new DefaultTableModel(new String[]{"ID Petugas", "Nama", "Jenis Kelamin", "Tanggal Lahir", "No. HP", "Email", "Alamat", "Password"}, 0)
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ArrayList<Petugas> Petugas = db.getPetugas();
        for( Petugas p : Petugas){
            modelPetugas.addRow(new Object[]{p.getIdPetugas(), p.getNama(), p.getJenisKelamin(), p.getTanggalLahir(), p.getNoHp(), p.getEmail(), p.getAlamat(), p.getPassword()});
        }
        view.setTbPetugas(modelPetugas);
    }
    
    public void loadTableStasiun(){
        //Stasiun
        DefaultTableModel modelStasiun = new DefaultTableModel(new String[]{"Kode Stasiun", "Nama Stasiun", "Alamat Stasiun", "Kelas Stasiun", "Daerah Operasi"}, 0)
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ArrayList<Stasiun> Stasiun = db.getStasiun();
        for( Stasiun s : Stasiun){
            modelStasiun.addRow(new Object[]{s.getKodeStasiun(), s.getNamaStasiun(), s.getAlamatStasiun(), s.getKelasStasiun(), s.getDaerahOperasi()});
        }
        view.setTbStasiun(modelStasiun);
    }
    
    public void loadComboBox(){
        ArrayList<Stasiun> stasiun = db.getStasiun();
        for( Stasiun s : stasiun){
            view.setJadwal_stasiunAsal(s.getKodeStasiun());
            view.setJadwal_stasiunTujuan(s.getKodeStasiun());
        }
        
        ArrayList<Kereta> kereta = db.getKereta();
        for( Kereta k : kereta){
            view.setJadwal_idKereta(k.getIdKereta());
            view.setGerbong_idKereta(k.getIdKereta());
        }
        
        ArrayList<Gerbong> gerbong = db.getGerbong();
        for( Gerbong g : gerbong){
            view.setKursi_idGerbong(g.getIdGerbong());
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(view.getGerbong_simpan())){
            String idGerbong = view.getGerbong_idGerbong();
            String idKereta = view.getGerbong_idKereta();
            String noGerbong = view.getGerbong_noGerbong();
            String kapasitas = view.getGerbong_kapasitas();
            String status = view.getStatusGerbong();
            db.addGerbong(new Gerbong(idGerbong, idKereta, Integer.parseInt(noGerbong), status, Integer.parseInt(kapasitas)));
            JOptionPane.showMessageDialog(view, "Data gerbong sukses diinput.");
            loadTableGerbong();
        }
        else if(source.equals(view.getGerbong_hapus())){
            String idGerbong = view.getGerbong_idGerbong();
            db.deleteGerbong(new Gerbong(idGerbong, null, 0, null, 0));
            JOptionPane.showMessageDialog(view, "Data gerbong " + idGerbong + " sukses dihapus.");
            loadTableGerbong();
        }
        else if(source.equals(view.getGerbong_edit())){
            String idGerbong = view.getGerbong_idGerbong();
            String idKereta = view.getGerbong_idKereta();
            String noGerbong = view.getGerbong_noGerbong();
            String kapasitas = view.getGerbong_kapasitas();
            String status = view.getStatusGerbong();
            db.updateGerbong(new Gerbong(idGerbong, idKereta, Integer.parseInt(noGerbong), status, Integer.parseInt(kapasitas)));
            JOptionPane.showMessageDialog(view, "Data gerbong " + idGerbong + " sukses diedit.");
            loadTableGerbong();
        }
        else if(source.equals(view.getGerbong_refresh())){
            loadTableGerbong();
       }
    }
}
