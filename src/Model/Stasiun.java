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
    private String idStasiun;
    private String namaStasiun;
    private String kelasStasiun;
    private String alamatStasiun;
    private String daerahOperasi;

    public void setIdStasiun(String idStasiun) {
        this.idStasiun = idStasiun;
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

    public String getIdStasiun() {
        return idStasiun;
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

    public Stasiun(String idStasiun, String namaStasiun, String kelasStasiun, String alamatStasiun, String daerahOperasi) {
        this.idStasiun = idStasiun;
        this.namaStasiun = namaStasiun;
        this.kelasStasiun = kelasStasiun;
        this.alamatStasiun = alamatStasiun;
        this.daerahOperasi = daerahOperasi;
    }
}
