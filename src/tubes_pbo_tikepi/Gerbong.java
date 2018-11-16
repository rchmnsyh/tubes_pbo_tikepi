/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_pbo_tikepi;

/**
 *
 * @author ahmad
 */
public class Gerbong {
    private String idGerbong;
    private String idKereta;
    private int noGerbong;
    private String statusGerbong;
    private int kapasitasGerbong;

    public Gerbong(String idGerbong, String idKereta, int noGerbong, String statusGerbong, int kapasitasGerbong) {
        this.idGerbong = idGerbong;
        this.idKereta = idKereta;
        this.noGerbong = noGerbong;
        this.statusGerbong = statusGerbong;
        this.kapasitasGerbong = kapasitasGerbong;
    }

    public String getIdGerbong() {
        return idGerbong;
    }

    public String getIdKereta() {
        return idKereta;
    }

    public int getNoGerbong() {
        return noGerbong;
    }

    public String getStatusGerbong() {
        return statusGerbong;
    }

    public int getKapasitasGerbong() {
        return kapasitasGerbong;
    }

    public void setIdGerbong(String idGerbong) {
        this.idGerbong = idGerbong;
    }

    public void setIdKereta(String idKereta) {
        this.idKereta = idKereta;
    }

    public void setNoGerbong(int noGerbong) {
        this.noGerbong = noGerbong;
    }

    public void setStatusGerbong(String statusGerbong) {
        this.statusGerbong = statusGerbong;
    }

    public void setKapasitasGerbong(int kapasitasGerbong) {
        this.kapasitasGerbong = kapasitasGerbong;
    }
    
    public void isiGerbong(String idKursi, int noGerbong){
        
    }    
}
