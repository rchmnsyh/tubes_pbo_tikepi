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
public class Stasiun {
    private String kodeStasiun;
    private String namaStasiun;
    private String alamatStasiun;
    private String kelasStasiun;
    private String daerahOperasi;

    public void setKodeStasiun(String kodeStasiun) {
        this.kodeStasiun = kodeStasiun;
    }

    public void setNamaStasiun(String namaStasiun) {
        this.namaStasiun = namaStasiun;
    }

    public void setKelasStasiun(String kelasStasiun) {
        this.kelasStasiun = kelasStasiun;
    }

    public void setAlamatStasiun(String alamatStasiun) {
        this.alamatStasiun = alamatStasiun;
    }

    public void setDaerahOperasi(String daerahOperasi) {
        this.daerahOperasi = daerahOperasi;
    }

    public String getKodeStasiun() {
        return kodeStasiun;
    }

    public String getNamaStasiun() {
        return namaStasiun;
    }

    public String getKelasStasiun() {
        return kelasStasiun;
    }

    public String getAlamatStasiun() {
        return alamatStasiun;
    }

    public String getDaerahOperasi() {
        return daerahOperasi;
    }

    public Stasiun(String kodeStasiun, String namaStasiun, String alamatStasiun, String kelasStasiun, String daerahOperasi) {
        this.kodeStasiun = kodeStasiun;
        this.namaStasiun = namaStasiun;
        this.kelasStasiun = kelasStasiun;
        this.alamatStasiun = alamatStasiun;
        this.daerahOperasi = daerahOperasi;
    }
}
