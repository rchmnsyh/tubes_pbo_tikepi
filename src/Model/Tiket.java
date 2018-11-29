/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author R Λ C H
 */
public class Tiket {
    private String kodeTiket;
    private String idPetugas;
    private String idPenumpang;
    private String kodeJadwal;
    private String tglPesanan;
    private String tglBerangkat;
    private String idKursi;
    private String idKereta;
    private String harga;

    public Tiket(String kodeTiket, String idPenumpang, String kodeJadwal, String tglPesanan, String idKursi, String idKereta, String harga) {
        this.kodeTiket = kodeTiket;
        this.idPenumpang = idPenumpang;
        this.kodeJadwal = kodeJadwal;
        this.tglPesanan = tglPesanan;
        this.idKursi = idKursi;
        this.idKereta = idKereta;
        this.harga = harga;
    }

    public String getKodeTiket() {
        return kodeTiket;
    }

    public void setKodeTiket(String kodeTiket) {
        this.kodeTiket = kodeTiket;
    }
    
    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getIdPetugas() {
        return idPetugas;
    }

    public void setIdPetugas(String idPetugas) {
        this.idPetugas = idPetugas;
    }

    public String getIdPenumpang() {
        return idPenumpang;
    }

    public void setIdPenumpang(String idPenumpang) {
        this.idPenumpang = idPenumpang;
    }

    public String getKodeJadwal() {
        return kodeJadwal;
    }

    public void setKodeJadwal(String kodeJadwal) {
        this.kodeJadwal = kodeJadwal;
    }

    public String getTglPesanan() {
        return tglPesanan;
    }

    public void setTglPesanan(String tglPesanan) {
        this.tglPesanan = tglPesanan;
    }

    public String getIdKursi() {
        return idKursi;
    }

    public void setIdKursi(String idKursi) {
        this.idKursi = idKursi;
    }

    public String getIdKereta() {
        return idKereta;
    }

    public void setIdKereta(String idKereta) {
        this.idKereta = idKereta;
    }

    public String getTglBerangkat() {
        return tglBerangkat;
    }

    public void setTglBerangkat(String tglBerangkat) {
        this.tglBerangkat = tglBerangkat;
    }
    
}
