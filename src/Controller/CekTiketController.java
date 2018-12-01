/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import Model.Tiket;
import View.CekTiketJFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

/**
 *
 * @author R Λ C H
 */
public class CekTiketController extends MouseAdapter implements ActionListener{
    private CekTiketJFrame view;
    private Database db;
    
    
    public CekTiketController(){
        view = new CekTiketJFrame();
        db = new Database();
        view.addActionListener(this);
        view.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(view.getBtCek())){
            System.out.println("Belum bisa, di sout aja gak keluar apa-apa :(");
            Tiket t = db.cekTiket(view.getKodeTiket());
            String detail = "ID Penumpang: " + t.getIdPenumpang()
                          + "\nKode Jadwal: " + t.getKodeJadwal()
                          + "\nID Kursi: " + t.getIdKursi()
                          + "\nID Kereta: " + t.getIdKereta()
                          + "\nTanggal Pesan: " + t.getTglPesanan()
                          + "\nHarga: " + t.getHarga();
            view.setDetailTiket(detail);
        }
    }
}
