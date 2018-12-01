/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ahmad
 */
public class Kereta {
    private String idKereta;
    private String namaKereta;
    private String kelasKereta;
    private int kapasitasKereta;

    public Kereta(String idKereta, String namaKereta, String kelasKereta, int kapasitasKereta) {
        this.idKereta = idKereta;
        this.namaKereta = namaKereta;
        this.kelasKereta = kelasKereta;
        this.kapasitasKereta = kapasitasKereta;
    }

    public String getIdKereta() {
        return idKereta;
    }

    public String getNamaKereta() {
        return namaKereta;
    }

    public String getKelasKereta() {
        return kelasKereta;
    }

    public int getKapasitasKereta() {
        return kapasitasKereta;
    }

    public void setIdKereta(String idKereta) {
        this.idKereta = idKereta;
    }

    public void setNamaKereta(String namaKereta) {
        this.namaKereta = namaKereta;
    }

    public void setKelasKereta(String kelasKereta) {
        this.kelasKereta = kelasKereta;
    }

    public void setKapasitasKereta(int kapasitasKereta) {
        this.kapasitasKereta = kapasitasKereta;
    } 
}
