/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.DataTiketController.baru;
import Model.Database;
import Model.Gerbong;
import Model.Kursi;
import Model.Penumpang;
import Model.Stasiun;
import Model.Tiket;
import View.DataTiketJFrame;
import View.MenuPenumpangJFrame;
import View.PilihKursiJFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author R Λ C H
 */
public class PilihKursiController extends MouseAdapter implements ActionListener{
    
    private PilihKursiJFrame view;
    private Database db;
    private static ArrayList<String> id_gerbong = new ArrayList<>();
    
    public PilihKursiController(){
        view = new PilihKursiJFrame();
        db = new Database();
        view.addActionListener(this);
        view.setVisible(true);
        loadGerbong();
    }
    
    public void loadGerbong(){
        System.out.println(baru.getIdKereta());
        db.loadGerbongByIDKereta(baru.getIdKereta());
        ArrayList<Gerbong> gerbong = db.getGerbongByIDKereta();
        for(Gerbong g : gerbong){
            id_gerbong.add(g.getIdGerbong());
            view.setGerbong(String.valueOf(g.getNoGerbong()));
        }
    }
    
    public void loadBarisKolom(){
        String idGerbong = view.getGerbong();
        db.loadBarisKolom(idGerbong);
        ArrayList<Kursi> kursi = db.getBarisKolom();
        for(Kursi k : kursi){
            view.setBaris(k.getBarisKursi());
            view.setKolom(k.getKolomKursi());
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(view.getBtnRefresh())){
            view.setKolomEnable(true);
            view.setBarisEnable(true);
            int index = view.getIndexGerbong();
            System.out.println(id_gerbong.get(index));
            db.loadBarisKolom(id_gerbong.get(index));
            ArrayList<Kursi> kursi = db.getBarisKolom();
            
            for (Kursi k : kursi){
                int statusK = 0;
                int statusB = 0;
                for(int i = 0; i < view.getKolomCount(); i++){
                    if(view.getKolomValue(i).equals(k.getKolomKursi())){
                        statusK = 1;
                        break;
                    }
                }
                if(statusK == 0){
                    view.setKolom(k.getKolomKursi());  
                }
                
                for(int i = 0; i < view.getBarisCount(); i++){
                    if(view.getBarisValue(i).equals(k.getBarisKursi())){
                        statusB = 1;
                        break;
                    }
                }
                if(statusB == 0){
                    view.setBaris(k.getBarisKursi());
                }
            }
        }
        else if(source.equals(view.getBtnCek())){
            int index = view.getIndexGerbong();
            JOptionPane.showMessageDialog(view, 
                    "Kursi pada kolom " + view.getKolomValue() + 
                    " baris " + view.getBarisValue() +
                    " " + db.cekStatusKursi(id_gerbong.get(index), Integer.parseInt(view.getKolomValue()), Integer.parseInt(view.getBarisValue())));
        }
        else if(source.equals(view.getBtnPesan())){
            String nomorID = view.getNomorID();
            String jenisID = view.getJenisID();
            String nama = view.getNamaPenumpang();
            String JK = view.getJK();
            String tglLahir = view.getTglLahir();
            String noHP = view.getNoHP();
            String email = view.getEmail();
            String alamat = view.getAlamat();
            
            String kodeTiket = "TIX";
            int length = String.valueOf(Tiket.serialKodeTiket).length();
            if(length == 1){
                kodeTiket += "00" + ++Tiket.serialKodeTiket;
            }
            else if(length == 2){
                kodeTiket += "0" + ++Tiket.serialKodeTiket;
            }
            else{
                kodeTiket += ++Tiket.serialKodeTiket;;
            }
            
            String idGerbong = "GK";
            if(view.getGerbong().length() == 1){
                idGerbong += "00" + view.getGerbong();
            }
            else if(view.getGerbong().length() == 2){
                idGerbong += "0" + view.getGerbong();
            }
            else{
                idGerbong += view.getGerbong();
            }
            
            baru.setKodeTiket(kodeTiket);
            baru.setIdPenumpang(nomorID);
            baru.setIdKursi(db.GetIDKursi(idGerbong, Integer.parseInt(view.getKolomValue()), Integer.parseInt(view.getBarisValue())));
            
            db.addPenumpang(new Penumpang(nomorID, jenisID, nama, JK, tglLahir, noHP, email, alamat));
            db.addTiket(baru);
            JOptionPane.showMessageDialog(view, "Data tiket sukses diinput.");
        }
    }
}
