/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author R Λ C H
 */
public class Database {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    
    private ArrayList<Stasiun> stasiun = new ArrayList<>();
    private ArrayList<Jadwal> jadwal = new ArrayList<>();
    
    public Database(){
        loadJadwal();
        loadStasiun();
    }
    
    public void connect(){
        try {
            String url = "jdbc:mysql://localhost/tikepi";
            String user = "root";
            String pass = "";
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void disconnect(){
        try {
            conn.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean manipulate(String query){
        boolean cek = false;
        try {
            int rows = stmt.executeUpdate(query);
            if (rows > 0) cek = true;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cek;
    }
    
    public void loadJadwal() {
        connect();
        try {
            String query = "SELECT * FROM jadwal WHERE tgl_berangkat >= NOW()";
            rs = stmt.executeQuery(query);
            while (rs.next()){
                jadwal.add(new Jadwal(rs.getString("kode_jadwal"), 
                                      rs.getString("id_kereta"),
                                      rs.getString("stasiun_asal"), 
                                      rs.getString("stasiun_tujuan"), 
                                      rs.getString("tgl_berangkat"),
                                      rs.getString("jam_berangkat"), 
                                      rs.getString("jam_tiba")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
    }
    
    public ArrayList<Jadwal> getJadwal() {
        return jadwal;
    }
    
    public void loadJadwalSearch(String tglBerangkat, String stasiunAsal, String stasiunTujuan){
        connect();
        jadwal.clear();
        try {
            String query = "SELECT * FROM jadwal WHERE tgl_berangkat = '" + tglBerangkat + "' "
                                              + "AND stasiun_asal = '" + stasiunAsal + "' "
                                              + "AND stasiun_tujuan = '" + stasiunTujuan + "'";
            
            rs = stmt.executeQuery(query);
            while (rs.next()){
                jadwal.add(new Jadwal(rs.getString("kode_jadwal"), 
                                      rs.getString("id_kereta"),
                                      rs.getString("stasiun_asal"), 
                                      rs.getString("stasiun_tujuan"), 
                                      rs.getString("tgl_berangkat"),
                                      rs.getString("jam_berangkat"), 
                                      rs.getString("jam_tiba")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
    }
    
    public ArrayList<Jadwal> getJadwalSearch() {
        return jadwal;
    }
    
    public void loadStasiun() {
        connect();
        try {
            String query = "SELECT * FROM stasiun";
            rs = stmt.executeQuery(query);
            while (rs.next()){
                stasiun.add(new Stasiun(rs.getString("kode_stasiun"), 
                                       rs.getString("nama_stasiun"),
                                       rs.getString("alamat_stasiun"), 
                                       rs.getString("kelas_stasiun"), 
                                       rs.getString("daerah_operasi")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
    }
    
    public ArrayList<Stasiun> getStasiun() {
        return stasiun;
    }
    
    public String GetNamaKereta(String idKereta){
        connect();
        try {
            String query = "SELECT nama_kereta FROM kereta WHERE id_kereta = '" + idKereta + "'";
            rs = stmt.executeQuery(query);
            if(rs.next()){
                return rs.getString("nama_kereta");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
        return null;
    }
    
    public String GetIDKeretaFromKodeJadwal(String kodeJadwal){
        connect();
        try {
            String query = "SELECT id_kereta FROM jadwal WHERE kode_jadwal = '" + kodeJadwal + "'";
            rs = stmt.executeQuery(query);
            if(rs.next()){
                return rs.getString("id_kereta");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
        return null;
    }
    
    public String GetKodeStasiun(String namaStasiun){
        connect();
        try {
            String query = "SELECT kode_stasiun FROM stasiun WHERE nama_stasiun = '" + namaStasiun + "'";
            rs = stmt.executeQuery(query);
            if(rs.next()){
                return rs.getString("kode_stasiun");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
        return null;
    }
    
    public int GetHarga(String idKereta){
       int harga;
       connect();
        try {
            String query = "SELECT kelas FROM kereta WHERE id_kereta = '" + idKereta + "'";
            rs = stmt.executeQuery(query);
            if(rs.next()){
                if(rs.getString("kelas").equals("Eksekutif")){
                    return 300000;
                }
                else if(rs.getString("kelas").equals("Bisnis")){
                    return 180000;
                }
                else{
                    return 100000;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
        return 0;
    }
    
    
}
