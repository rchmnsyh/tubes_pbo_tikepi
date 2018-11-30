package Model;

/**
 *
 * @author wira
 */

public class Penumpang extends Manusia {
    private String idPenumpang;
    private String jenisID;
    private String email;
    private int jumTiket;

    public Penumpang(String idPenumpang, String jenisID, String nama, String jenisKelamin, String tglLahir,
            String noHp, String email, String alamat){
        this.idPenumpang = idPenumpang;
        this.jenisID = jenisID;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.tanggalLahir = tglLahir;
        this.noHp = noHp;
        this.alamat = alamat;
        this.email = email;
    }
    
    Penumpang(String idPenumpang, String nama, String tglLahir, String email){
        this.idPenumpang = idPenumpang;
        this.nama = nama;
        this.tanggalLahir = tglLahir;
        this.email = email;
    }

    public String getIdPenumpang() {
        return idPenumpang;
    }

    public void setIdPenumpang(String idPenumpang) {
        this.idPenumpang = idPenumpang;
    }

    public String getJenisID() {
        return jenisID;
    }

    public void setJenisID(String tipeID) {
        this.jenisID = tipeID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getJumTiket() {
        return jumTiket;
    }

    public void setJumTiket(int jumTiket) {
        this.jumTiket = jumTiket;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    
    
}