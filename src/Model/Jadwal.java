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
public class Jadwal {
    private String kodeJadwal;
    private String idKereta;
    private String jamBerangkat;
    private String jamTiba;
    private String stasiunAsal;
    private String stasiunTujuan;
    private String tglBerangkat;

    public Jadwal(String kodeJadwal, String idKereta, String stasiunAsal, String stasiunTujuan, String tglBerangkat, String jamBerangkat, String jamTiba) {
        this.kodeJadwal = kodeJadwal;
        this.idKereta = idKereta;
        this.jamBerangkat = jamBerangkat;
        this.jamTiba = jamTiba;
        this.stasiunAsal = stasiunAsal;
        this.stasiunTujuan = stasiunTujuan;
        this.tglBerangkat = tglBerangkat;
    }

    public String getStasiunTujuan() {
        return stasiunTujuan;
    }

    public void setStasiunTujuan(String stasiunTujuan) {
        this.stasiunTujuan = stasiunTujuan;
    }

    public String getKodeJadwal() {
        return kodeJadwal;
    }

    public void setKodeJadwal(String kodeJadwal) {
        this.kodeJadwal = kodeJadwal;
    }

    public String getJamBerangkat() {
        return jamBerangkat;
    }

    public void setJamBerangkat(String jamBerangkat) {
        this.jamBerangkat = jamBerangkat;
    }

    public String getJamTiba() {
        return jamTiba;
    }

    public void setJamTiba(String jamTiba) {
        this.jamTiba = jamTiba;
    }

    public String getStasiunAsal() {
        return stasiunAsal;
    }

    public void setStasiunAsal(String stasiunAsal) {
        this.stasiunAsal = stasiunAsal;
    }

    public String getTglBerangkat() {
        return tglBerangkat;
    }

    public void setTglBerangkat(String tglBerangkat) {
        this.tglBerangkat = tglBerangkat;
    }

    public String getIdKereta() {
        return idKereta;
    }

    public void setIdKereta(String idKereta) {
        this.idKereta = idKereta;
    }
    
    
}