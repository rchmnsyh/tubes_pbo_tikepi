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
    
    private ArrayList<Tiket> tiket = new ArrayList<>();
    
    public Database(){
        loadJadwal();
        loadStasiun();
        loadGerbong();
        loadKereta();
        loadKursi();
        loadPetugas();
        loadTiket();
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
    
    public void loadTiket() {
        connect();
        try {
            String query = "SELECT * FROM tiket WHERE id_petugas = 'PTGS0000'";
            rs = stmt.executeQuery(query);
            while (rs.next()){
                tiket.add(new Tiket(rs.getString("kode_tiket"), 
                                    rs.getString("id_penumpang"),
                                    rs.getString("kode_jadwal"), 
                                    rs.getString("tgl_pesan"),
                                    rs.getString("id_kursi"),
                                    rs.getString("id_kereta"),
                                    rs.getString("harga")));
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
    
    public ArrayList<Tiket> getTiket(){
        return tiket;
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
    
    public String GetNamaPenumpang(String idPenumpang){
        connect();
        try {
            String query = "SELECT nama FROM penumpang WHERE id_penumpang = '" + idPenumpang + "'";
            rs = stmt.executeQuery(query);
            if(rs.next()){
                return rs.getString("nama");
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
    
    public boolean updateTiket(String kodeTiket, String idPetugas){
        connect();
        String query = "UPDATE tiket SET";
        query += " id_petugas = '" + idPetugas + "'";
        query += " WHERE kode_tiket = '" + kodeTiket + "'";
        if (manipulate(query)){
            disconnect();
            return true;
        }
        else{
            disconnect();
            return false;
        } 
    }
    
    public Tiket cekTiket(String kodeTiket){
       connect();
        try {
            String query = "SELECT * FROM tiket WHERE kode_tiket = '" + kodeTiket + "'";
            rs = stmt.executeQuery(query);
            if(rs.next()){
                return new Tiket(rs.getString("kode_tiket"), 
                                 rs.getString("id_penumpang"), 
                                 rs.getString("kode_jadwal"), 
                                 rs.getString("tgl_pesan"), 
                                 rs.getString("id_kursi"), 
                                 rs.getString("id_kereta"), 
                                 rs.getString("harga"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
        return null; 
    }
    
    public boolean cekAkun(String username, String password){
       connect();
        try {
            String query = "SELECT * FROM petugas WHERE id_petugas = '" + username + "' AND password = '" + password + "'";
            rs = stmt.executeQuery(query);
            if(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
        return false; 
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
    
    public void addJadwal(Jadwal j) {
        connect();
        String query = "INSERT INTO jadwal VALUES (";
        query += "'" + j.getKodeJadwal() + "',";
        query += "'" + j.getIdKereta() + "',";
        query += "'" + j.getStasiunAsal() + "',";
        query += "'" + j.getStasiunTujuan() + "',";
        query += "'" + j.getTglBerangkat() + "',";
        query += "'" + j.getJamBerangkat() + "',";
        query += "'" + j.getJamTiba() + "'";
        query += ")";
        if (manipulate(query)) jadwal.add(j);
        disconnect();
    }
    
    public void addKereta(Kereta k) {
        connect();
        String query = "INSERT INTO kereta VALUES (";
        query += "'" + k.getIdKereta() + "',";
        query += "'" + k.getNamaKereta() + "',";
        query += "'" + k.getKapasitasKereta() + "',";
        query += "'" + k.getKelasKereta() + "'";
        query += ")";
        if (manipulate(query)) kereta.add(k);
        disconnect();
    }
    
    public void addKursi(Kursi krs){
        connect();
        String query = "INSERT INTO kursi VALUES (";
        query += "'" + krs.getIdKursi() + "',";
        query += "'" + krs.getIdGerbong()+ "',";
        query += "'" + krs.getKolomKursi() + "',";
        query += "'" + krs.getBarisKursi() + "',";
        query += "'" + krs.getStatus()+ "')";
        if (manipulate(query)) kursi.add(krs);
        disconnect();
    }
    
    public void addPetugas(Petugas g) {
        connect();
        String query = "INSERT INTO petugas VALUES (";
        query += "'" + g.getIdPetugas() + "',";
        query += "'" + g.getNama() + "',";
        query += "'" + g.getJenisKelamin() + "',";
        query += "'" + g.getTanggalLahir() + "',";
        query += "'" + g.getNoHp() + "',";
        query += "'" + g.getEmail() + "',";
        query += "'" + g.getAlamat() + "'";
        query += ")";
        if (manipulate(query)) petugas.add(g);
        disconnect();
    }
    
    public void addStasiun(Stasiun g) {
        connect();
        String query = "INSERT INTO stasiun VALUES (";
        query += "'" + g.getKodeStasiun() + "',";
        query += "'" + g.getNamaStasiun() + "',";
        query += "'" + g.getKelasStasiun() + "',";
        query += "'" + g.getAlamatStasiun() + "',";
        query += "'" + g.getDaerahOperasi() + "'";
        query += ")";
        if (manipulate(query)) stasiun.add(g);
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
    
    public void deleteJadwal(Jadwal j){
        connect();
        String query = "DELETE FROM jadwal WHERE kode_Jadwal = '" + j.getKodeJadwal() + "'";
        if (manipulate(query)){
            for(Jadwal j1 : jadwal){
                if (j1.getKodeJadwal().equals(j.getKodeJadwal())){
                    jadwal.remove(j);
                    break;
                }
            }
        }
        disconnect();
    }
    
    public void deleteKereta(Kereta k){
        connect();
        String query = "DELETE FROM kereta WHERE id_kereta = '" + k.getIdKereta() + "'";
        if (manipulate(query)){
            for(Kereta k1 : kereta){
                if (k1.getIdKereta().equals(k.getIdKereta())){
                    jadwal.remove(k);
                    break;
                }
            }
        }
        disconnect();
    }
    
    public void deleteKursi(Kursi krs){
        connect();
        String query = "DELETE FROM kursi WHERE id_kursi = '" + krs.getIdKursi() + "'";
        if (manipulate (query)){
            for(Kursi krs1 : kursi){
                if(krs1.getIdKursi().equals(krs.getIdKursi())){
                    kursi.remove(krs);
                    break;
                }
            }
        }
        disconnect();
    }
    
    public void deletePetugas(Petugas g) {
        connect();
        String query = "DELETE FROM petugas WHERE idPetugas = '" + g.getIdPetugas() + "'";
        if (manipulate(query)){
            for (Petugas g1 : petugas) {
                if (g1.getIdPetugas().equals(g.getIdPetugas())){
                    petugas.remove(g);
                    break;
                }
            }
        }
        disconnect();
    }
    
     public void deleteStasiun(Stasiun g) {
        connect();
        String query = "DELETE FROM stasiun WHERE kode_stasiun = '" + g.getKodeStasiun() + "'";
        if (manipulate(query)){
            for (Stasiun g1 : stasiun) {
                if (g1.getKodeStasiun().equals(g.getKodeStasiun())){
                    stasiun.remove(g);
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
    
    public void updateJadwal(Jadwal j){
        connect();
        String query = "UPDATE jadwal SET";
        query += " kode_jadwal = '" + j.getKodeJadwal() + "',";
        query += " id_kereta = '" + j.getIdKereta() + "',";
        query += " stasiun_asal = '" + j.getStasiunAsal() + "',";
        query += " stasiun_tujuan = '" + j.getStasiunTujuan() + "',";
        query += " tgl_berangkat = '" + j.getTglBerangkat() + "',";
        query += " jam_berangkat = '" + j.getJamBerangkat() + "',";
        query += " jam_tiba = '" + j.getJamTiba() + "'";
        query += "WHERE kode_jadwal = '" + j.getIdKereta() + "'";
        if (manipulate(query)){
            for (Jadwal j1 : jadwal){
                if(j1.getKodeJadwal().equals(j.getKodeJadwal())){
                    j1.setIdKereta(j.getIdKereta());
                    j1.setStasiunAsal(j.getStasiunAsal());
                    j1.setStasiunTujuan(j.getStasiunTujuan());
                    j1.setTglBerangkat(j.getTglBerangkat());
                    j1.setJamBerangkat(j.getJamBerangkat());
                    j1.setJamTiba(j.getJamTiba());
                    break;
                }
            }
            System.out.println("jalan");
        }
        disconnect();
    }
    
    public void updateKereta(Kereta k){
        connect();
        String query = "UPDATE kereta SET";
        query += " id_kereta '" + k.getIdKereta() + "',";
        query += " nama_kereta '" + k.getNamaKereta() + "',";
        query += " kapasitas '" + k.getKapasitasKereta() + "',";
        query += " kelas '" + k.getKelasKereta() + "'";
        query += "WHERE id_kereta = '" + k.getIdKereta() + "'";
        if(manipulate(query)){
            for (Kereta k1 : kereta){
                if(k1.getIdKereta().equals(k.getIdKereta())){
                    k1.setIdKereta(k.getIdKereta());
                    k1.setNamaKereta(k.getNamaKereta());
                    k1.setKapasitasKereta(k.getKapasitasKereta());
                    k1.setKelasKereta(k.getKelasKereta());
                    break;
                }
            }
        }
        disconnect();
    }
    
    public void updateKursi(Kursi krs){
        connect();
        String query = "UPDATE kursi SET";
        query += " id_kursi '" + krs.getIdKursi() + "',";
        query += " id_gerbong '" + krs.getIdGerbong() + "',";
        query += " kolom_kursi '" + krs.getKolomKursi() + "',";
        query += " baris_kursi '" + krs.getBarisKursi() + "'";
        query += " status '" + krs.getStatus() + "'";
        query += "WHERE id_kursi = '" + krs.getIdKursi() + "'";
        if(manipulate(query)){
            for(Kursi krs1 : kursi){
                if(krs1.getIdKursi().equals(krs.getIdKursi())){
                    krs1.setIdKursi(krs.getIdKursi());
                    krs1.setIdGerbong(krs.getIdGerbong());
                    krs1.setKolomKursi(krs.getKolomKursi());
                    krs1.setBarisKursi(krs.getBarisKursi());
                    krs1.setStatus(krs.getStatus());
                    break;
                }
            }
        }
        disconnect();
    }
    
     public void updatePetugas(Petugas g) {
        connect();
        String query = "UPDATE petugas SET";
        query += " id_petugas = '" + g.getIdPetugas() + "',";
        query += " nama = '" + g.getNama() + "',";
        query += " jenis_kelamin = '" + g.getJenisKelamin() + "',";
        query += " tgl_lahir = '" + g.getTanggalLahir() + "',";
        query += " no_hp = '" + g.getNoHp() + "',";
        query += " email = '" + g.getEmail() + "',";
        query += " alamat = '" + g.getAlamat() + "',";
        query += " password = '" + g.getPassword() + "'";
        query += " WHERE id_petugas = '" + g.getIdPetugas() + "'";
        if (manipulate(query)){
            for (Petugas g1 : petugas) {
                if (g1.getIdPetugas().equals(g.getIdPetugas())){
                    g1.setNama(g.getNama());
                    g1.setJenisKelamin(g.getJenisKelamin());
                    g1.setTanggalLahir(g.getTanggalLahir());
                    g1.setNoHp(g.getNoHp());
                    g1.setEmail(g.getEmail());
                    g1.setAlamat(g.getAlamat());
                    g1.setPassword(g.getPassword());
                    break;
                }
            }
        }
        disconnect();
    }
     
     public void updateStasiun(Stasiun g) {
        connect();
        String query = "UPDATE gerbong SET";
        query += " kode_stasiun = '" + g.getKodeStasiun() + "',";
        query += " nama_stasiun = '" + g.getNamaStasiun() + "',";
        query += " kelas_stasiun = '" + g.getKelasStasiun() + "',";
        query += " alamat_stasiun = '" + g.getAlamatStasiun() + "',";
        query += " daerah_operasi = '" + g.getDaerahOperasi() + "'";
        query += " WHERE kode_stasiun = '" + g.getKodeStasiun() + "'";
        if (manipulate(query)){
            for (Stasiun g1 : stasiun) {
                if (g1.getKodeStasiun().equals(g.getKodeStasiun())){
                    g1.setNamaStasiun(g.getNamaStasiun());
                    g1.setKelasStasiun(g.getKelasStasiun());
                    g1.setAlamatStasiun(g.getAlamatStasiun());
                    g1.setDaerahOperasi(g.getDaerahOperasi());
                    break;
                }
            }
        }
        disconnect();
    }
}
