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
public class Kursi {
    private String idKursi;
    private String idGerbong;
    private String kolomKursi;
    private String barisKursi;
    private String status;

    public Kursi(String idKursi, String idGerbong, String kolomKursi, String barisKursi, String status) {
        this.idKursi = idKursi;
        this.idGerbong = idGerbong;
        this.kolomKursi = kolomKursi;
        this.barisKursi = barisKursi;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdKursi() {
        return idKursi;
    }

    public void setIdKursi(String idKursi) {
        this.idKursi = idKursi;
    }

    public String getIdGerbong() {
        return idGerbong;
    }

    public void setIdGerbong(String idGerbong) {
        this.idGerbong = idGerbong;
    }

    public String getKolomKursi() {
        return kolomKursi;
    }

    public void setKolomKursi(String kolomKursi) {
        this.kolomKursi = kolomKursi;
    }

    public String getBarisKursi() {
        return barisKursi;
    }

    public void setBarisKursi(String barisKursi) {
        this.barisKursi = barisKursi;
    }
    
    public void isiKursi(Kursi kur, String idKursi, String status){
        kur.setStatus(status);
    }
}
