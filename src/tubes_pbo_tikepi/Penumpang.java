package tubes_pbo_tikepi;

/**
 *
 * @author wira
 */

public class Penumpang extends Manusia {
    private String idPenumpang;
    private String email;
    private Tiket[] Tiket;
    
    public Penumpang(String idPenumpang, String nama, String jenisKelamin, String tglLahir,
            String noHp, String alamat){
        this.idPenumpang = idPenumpang;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.tanggalLahir = tglLahir;
        this.noHp = noHp;
        this.alamat = alamat;
    }
    
    Penumpang(String idPenumpang, String nama, String tglLahir){
        this.idPenumpang = idPenumpang;
        this.nama = nama;
        this.tanggalLahir = tglLahir;
    }

    public String getIdPenumpang() {
        return idPenumpang;
    }

    public void setIdPenumpang(String idPenumpang) {
        this.idPenumpang = idPenumpang;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void pesanKereta(Tiket tik){
        
    }
    
    public Tiket infoTiket(){
        return null;
        
    }
}
