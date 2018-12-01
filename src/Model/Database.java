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
    private ArrayList<Jadwal> jadwalSearch = new ArrayList<>();
    
    private ArrayList<Gerbong> gerbong = new ArrayList<>();
    private ArrayList<Gerbong> gerbongByIDKereta = new ArrayList<>();
    
    private ArrayList<Kereta> kereta = new ArrayList<>();
    private ArrayList<Petugas> petugas = new ArrayList<>();
    private ArrayList<Kursi> kursi = new ArrayList<>();
    
    public Database(){
        loadJadwal();
        loadStasiun();
        loadGerbong();
        loadKereta();
        loadKursi();
        loadPetugas();
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
    
    public void loadGerbong() {
        connect();
        try {
            String query = "SELECT * FROM gerbong";
            rs = stmt.executeQuery(query);
            while (rs.next()){
                gerbong.add(new Gerbong(rs.getString("id_gerbong"), 
                                        rs.getString("id_kereta"),
                                        Integer.parseInt(rs.getString("nomor_gerbong")), 
                                        rs.getString("status"), 
                                        Integer.parseInt(rs.getString("kapasitas"))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
    }
    
    public void loadKereta() {
        connect();
        try {
            String query = "SELECT * FROM kereta";
            rs = stmt.executeQuery(query);
            while (rs.next()){
                kereta.add(new Kereta(rs.getString("id_kereta"), 
                                        rs.getString("nama_kereta"),
                                        rs.getString("kelas"),
                                        Integer.parseInt(rs.getString("kapasitas"))
                                        ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
    }
    
    public void loadKursi() {
        connect();
        try {
            String query = "SELECT * FROM kursi";
            rs = stmt.executeQuery(query);
            while (rs.next()){
                kursi.add(new Kursi(rs.getString("id_kursi"), 
                                    rs.getString("id_gerbong"),
                                    rs.getString("kolom_kursi"), 
                                    rs.getString("baris_kursi"),
                                    rs.getString("status")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
    }
    
    public void loadPetugas() {
        connect();
        try {
            String query = "SELECT * FROM petugas WHERE id_petugas != 'PTGS0000'";
            rs = stmt.executeQuery(query);
            while (rs.next()){
                petugas.add(new Petugas(rs.getString("id_petugas"), 
                                        rs.getString("nama"),
                                        rs.getString("jenis_kelamin"), 
                                        rs.getString("tgl_lahir"),
                                        rs.getString("no_hp"),
                                        rs.getString("email"),
                                        rs.getString("alamat"),
                                        rs.getString("password")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
    }
    
    public ArrayList<Stasiun> getStasiun() {
        return stasiun;
    }

    public ArrayList<Jadwal> getJadwal() {
        return jadwal;
    }

    public ArrayList<Kereta> getKereta() {
        return kereta;
    }

    public ArrayList<Petugas> getPetugas() {
        return petugas;
    }

    public ArrayList<Kursi> getKursi() {
        return kursi;
    }
    
    public ArrayList<Gerbong> getGerbong() {
        return gerbong;
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
                jadwalSearch.add(new Jadwal(rs.getString("kode_jadwal"), 
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
        return jadwalSearch;
    }    

    
    public void loadGerbongByIDKereta(String idKereta) {
        connect();
        try {
            String query = "SELECT * FROM gerbong WHERE id_kereta = '" + idKereta + "'";
            rs = stmt.executeQuery(query);
            while (rs.next()){
                gerbongByIDKereta.add(new Gerbong(rs.getString("id_gerbong"), 
                                        rs.getString("id_kereta"),
                                        Integer.parseInt(rs.getString("nomor_gerbong")), 
                                        rs.getString("status"), 
                                        Integer.parseInt(rs.getString("kapasitas"))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
    }
    
    public ArrayList<Gerbong> getGerbongByIDKereta(){
        return gerbongByIDKereta;
    }
    
    public void loadBarisKolom(String idGerbong) {
        connect();
        try {
            String query = "SELECT * FROM kursi WHERE id_gerbong = '" + idGerbong + "'";
            rs = stmt.executeQuery(query);
            while (rs.next()){
                kursi.add(new Kursi(rs.getString("id_kursi"), 
                                    rs.getString("id_gerbong"),
                                    rs.getString("kolom_kursi"), 
                                    rs.getString("baris_kursi"),
                                    rs.getString("status")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
    }
    
    public ArrayList<Kursi> getBarisKolom() {
        return kursi;
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
    
    public String GetKelasKereta(String idKereta){
        connect();
        try {
            String query = "SELECT kelas FROM kereta WHERE id_kereta = '" + idKereta + "'";
            rs = stmt.executeQuery(query);
            if(rs.next()){
                return rs.getString("kelas");
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
    
    public String GetIDKursi(String idGerbong, int kolomKursi, int barisKursi){
       int harga;
       connect();
        try {
            String query = "SELECT * FROM kursi WHERE id_gerbong = '" + idGerbong + "'"
                                                   + " AND kolom_kursi = '" + kolomKursi + "'"
                                                   + " AND baris_kursi = '" + barisKursi + "'";
            rs = stmt.executeQuery(query);
            if(rs.next()) return rs.getString("id_kursi");
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
        return null;
    }
    
    public String cekStatusKursi(String idGerbong, int kolomKursi, int barisKursi){
       connect();
        try {
            String query = "SELECT * FROM kursi WHERE id_gerbong = '" + idGerbong + "'"
                                                   + " AND kolom_kursi = '" + kolomKursi + "'"
                                                   + " AND baris_kursi = '" + barisKursi + "'";
            rs = stmt.executeQuery(query);
            if(rs.next() && !rs.getString("status").isEmpty()) return rs.getString("status");
            else return "tidak ada";
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
        return null; 
    }
    
    public void addTiket(Tiket t) {
        connect();
        String query = "INSERT INTO tiket VALUES (";
        query += "'" + t.getKodeTiket() + "',";
        query += "'" + t.getIdPenumpang() + "',";
        query += "'PTGS0000',";
        query += "'" + t.getKodeJadwal() + "',";
        query += "'" + t.getIdKursi() + "',";
        query += "'" + t.getIdKereta() + "',";
        query += "'" + t.getTglPesanan() + "',";
        query += "'" + t.getHarga()+ "'";
        query += ")";
        if (manipulate(query)) disconnect();
    }
    
    public void addPenumpang(Penumpang p) {
        connect();
        String query = "INSERT INTO penumpang VALUES (";
        query += "'" + p.getIdPenumpang() + "',";
        query += "'" + p.getJenisID() + "',";
        query += "'" + p.getNama() + "',";
        query += "'" + p.getJenisKelamin() + "',";
        query += "'" + p.getTanggalLahir() + "',";
        query += "'" + p.getNoHp() + "',";
        query += "'" + p.getEmail() + "',";
        query += "'" + p.getAlamat() + "'";
        query += ")";
        if (manipulate(query)) disconnect();
    }
    
    public void addGerbong(Gerbong g) {
        connect();
        String query = "INSERT INTO gerbong VALUES (";
        query += "'" + g.getIdGerbong() + "',";
        query += "'" + g.getIdKereta() + "',";
        query += "'" + g.getNoGerbong() + "',";
        query += "'" + g.getKapasitasGerbong() + "',";
        query += "'" + g.getStatusGerbong() + "'";
        query += ")";
        if (manipulate(query)) gerbong.add(g);
        disconnect();
    }
    
    public void deleteGerbong(Gerbong g) {
        connect();
        String query = "DELETE FROM gerbong WHERE id_gerbong = '" + g.getIdGerbong() + "'";
        if (manipulate(query)){
            for (Gerbong g1 : gerbong) {
                if (g1.getIdGerbong().equals(g.getIdGerbong())){
                    gerbong.remove(g);
                    break;
                }
            }
        }
        disconnect();
    }
    
    public void updateGerbong(Gerbong g) {
        connect();
        String query = "UPDATE gerbong SET";
        query += " id_kereta = '" + g.getIdKereta() + "',";
        query += " nomor_gerbong = '" + g.getNoGerbong() + "',";
        query += " kapasitas = '" + g.getKapasitasGerbong() + "',";
        query += " status = '" + g.getStatusGerbong() + "'";
        query += " WHERE id_gerbong = '" + g.getIdGerbong() + "'";
        if (manipulate(query)){
            for (Gerbong g1 : gerbong) {
                if (g1.getIdGerbong().equals(g.getIdGerbong())){
                    g1.setNoGerbong(g.getNoGerbong());
                    g1.setKapasitasGerbong(g.getKapasitasGerbong());
                    g1.setStatusGerbong(g.getStatusGerbong());
                    break;
                }
            }
        }
        disconnect();
    }
}
